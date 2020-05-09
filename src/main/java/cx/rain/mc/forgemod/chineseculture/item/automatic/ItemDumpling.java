package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModItem;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.item.ItemFood;

@ModItem(name = "dumpling", translate = "dumpling")
public class ItemDumpling extends ItemFood {
    public ItemDumpling() {
        super(6, 0.8F, false);
        this.setCreativeTab(Tabs.FOOD);
    }
}
