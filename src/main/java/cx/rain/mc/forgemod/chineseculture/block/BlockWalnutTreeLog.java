package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@ModBlock(name = "walnut_tree_log",translate = "walnutTreeLog")
public class BlockWalnutTreeLog extends Block {
    public BlockWalnutTreeLog() {
        super(Material.WOOD);
        this.setHardness(2.0F);
        this.setCreativeTab(Tabs.BLOCK);
    }
}