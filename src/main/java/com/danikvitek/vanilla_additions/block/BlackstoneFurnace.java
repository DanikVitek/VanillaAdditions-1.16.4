package com.danikvitek.vanilla_additions.block;

import com.danikvitek.vanilla_additions.stats.ModStats;
import com.danikvitek.vanilla_additions.tileentity.BlackstoneFurnaceTileEntity;
import com.danikvitek.vanilla_additions.util.Config;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.Random;
import java.util.function.ToIntFunction;

public class BlackstoneFurnace extends FurnaceBlock {
    public BlackstoneFurnace() {
        super(
                AbstractBlock.Properties
                        .create(Material.ROCK)
                        .setRequiresTool()
                        .hardnessAndResistance(3.5F)
                        .setLightLevel(getLightValueLit(Config.BLACKSTONE_FURNACE_LIGHT_LEVEL.get()))
        );
        this.setDefaultState(
                this.stateContainer.getBaseState()
                    .with(LIT, false)
        );
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.get(BlockStateProperties.LIT) ? lightValue : 0;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote())
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof BlackstoneFurnaceTileEntity)
            {
                INamedContainerProvider containerProvider = new INamedContainerProvider() {
                    @Override
                    public ITextComponent getDisplayName() {
                        return new TranslationTextComponent("screen.vanilla_additions.blackstone_furnace");
                    }

                    @Override
                    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity player) {
                        return new FurnaceContainer(
                                windowId,
                                playerInventory,
                                ((BlackstoneFurnaceTileEntity)tileEntity),
                                ((BlackstoneFurnaceTileEntity)tileEntity).getData()
                        );
                    }
                };
                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, pos);
                player.addStat(ModStats.INTERACT_WITH_BLACKSTONE_FURNACE);
            }
            else
            {
                throw new IllegalStateException("Our Container provider is missing");
            }
            return ActionResultType.CONSUME;
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new BlackstoneFurnaceTileEntity();
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(LIT)) {
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY();
            double d2 = (double)pos.getZ() + 0.5D;
            if (rand.nextDouble() < 0.1D) {
                worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = stateIn.get(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getXOffset() * 0.52D : d4;
            double d6 = rand.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getZOffset() * 0.52D : d4;
            worldIn.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    }
}
