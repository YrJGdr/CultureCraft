package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@ModBlock(name = "mahogany_plank",translate = "mahoganyPlank")
public class BlockMahoganyPlank extends Block {
    public BlockMahoganyPlank() {
        super(Material.WOOD);
        this.setHardness(2.0F);
        this.setCreativeTab(Tabs.BLOCK);
    }
}