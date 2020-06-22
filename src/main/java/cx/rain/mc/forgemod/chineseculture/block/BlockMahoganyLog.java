package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@ModBlock(name = "mahogany_log",translate = "mahoganyLog")
public class BlockMahoganyLog extends Block {
    public BlockMahoganyLog() {
        super(Material.WOOD);
        this.setHardness(2.0F);
        this.setCreativeTab(Tabs.BLOCK);
    }
}
