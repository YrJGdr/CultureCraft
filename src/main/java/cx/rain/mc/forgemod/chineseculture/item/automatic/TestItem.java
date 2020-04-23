package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.item.Item;

public class TestItem extends Item {
    public TestItem() {
        super();
        setRegistryName(ChineseCulture.MODID, "placeholder_item");
    }
}
