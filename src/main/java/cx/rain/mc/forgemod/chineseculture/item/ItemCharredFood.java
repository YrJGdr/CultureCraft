package cx.rain.mc.forgemod.chineseculture.item;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModItem;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.item.ItemFood;

@ModItem(name = "charred_food", translate = "charredFood")
public class ItemCharredFood extends ItemFood {
    public ItemCharredFood() {
        super(1, 0, false);
        this.setCreativeTab(Tabs.FOOD);
    }
}
