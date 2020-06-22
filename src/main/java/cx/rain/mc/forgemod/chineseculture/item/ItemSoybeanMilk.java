package cx.rain.mc.forgemod.chineseculture.item;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModItem;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.item.ItemFood;

@ModItem(name = "soybean_milk",translate = "soybeanMilk")
public class ItemSoybeanMilk extends ItemFood {
    public ItemSoybeanMilk() {
        super(3, 0.2F, false);
        this.setCreativeTab(Tabs.FOOD);
    }
}