package cx.rain.mc.forgemod.chineseculture;

import cx.rain.mc.forgemod.chineseculture.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = ChineseCulture.MODID,
        name = ChineseCulture.NAME,
        version = ChineseCulture.FULL_VERSION,
        acceptedMinecraftVersions = ChineseCulture.MCVERSION
)
public class ChineseCulture {
    public static final String MODID = "chineseculture";
    public static final String NAME = "ChineseCulture";
    public static final String MCVERSION = "1.12.2";
    public static final String VERSION = "1.0.0";
    public static final String FULL_VERSION = MCVERSION + "-" + VERSION;

    @Instance(value = ChineseCulture.MODID, owner = ChineseCulture.MODID)
    public static ChineseCulture INSTANCE;

    private Logger logger = LogManager.getLogger(ChineseCulture.NAME);

    public Logger getLogger() {
        return logger;
    }

    @SidedProxy(clientSide = "cx.rain.mc.forgemod.chineseculture.proxy.ClientProxy",
        serverSide = "cx.rain.mc.forgemod.chineseculture.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
