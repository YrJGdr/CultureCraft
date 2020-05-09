package cx.rain.mc.forgemod.chineseculture.tab;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.core.registry.RegistryItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabBlock extends CreativeTabs {
    public TabBlock() {
        super(ChineseCulture.MODID + ".tabs.block");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(RegistryItems.ITEMS.get("black_brick"));
    }
}
