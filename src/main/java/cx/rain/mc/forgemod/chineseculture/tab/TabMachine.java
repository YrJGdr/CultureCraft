package cx.rain.mc.forgemod.chineseculture.tab;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.core.registry.RegistryBlocks;
import cx.rain.mc.forgemod.chineseculture.core.registry.RegistryItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMachine extends CreativeTabs {
    public TabMachine() {
        super(ChineseCulture.MODID + ".tabs.machine");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(RegistryBlocks.BLOCKS.get("stove"));
    }
}
