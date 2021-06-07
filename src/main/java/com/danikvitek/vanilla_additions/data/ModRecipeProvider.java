package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import com.danikvitek.vanilla_additions.block.ModBlocks;
import com.danikvitek.vanilla_additions.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        newRecipes(consumer);
        replacedOldRecipes(consumer);
    }

    private static void newRecipes(Consumer<IFinishedRecipe> consumer){
        // Blackstone Furnace
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.BLACKSTONE_FURNACE.get())
                .key('B', Blocks.BLACKSTONE)
                .key('S', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .patternLine("BBB")
                .patternLine("BSB")
                .patternLine("BBB")
                .addCriterion("blackstone", hasItem(Blocks.BLACKSTONE))
                .addCriterion("soul_fire_block", hasItem(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .build(consumer);
        // Baobab Planks
        shapelessPlanks(consumer, ModBlocks.BAOBAB_PLANKS.get(), ModItemTags.BAOBAB_LOGS);
        // Baobab Wood
        shapedLogToWood(consumer, ModBlocks.BAOBAB_WOOD.get(), ModBlocks.BAOBAB_LOG.get());
        // Stripped Baobab Wood
        shapedLogToWood(consumer, ModBlocks.STRIPPED_BAOBAB_WOOD.get(), ModBlocks.STRIPPED_BAOBAB_LOG.get());
        // Sawmill
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SAWMILL.get())
                .key('#', Blocks.SMOOTH_STONE)
                .key('A', Blocks.ANDESITE_WALL)
                .key('C', Blocks.CHAIN)
                .key('_', Blocks.POLISHED_GRANITE_SLAB)
                .patternLine("#A ")
                .patternLine("AC ")
                .patternLine("___")
                .addCriterion("chain", hasItem(Blocks.CHAIN))
                .addCriterion("smooth_stone", hasItem(Blocks.SMOOTH_STONE))
                .addCriterion("polished_granite_slab", hasItem(Blocks.POLISHED_GRANITE_SLAB))
                .addCriterion("andesite_wall", hasItem(Blocks.ANDESITE_WALL))
                .build(consumer, new ResourceLocation(VanillaAdditionsMod.MOD_ID, "sawmill_left"));
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SAWMILL.get())
                .key('#', Blocks.SMOOTH_STONE)
                .key('A', Blocks.ANDESITE_WALL)
                .key('C', Blocks.CHAIN)
                .key('_', Blocks.POLISHED_GRANITE_SLAB)
                .patternLine(" A#")
                .patternLine(" CA")
                .patternLine("___")
                .addCriterion("chain", hasItem(Blocks.CHAIN))
                .addCriterion("smooth_stone", hasItem(Blocks.SMOOTH_STONE))
                .addCriterion("polished_granite_slab", hasItem(Blocks.POLISHED_GRANITE_SLAB))
                .addCriterion("andesite_wall", hasItem(Blocks.ANDESITE_WALL))
                .build(consumer, new ResourceLocation(VanillaAdditionsMod.MOD_ID, "sawmill_right"));
        // Blackstone Pickaxe
        ShapedRecipeBuilder.shapedRecipe(ModItems.BLACKSTONE_PICKAXE.get())
                .key('B', Blocks.BLACKSTONE)
                .key('/', Items.STICK)
                .patternLine("BBB")
                .patternLine(" / ")
                .patternLine(" / ")
                .addCriterion("blackstone", hasItem(Blocks.BLACKSTONE))
                .build(consumer);
        // Blackstone Axe
        ShapedRecipeBuilder.shapedRecipe(ModItems.BLACKSTONE_AXE.get())
                .key('B', Blocks.BLACKSTONE)
                .key('/', Items.STICK)
                .patternLine("BB")
                .patternLine("B/")
                .patternLine(" /")
                .addCriterion("blackstone", hasItem(Blocks.BLACKSTONE))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModItems.BLACKSTONE_AXE.get())
                .key('B', Blocks.BLACKSTONE)
                .key('/', Items.STICK)
                .patternLine("BB")
                .patternLine("/B")
                .patternLine("/ ")
                .addCriterion("blackstone", hasItem(Blocks.BLACKSTONE))
                .build(consumer, new ResourceLocation(VanillaAdditionsMod.MOD_ID, "blackstone_axe_alt"));
        // Blackstone Hoe
        ShapedRecipeBuilder.shapedRecipe(ModItems.BLACKSTONE_HOE.get())
                .key('B', Blocks.BLACKSTONE)
                .key('/', Items.STICK)
                .patternLine("BB")
                .patternLine(" /")
                .patternLine(" /")
                .addCriterion("blackstone", hasItem(Blocks.BLACKSTONE))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ModItems.BLACKSTONE_HOE.get())
                .key('B', Blocks.BLACKSTONE)
                .key('/', Items.STICK)
                .patternLine("BB")
                .patternLine("/ ")
                .patternLine("/ ")
                .addCriterion("blackstone", hasItem(Blocks.BLACKSTONE))
                .build(consumer, new ResourceLocation(VanillaAdditionsMod.MOD_ID, "blackstone_hoe_alt"));
        // Blackstone Shovel
        ShapedRecipeBuilder.shapedRecipe(ModItems.BLACKSTONE_SHOVEL.get())
                .key('B', Blocks.BLACKSTONE)
                .key('/', Items.STICK)
                .patternLine("B")
                .patternLine("/")
                .patternLine("/")
                .addCriterion("blackstone", hasItem(Blocks.BLACKSTONE))
                .build(consumer);
        // Blackstone Sword
        ShapedRecipeBuilder.shapedRecipe(ModItems.BLACKSTONE_SWORD.get())
                .key('B', Blocks.BLACKSTONE)
                .key('/', Items.STICK)
                .patternLine("B")
                .patternLine("B")
                .patternLine("/")
                .addCriterion("blackstone", hasItem(Blocks.BLACKSTONE))
                .build(consumer);

