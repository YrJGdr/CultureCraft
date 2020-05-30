package cx.rain.mc.forgemod.chineseculture.init;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.tileentity.TileEntityBlockStove;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryTileEntity {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void Registry(RegistryEvent.Register<Block> event){
        GameRegistry.registerTileEntity(TileEntityBlockStove.class, new ResourceLocation(ChineseCulture.MODID, "stove"));
    }
}
