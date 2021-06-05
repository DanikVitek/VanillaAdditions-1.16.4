package com.danikvitek.vanilla_additions.item;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.util.Registration;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> BLACKSTONE_SHOVEL =
            Registration.ITEMS.register(
                    "blackstone_shovel",
                    () -> new ShovelItem(
                            ItemTier.STONE,
                            1.5f,
                            -3,
                            new Item.Properties()
                                    .group(VanillaAdditionsMod.VANILLA_ADDITIONS_TAB)
                                    .defaultMaxDamage(131)
                                    .addToolType(ToolType.SHOVEL, 2)
                    )
            );
    public static final RegistryObject<Item> BLACKSTONE_PICKAXE =
            Registration.ITEMS.register(
                    "blackstone_pickaxe",
                    () -> new PickaxeItem(
                            ItemTier.STONE,
                            1,
                            -2.8f,
                            new Item.Properties()
                            .group(VanillaAdditionsMod.VANILLA_ADDITIONS_TAB)
                            .defaultMaxDamage(131)
                            .addToolType(ToolType.PICKAXE, 2)
                    )
            );
    public static final RegistryObject<Item> BLACKSTONE_AXE =
            Registration.ITEMS.register(
                    "blackstone_axe",
                    () -> new AxeItem(
                            ItemTier.STONE,
                            7,
                            -3.2f,
                            new Item.Properties()
                                    .group(VanillaAdditionsMod.VANILLA_ADDITIONS_TAB)
                                    .defaultMaxDamage(131)
                                    .addToolType(ToolType.AXE, 2)
                    )
            );
    public static final RegistryObject<Item> BLACKSTONE_HOE =
            Registration.ITEMS.register(
                    "blackstone_hoe",
                    () -> new HoeItem(
                            ItemTier.STONE,
                            -1,
                            -2f,
                            new Item.Properties()
                                    .group(VanillaAdditionsMod.VANILLA_ADDITIONS_TAB)
                                    .defaultMaxDamage(131)
                                    .addToolType(ToolType.HOE, 2)
                    )
            );
    public static final RegistryObject<Item> BLACKSTONE_SWORD =
            Registration.ITEMS.register(
                    "blackstone_sword",
                    () -> new SwordItem(
                            ItemTier.STONE,
                            3,
                            -2.4f,
                            new Item.Properties()
                                    .group(VanillaAdditionsMod.VANILLA_ADDITIONS_TAB)
                                    .defaultMaxDamage(131)
                    )
            );


    public static void register() {}
}