//        //Water from Wet Sponge
//        ShapedRecipeBuilder.shapedRecipe(Blocks.SPONGE)
//                .key('S', Blocks.WET_SPONGE)
//                .key('B', Items.BUCKET)
//                .patternLine("S")
//                .patternLine("B")
//                .addCriterion("sponge", hasItem(Blocks.WET_SPONGE))
//                .addCriterion("bucket", hasItem(Items.BUCKET))
//                .build(consumer);
//        ShapelessRecipeBuilder.shapelessRecipe(Blocks.WET_SPONGE)
//                .addIngredient(ModItemTags.BAOBAB_LOGS)
//                .addIngredient(Blocks.SPONGE)
//                .addCriterion("sponge", hasItem(Blocks.SPONGE))
//                .addCriterion("baobab_logs", hasItem(ModItemTags.BAOBAB_LOGS))
//                .build(consumer);

    }

//    private static void addWoodcutting(Consumer<IFinishedRecipe> consumer){
//        for (Item log: ItemTags.LOGS.getAllElements()){
//            Mod(log, log.)
//        }
//    }


    private static void replacedOldRecipes(Consumer<IFinishedRecipe> consumer){
        ShapedRecipeBuilder.shapedRecipe(Items.STONE_SWORD)
                .key('#', Items.STICK)
                .key('X', Items.COBBLESTONE)
                .patternLine("X")
                .patternLine("X")
                .patternLine("#")
                .addCriterion("has_cobblestone", hasItem(Items.COBBLESTONE))
                .build(consumer, new ResourceLocation("stone_sword"));
        ShapedRecipeBuilder.shapedRecipe(Items.STONE_SHOVEL)
                .key('#', Items.STICK)
                .key('X', Items.COBBLESTONE)
                .patternLine("X")
                .patternLine("#")
                .patternLine("#")
                .addCriterion("has_cobblestone", hasItem(Items.COBBLESTONE))
                .build(consumer, new ResourceLocation("stone_shovel"));
    }



    private static void shapelessPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider planks, ITag<Item> input) {
        ShapelessRecipeBuilder.shapelessRecipe(planks, 4)
                .addIngredient(input)
                .setGroup("planks")
                .addCriterion("has_log", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedLogToWood(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider wood, IItemProvider log) {
        ShapedRecipeBuilder.shapedRecipe(wood, 3)
                .key('#', log)
                .patternLine("##")
                .patternLine("##")
                .setGroup("bark")
                .addCriterion("has_log", hasItem(log)).build(recipeConsumer);
    }

    private static void shapedBoat(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider boat, IItemProvider input) {
        ShapedRecipeBuilder.shapedRecipe(boat)
                .key('#', input)
                .patternLine("# #")
                .patternLine("###")
                .setGroup("boat")
                .addCriterion("in_water", enteredBlock(Blocks.WATER)).build(recipeConsumer);
    }

    private static void shapelessWoodenButton(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider button, IItemProvider input) {
        ShapelessRecipeBuilder.shapelessRecipe(button).addIngredient(input).setGroup("wooden_button").addCriterion("has_planks", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedWoodenDoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider door, IItemProvider input) {
        ShapedRecipeBuilder.shapedRecipe(door, 3).key('#', input).patternLine("##").patternLine("##").patternLine("##").setGroup("wooden_door").addCriterion("has_planks", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedWoodenFence(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fence, IItemProvider input) {
        ShapedRecipeBuilder.shapedRecipe(fence, 3).key('#', Items.STICK).key('W', input).patternLine("W#W").patternLine("W#W").setGroup("wooden_fence").addCriterion("has_planks", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedWoodenFenceGate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fenceGate, IItemProvider input) {
        ShapedRecipeBuilder.shapedRecipe(fenceGate).key('#', Items.STICK).key('W', input).patternLine("#W#").patternLine("#W#").setGroup("wooden_fence_gate").addCriterion("has_planks", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedWoodenPressurePlate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider pressurePlate, IItemProvider input) {
        ShapedRecipeBuilder.shapedRecipe(pressurePlate).key('#', input).patternLine("##").setGroup("wooden_pressure_plate").addCriterion("has_planks", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedWoodenSlab(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider slab, IItemProvider input) {
        ShapedRecipeBuilder.shapedRecipe(slab, 6).key('#', input).patternLine("###").setGroup("wooden_slab").addCriterion("has_planks", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedWoodenStairs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider stairs, IItemProvider input) {
        ShapedRecipeBuilder.shapedRecipe(stairs, 4).key('#', input).patternLine("#  ").patternLine("## ").patternLine("###").setGroup("wooden_stairs").addCriterion("has_planks", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedWoodenTrapdoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider trapdoor, IItemProvider input) {
        ShapedRecipeBuilder.shapedRecipe(trapdoor, 2).key('#', input).patternLine("###").patternLine("###").setGroup("wooden_trapdoor").addCriterion("has_planks", hasItem(input)).build(recipeConsumer);
    }

    private static void shapedSign(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sign, IItemProvider input) {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        ShapedRecipeBuilder.shapedRecipe(sign, 3)
                .setGroup("sign")
                .key('#', input)
                .key('X', Items.STICK)
                .patternLine("###")
                .patternLine("###")
                .patternLine(" X ")
                .addCriterion("has_" + s, hasItem(input)).build(recipeConsumer);
    }
}
