package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@ModBlock(name = "mahogany_leaf",translate = "mahoganyLeaf")
public class BlockMahoganyLeaf extends Block {
    public BlockMahoganyLeaf() {
        super(Material.LEAVES);
        this.setHardness(0.2F);
        this.setCreativeTab(Tabs.BLOCK);
    }
}