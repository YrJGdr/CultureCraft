package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@ModBlock(name = "walnut_tree_leaf",translate = "walnutTreeLeaf")
public class BlockWalnutTreeLeaf extends Block {
    public BlockWalnutTreeLeaf() {
        super(Material.LEAVES);
        this.setHardness(0.5F);
        this.setCreativeTab(Tabs.BLOCK);
    }
}