package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTiles extends Block {
    public BlockTiles() {
        super(Material.GROUND);
        setUnlocalizedName("tile");
        setRegistryName(ChineseCulture.MODID, "tile");
        this.setHardness(1F);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
