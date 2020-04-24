package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.item.ItemFood;

public class ItemDoufu extends ItemFood {
    public ItemDoufu() {
        super(8, 0.3F, false);
        setUnlocalizedName("doufu");
        setRegistryName(ChineseCulture.MODID, "doufu");
    }
}
