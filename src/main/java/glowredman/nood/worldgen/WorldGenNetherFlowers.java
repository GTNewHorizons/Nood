package glowredman.nood.worldgen;

import java.util.Random;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNetherFlowers extends WorldGenerator {

    private final Block flower;

    public WorldGenNetherFlowers(boolean doBlockNotify, @Nonnull Block flower) {
        super(doBlockNotify);
        this.flower = flower;
    }

    @Override
    public boolean generate(World world, Random rng, int x, int y, int z) {
        boolean success = false;
        for (int i = 0; i < 8; i++) {
            int newX = x + rng.nextInt(15) - 7;
            int newY = y + rng.nextInt(7) - 3;
            int newZ = z + rng.nextInt(15) - 7;

            if (newY < 1 || newY > 254) {
                continue;
            }

            if (world.getBlock(newX, newY, newZ)
                .canPlaceBlockAt(world, newX, newY, newZ)) {
                this.setBlockAndNotifyAdequately(world, newX, newY, newZ, this.flower, 0);
                success = true;
            }
        }
        return success;
    }
}
