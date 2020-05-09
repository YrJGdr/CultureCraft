package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemCharredFood extends ItemFood {
    public ItemCharredFood() {
        super(1, 0, false);
        this.setUnlocalizedName(ChineseCulture.MODID+":charredFood");
        this.setRegistryName("charred_food");
        this.setCreativeTab(CreativeTabs.FOOD);
    }
}
