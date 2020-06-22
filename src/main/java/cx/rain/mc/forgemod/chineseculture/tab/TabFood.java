package cx.rain.mc.forgemod.chineseculture.tab;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.core.registry.RegistryItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabFood extends CreativeTabs {
    public TabFood() {
        super(ChineseCulture.MODID + ".tabs.food");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(RegistryItems.ITEMS.get("dumpling"));
    }
}