package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGrayTiles extends Block {
    public BlockGrayTiles() {
        super(Material.GROUND);
        this.setUnlocalizedName(ChineseCulture.MODID+":grayTiles");
        this.setRegistryName(ChineseCulture.MODID, "gray_tiles");
        this.setHardness(1.5F);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
