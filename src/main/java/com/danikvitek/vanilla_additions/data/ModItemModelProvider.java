package com.danikvitek.vanilla_additions.data;

import com.danikvitek.vanilla_additions.VanillaAdditionsMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, VanillaAdditionsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("baobab_leaves", modLoc("block/baobab_leaves"));
        withExistingParent("baobab_planks", modLoc("block/baobab_planks"));
        withExistingParent("baobab_log", modLoc("block/baobab_log"));
        withExistingParent("baobab_wood", modLoc("block/baobab_wood"));
        withExistingParent("stripped_baobab_log", modLoc("block/stripped_baobab_log"));
        withExistingParent("stripped_baobab_wood", modLoc("block/stripped_baobab_wood"));
        withExistingParent("sawmill", modLoc("block/sawmill"));
        withExistingParent("glass_stairs", modLoc("block/glass_stairs"));
        withExistingParent("glass_slab", modLoc("block/glass_slab"));
        withExistingParent("blackstone_furnace", modLoc("block/blackstone_furnace_off"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "blackstone_sword");
        builder(itemGenerated, "blackstone_axe");
        builder(itemGenerated, "blackstone_pickaxe");
        builder(itemGenerated, "blackstone_shovel");
        builder(itemGenerated, "blackstone_hoe");
        getBuilder("baobab_sapling").parent(itemGenerated).texture("layer0", "block/baobab_sapling");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name){
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
