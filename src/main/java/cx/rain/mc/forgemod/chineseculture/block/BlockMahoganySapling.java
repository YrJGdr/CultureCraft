package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import net.minecraft.block.BlockSapling;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

@ModBlock(name = "mahogany_sapling",translate = "mahoganySapling")
public class BlockMahoganySapling extends BlockSapling {
    public BlockMahoganySapling() {
        super();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this));
    }
}
