package cx.rain.mc.forgemod.chineseculture.utility;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

/**
 * 矿石生成类
 */
public class WorldOreSpawn extends WorldGenerator {
    private int MaxY;
    private int SpawnTime;
    private int AddTime;
    private WorldGenMinable Generator;

    /**
     * @param MaxY 最大高度
     * @param SpawnTime 生成次数,为负则一个区块生成可能为1/|SpawnTime|，为正则一个区块生成|SpawnTime|/1次
     * @param Generator 生成器
     */
    public WorldOreSpawn(int MaxY, int SpawnTime,WorldGenMinable Generator)
    {
        this(MaxY,SpawnTime,1,Generator);
    }

    /**
     *
     * @param MaxY 最大高度
     * @param SpawnTime 生成次数,为负则一个区块生成可能为AddTime/|SpawnTime|，为正则一个区块生成|SpawnTime|/AddTime次
     * @param Generator 生成器
     * @param AddTime 若SpawnTime为负则一个区块生成可能为AddTime/|SpawnTime|，为正则一个区块生成|SpawnTime|/AddTime次
     */
    public WorldOreSpawn(int MaxY, int SpawnTime, int AddTime,WorldGenMinable Generator)
    {
        this.MaxY=MaxY;
        this.SpawnTime=SpawnTime;
        this.AddTime=AddTime;
        this.Generator=Generator;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (TerrainGen.generateOre(worldIn, rand, this, position, OreGenEvent.GenerateMinable.EventType.CUSTOM))
        {
            if(SpawnTime>=0)
            {
                for (int i = 0; i < SpawnTime; i+=AddTime)
                {
                    int posX = position.getX() + rand.nextInt(16);
                    int posY = rand.nextInt(MaxY-4)+4;
                    int posZ = position.getZ() + rand.nextInt(16);
                    BlockPos blockpos = new BlockPos(posX, posY, posZ);
                    Generator.generate(worldIn, rand, blockpos);
                }
            }
            else
            {
                if(rand.nextInt(-SpawnTime)<=AddTime)
                {
                    int posX = position.getX() + rand.nextInt(16);
                    int posY = rand.nextInt(MaxY-4)+4;
                    int posZ = position.getZ() + rand.nextInt(16);
                    BlockPos blockpos = new BlockPos(posX, posY, posZ);
                    Generator.generate(worldIn, rand, blockpos);
                }
            }
        }
        return true;
    }
}
