package cx.rain.mc.forgemod.chineseculture.block.incomplete;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStove extends Block {
    public BlockStove() {
        super(Material.GROUND);
        this.setUnlocalizedName(ChineseCulture.MODID+":stove");
        this.setRegistryName(ChineseCulture.MODID, "stove");
        this.setHardness(5F);
        this.setLightLevel(1.0F);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}