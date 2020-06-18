package cx.rain.mc.forgemod.chineseculture.api.game.capability;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class FuelStackHandler extends ItemStackHandler {
    public FuelStackHandler(int size){
        super(size);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (stack.isEmpty()){
            stacks.set(slot,ItemStack.EMPTY);
            return ItemStack.EMPTY;
        }

        if (TileEntityFurnace.isItemFuel(stack)&&stacks.get(slot).isEmpty()){
            super.insertItem(slot,new ItemStack(stack.getItem(),1),simulate);
            ChineseCulture.INSTANCE.getLogger().info("Add:" + stack.getDisplayName() + " in slot" + slot);
            stack.shrink(1);
        }
        return stack;
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return stacks.get(slot);
    }

    @Override
    public int getSlotLimit(int slot) {
        return 1;
    }
}
