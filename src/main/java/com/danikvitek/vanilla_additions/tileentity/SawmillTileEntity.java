package com.danikvitek.vanilla_additions.tileentity;

import com.danikvitek.vanilla_additions.data.recipes.ModRecipeTypes;
import com.danikvitek.vanilla_additions.data.recipes.SawmillRecipe;
import com.danikvitek.vanilla_additions.item.ModItems;
import com.danikvitek.vanilla_additions.network.ItemMessage;
import com.danikvitek.vanilla_additions.network.ModPacketHandler;
import jdk.jfr.internal.tool.PrettyWriter;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SawmillTileEntity extends TileEntity implements ITickableTileEntity
{

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public SawmillTileEntity(){
        this(ModTileEntities.SAWMILL_TILE_ENTITY.get());
    }

    public int getSizeInventory() {
        return 5;
    }

    public SawmillTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(2){
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if(slot == 0) {
                    return stack.getItem().isIn(ItemTags.PLANKS) ||
                           stack.getItem().isIn(ItemTags.LOGS);
                }
                else if(slot == 1) {
                    return stack.getItem() == ModItems.BLACKSTONE_SHOVEL.get()
                            || stack.getItem() == ModItems.BLACKSTONE_PICKAXE.get();
                } else return false;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return handler.cast();
        return super.getCapability(cap, side);
    }

    public void updateInventory(int flags, boolean shouldCraft) {
        if (shouldCraft) {
            craft();
        } else {
            this.updateInventoryNetwork(flags, false);
        }
    }

    public void craft() {
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }

        Optional<SawmillRecipe> recipe = world.getRecipeManager()
                .getRecipe(ModRecipeTypes.SAWMILL_RECIPE, inv, world);

        recipe.ifPresent(iRecipe -> {
            ItemStack output = iRecipe.getRecipeOutput();

            if (inv.getStackInSlot(1).isEmpty()) {
                itemHandler.extractItem(0, 1, false);
                itemHandler.insertItem(1, output, false);
            }
        });

    }

    public void updateInventoryNetwork(int flags, boolean shouldCraft) {
        if (flags == -1) {
            for (int i = 0; i < getSizeInventory(); i++) {
                ModPacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new ItemMessage(itemHandler.getStackInSlot(i), pos, i));
            }
        } else {
            ModPacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new ItemMessage(itemHandler.getStackInSlot(flags), pos, flags));
        }
    }

    public void setItem(int index, ItemStack stack) {
        itemHandler.setStackInSlot(index, stack);
    }

    @Override
    public void tick()
    {
        if(world.isRemote)
            return;

        updateInventory(-1, true);
        markDirty();
    }
}
