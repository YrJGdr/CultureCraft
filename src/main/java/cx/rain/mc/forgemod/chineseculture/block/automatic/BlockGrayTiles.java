package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGrayTiles extends Block {
    public BlockGrayTiles() {
        super(Material.GROUND);
        setUnlocalizedName("gray_tiles");
        setRegistryName(ChineseCulture.MODID, "gray_tiles");
        this.setHardness(1.5F);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
