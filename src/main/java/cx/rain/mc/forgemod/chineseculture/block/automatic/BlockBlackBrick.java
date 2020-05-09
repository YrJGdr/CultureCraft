package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@ModBlock(name = "black_brick", translate = "black_brick")
public class BlockBlackBrick extends Block {
    public BlockBlackBrick() {
        super(Material.GROUND);
        this.setHarvestLevel("pickaxe",1);
        this.setHardness(1.5F);
        this.setCreativeTab(Tabs.BLOCK);
    }
}
