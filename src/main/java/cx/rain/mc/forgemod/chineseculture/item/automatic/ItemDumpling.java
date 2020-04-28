package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemDumpling extends ItemFood {
    public ItemDumpling() {
        super(6, 0.8F, false);
        this.setUnlocalizedName(ChineseCulture.MODID+":dumpling");
        this.setRegistryName(ChineseCulture.MODID, "dumpling");
        this.setCreativeTab(CreativeTabs.FOOD);
    }
}
