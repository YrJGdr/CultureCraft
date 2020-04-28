package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemTofu extends ItemFood {
    public ItemTofu() {
        super(2, 0.3F, false);
        this.setUnlocalizedName(ChineseCulture.MODID+":tofu");
        this.setRegistryName(ChineseCulture.MODID, "tofu");
        this.setCreativeTab(CreativeTabs.FOOD);
    }
}
