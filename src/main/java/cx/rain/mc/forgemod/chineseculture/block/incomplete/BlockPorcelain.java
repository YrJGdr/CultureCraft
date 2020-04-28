package cx.rain.mc.forgemod.chineseculture.block.incomplete;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPorcelain extends Block {
    public BlockPorcelain() {
        super(Material.GROUND);
        this.setUnlocalizedName(ChineseCulture.MODID+":porcelain");
        this.setRegistryName(ChineseCulture.MODID, "porcelain");
        this.setHardness(0.5F);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
