package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPottery extends Block {
    public BlockPottery() {
        super(Material.GROUND);
        this.setUnlocalizedName(ChineseCulture.MODID+":pottery");
        this.setRegistryName(ChineseCulture.MODID, "pottery");
        this.setHardness(0.5F);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
