package com.danikvitek.vanilla_additions.fluid;

import com.danikvitek.vanilla_additions.tileentity.MilkBlockTileEntity;
import com.danikvitek.vanilla_additions.tileentity.ModTileEntities;
import com.danikvitek.vanilla_additions.util.Config;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.PotionEvent;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Supplier;

public class MilkBlock extends FlowingFluidBlock
{
    public MilkBlock(Supplier<? extends FlowingFluid> supplier, Properties properties) {
        super(supplier, properties);
    }

    //TODO: decrease all effects' level by 1 when stand in milk every 10(?) ticks
    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote() && entityIn.isAlive() && MilkBlockTileEntity.MAX_TICKS_COUNTER != 0){
            int ticks = MilkBlockTileEntity.getTicks();
            if (Config.TICKS_PER_MILK_EFFECTS_REDUCE.get() != 0 && ticks % Config.TICKS_PER_MILK_EFFECTS_REDUCE.get() == 0)
//                reducePotionEffects(((LivingEntity) entityIn)); Todo: fix crashes
                ((LivingEntity) entityIn).curePotionEffects(Items.MILK_BUCKET.getDefaultInstance());
            if (Config.TICKS_PER_MILK_HEAL.get() != 0 && ticks % Config.TICKS_PER_MILK_HEAL.get() == 0)
                ((LivingEntity) entityIn).heal(Config.HALF_HEARTS_PER_MILK_HEAL.get());
        }
        super.onEntityCollision(state, worldIn, pos, entityIn);
    }

    protected void reducePotionEffects(LivingEntity entity)
    {
        // TODO: try to save effects list, cure all effects, add back only those effects that have amplifier > 0;
        if (!entity.getEntityWorld().isRemote) {
            Collection<EffectInstance> itr = entity.getActivePotionMap().values();
            for (EffectInstance effect : itr) {
//            EffectInstance effect = itr.next();
                if (
                        effect.isCurativeItem(Items.MILK_BUCKET.getDefaultInstance()) &&
                                !net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new PotionEvent.PotionRemoveEvent(entity, effect))
                ) {
                    if (effect.getAmplifier() >= 1) {
                        EffectInstance reduced_effect = new EffectInstance(
                                effect.getPotion(),
                                effect.getDuration(),
                                effect.getAmplifier() - 1);
                        if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(
                                new PotionEvent.PotionAddedEvent(entity, effect, reduced_effect))
                        ) {
                            entity.removePotionEffect(effect.getPotion());
                            entity.addPotionEffect(reduced_effect);
                        }
                    } else entity.removePotionEffect(effect.getPotion());
//                entity.sendMessage(new StringTextComponent(itr.toString()), entity.getUniqueID());
                }
            }
        }
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.MILK_TILE_ENTITY.get().create();
    }
}
