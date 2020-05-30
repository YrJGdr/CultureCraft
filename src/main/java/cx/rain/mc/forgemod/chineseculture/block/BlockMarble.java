package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@ModBlock(name = "marble", translate = "marble")
public class BlockMarble extends Block {
    public BlockMarble() {
        super(Material.GROUND);
        this.setHardness(2F);
        this.setHarvestLevel("pickaxe",1);
        this.setCreativeTab(Tabs.BLOCK);
    }
}
