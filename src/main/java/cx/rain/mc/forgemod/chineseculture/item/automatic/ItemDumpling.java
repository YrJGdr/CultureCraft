package cx.rain.mc.forgemod.chineseculture.item.automatic;

import net.minecraft.item.ItemFood;


public class ItemDumpling extends ItemFood {
    public ItemDumpling(int hungerHeal, float saturation, boolean isWolfFood) {
        super(8, 0.8F, false);
        this.setUnlocalizedName("dumpling");
    }


}
