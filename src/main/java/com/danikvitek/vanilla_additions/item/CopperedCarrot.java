package com.danikvitek.vanilla_additions.item;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.util.Config;
import com.danikvitek.vanilla_additions.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class CopperedCarrot extends Item {
    public CopperedCarrot() {
        super(
                new Properties().group(VanillaAdditionsMod.COURSE_TAB)
                .food(new Food.Builder()
                    .hunger(5)
                    .saturation(1.5f)
                    .effect(
                            () -> new EffectInstance(
                                    Effects.NIGHT_VISION, Config.COPPERED_NIGHT_VISION_DURATION.get(), 0
                            ),
                            Config.COPPERED_NIGHT_VISION_CHANCE.get().floatValue() // probability
                    )
                    .effect(
                        () -> new EffectInstance(
                            Effects.GLOWING, Config.COPPERED_GLOW_DURATION.get(), 0
                        ),
                        Config.COPPERED_GLOWING_CHANCE.get().floatValue() // probability
                    )
                    .build()
                )
        );
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        if(KeyboardHelper.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("\u00A7e"+"Gives better vision " + "\u00A77"+"(may make you shine)"));
        }
        else
        {
            tooltip.add(new StringTextComponent("\u00A77"+"Hold" + "\u00A7e"+" SHIFT " + "\u00A77"+"for more information!"));
        }

        super.addInformation(stack, world, tooltip, flag);
    }
}
