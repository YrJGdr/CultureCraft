package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPorcelain extends Block {
    public BlockPorcelain() {
        super(Material.GROUND);
        setUnlocalizedName("porcelain");
        setRegistryName(ChineseCulture.MODID, "porcelain");
        this.setHardness(0.5F);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
