package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSpirits extends ItemFood {
    public ItemSpirits() {
        super(4, 0.3F, false);
        this.setUnlocalizedName(ChineseCulture.MODID+":spirits");
        this.setRegistryName(ChineseCulture.MODID, "spirits");
        this.setAlwaysEdible();
        this.setCreativeTab(CreativeTabs.FOOD);
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
           player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 500, 2 ));
           player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 2 ));
           player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 500, 2 ));
           player.addPotionEffect(new PotionEffect(MobEffects.POISON, 1000, 1 ));
           super.onFoodEaten(stack, world, player);
    }
}
