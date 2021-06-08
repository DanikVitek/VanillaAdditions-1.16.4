package com.danikvitek.vanilla_additions.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BaobabLog extends RotatedPillarBlock {
    public BaobabLog(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
        return toolType == ToolType.AXE ?
                ModBlocks.STRIPPED_BAOBAB_LOG.get().getDefaultState().with(AXIS, state.get(AXIS)):
                null;
    }
}
