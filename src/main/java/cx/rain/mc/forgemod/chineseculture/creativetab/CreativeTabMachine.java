package cx.rain.mc.forgemod.chineseculture.creativetab;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabMachine extends CreativeTabs {
    public CreativeTabMachine() {
        super(ChineseCulture.MODID+":Machine");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Item.getByNameOrId(ChineseCulture.MODID+":stove"));
    }
}
