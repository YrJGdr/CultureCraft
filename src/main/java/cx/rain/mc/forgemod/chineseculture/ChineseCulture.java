package cx.rain.mc.forgemod.chineseculture;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
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
}
