package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockColouredGlaze extends Block {
    public BlockColouredGlaze() {
        super(Material.GROUND);
        this.setUnlocalizedName(ChineseCulture.MODID+":coloured_glaze");
        this.setRegistryName(ChineseCulture.MODID, "coloured_glaze");
        this.setHardness(2F);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
