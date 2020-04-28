package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBlackBrick extends Block {
    public BlockBlackBrick() {
        super(Material.GROUND);
        this.setUnlocalizedName(ChineseCulture.MODID+":blackBrick");
        this.setRegistryName(ChineseCulture.MODID, "black_brick");
        this.setHardness(1.5F);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
