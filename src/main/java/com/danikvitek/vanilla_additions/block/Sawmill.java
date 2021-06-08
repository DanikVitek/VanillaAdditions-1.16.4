package com.danikvitek.vanilla_additions.block;

import com.danikvitek.vanilla_additions.container.SawmillContainer;
import com.danikvitek.vanilla_additions.stats.ModStats;
import com.danikvitek.vanilla_additions.tileentity.ModTileEntities;
import com.danikvitek.vanilla_additions.tileentity.SawmillTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.StonecutterContainer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Sawmill extends Block {
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public Sawmill(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            case NORTH:
                return SHAPE_N;
            case WEST:
                return SHAPE_W;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.with(FACING, direction.rotate(state.get(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.SAWMILL_TILE_ENTITY.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote())
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof SawmillTileEntity)
            {
                INamedContainerProvider containerProvider = new INamedContainerProvider()
                {
                    @Override
                    public ITextComponent getDisplayName()
                    {
                        return new TranslationTextComponent("screen.vanilla_additions.sawmill");
                    }

                    @Override
                    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
                    {
                        return new SawmillContainer(i, worldIn, pos, playerInventory, playerEntity);
                    }
                };
                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
                player.addStat(ModStats.INTERACT_WITH_SAWMILL);
            }
            else
            {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return ActionResultType.SUCCESS;
    }

    @SuppressWarnings("deprecation")
    @Nullable
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider(
                (id, inventory, player) -> new StonecutterContainer(id, inventory, IWorldPosCallable.of(worldIn, pos)),
                new TranslationTextComponent("container.vanilla_additions.sawmill")
        );
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(6, 15, 3, 10, 19, 12),
            Block.makeCuboidShape(6, 4, 12, 10, 15, 12),
            Block.makeCuboidShape(6, 4, 12, 10, 19, 16),
            Block.makeCuboidShape(7, 4, 5.5, 9, 15, 5.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(3, 15, 6, 12, 19, 10),
            Block.makeCuboidShape(12, 4, 6, 12, 15, 10),
            Block.makeCuboidShape(12, 4, 6, 16, 19, 10),
            Block.makeCuboidShape(5.5, 4, 7, 5.5, 15, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(6, 15, 4, 10, 19, 13),
            Block.makeCuboidShape(6, 4, 4, 10, 15, 4),
            Block.makeCuboidShape(6, 4, 0, 10, 19, 4),
            Block.makeCuboidShape(7, 4, 10.5, 9, 15, 10.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(4, 15, 6, 13, 19, 10),
            Block.makeCuboidShape(4, 4, 6, 4, 15, 10),
            Block.makeCuboidShape(0, 4, 6, 4, 19, 10),
            Block.makeCuboidShape(10.5, 4, 7, 10.5, 15, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
}
