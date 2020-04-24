package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLiquor extends ItemFood {
    public ItemLiquor() {
        super(4, 0.3F, false);
        setUnlocalizedName("liquor");
        setRegistryName(ChineseCulture.MODID, "liquor");
        this.setAlwaysEdible();
        this.setCreativeTab(CreativeTabs.FOOD);
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {

           player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1200, 2 ));
           player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 500, 2 ));
           super.onFoodEaten(stack, world, player);
    }
}
