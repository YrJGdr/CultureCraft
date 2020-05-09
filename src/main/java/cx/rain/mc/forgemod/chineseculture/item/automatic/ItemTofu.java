package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModItem;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.item.ItemFood;

@ModItem(name = "tofu", translate = "tofu")
public class ItemTofu extends ItemFood {
    public ItemTofu() {
        super(2, 0.3F, false);
        this.setCreativeTab(Tabs.FOOD);
    }
}
