package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPottery extends Block {
    public BlockPottery() {
        super(Material.GROUND);
        setUnlocalizedName("pottery");
        setRegistryName(ChineseCulture.MODID, "pottery");
        this.setHardness(0.5F);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
