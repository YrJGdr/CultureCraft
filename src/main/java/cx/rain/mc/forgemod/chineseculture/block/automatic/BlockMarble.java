package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMarble extends Block {
    public BlockMarble() {
        super(Material.GROUND);
        setUnlocalizedName("marble");
        setRegistryName(ChineseCulture.MODID, "marble");
        this.setHardness(2F);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
