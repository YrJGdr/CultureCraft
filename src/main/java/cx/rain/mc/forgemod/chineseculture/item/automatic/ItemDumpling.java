package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemDumpling extends ItemFood {
    public ItemDumpling() {
        super(8, 0.8F, false);
        setUnlocalizedName("dumpling");
        setRegistryName(ChineseCulture.MODID, "dumpling");
        this.setCreativeTab(CreativeTabs.FOOD);
    }
}
