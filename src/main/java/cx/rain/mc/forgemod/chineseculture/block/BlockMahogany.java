package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMahogany extends Block {
    public BlockMahogany() {
        super(Material.GROUND);
        this.setUnlocalizedName(ChineseCulture.MODID+":mahogany");
        this.setRegistryName(ChineseCulture.MODID, "mahogany");
        this.setHardness(1.5F);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
