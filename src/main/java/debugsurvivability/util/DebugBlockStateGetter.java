package debugsurvivability.util;

import debugsurvivability.Debuggability;
import debugsurvivability.config.DebugSurvivabilityConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DebugBlockStateGetter {
    public static List<BlockState> BLOCK_STATES = (List) StreamSupport.stream(Registries.BLOCK.spliterator(), false).flatMap((block) -> {
            return block.getStateManager().getStates().stream();
        }).collect(Collectors.toList());

    static int gapX = Debuggability.DSCONFIG.gridGapX()+1;
    static int gapY = Debuggability.DSCONFIG.gridGapY()+1;
    static int gapZ = Debuggability.DSCONFIG.gridGapZ()+1;
    static double sizeX = Debuggability.DSCONFIG.gridXSize() >= 0 ? Debuggability.DSCONFIG.gridXSize(): MathHelper.ceil(MathHelper.sqrt((float)BLOCK_STATES.size())) * MathHelper.abs((float) Debuggability.DSCONFIG.gridXSize());
    static double sizeY = Debuggability.DSCONFIG.gridYSize();
    static double sizeZ = Debuggability.DSCONFIG.gridZSize() >= 0 ? Debuggability.DSCONFIG.gridZSize(): MathHelper.ceil((float)BLOCK_STATES.size() / (float)sizeX) * MathHelper.abs((float) Debuggability.DSCONFIG.gridZSize());

    public static BlockState getBlockState(int x, int y, int z) {
        sizeX = Debuggability.DSCONFIG.gridXSize() >= 0 ? Debuggability.DSCONFIG.gridXSize(): MathHelper.ceil(MathHelper.sqrt((float)BLOCK_STATES.size())) * MathHelper.abs((float) Debuggability.DSCONFIG.gridXSize());
        sizeY = Debuggability.DSCONFIG.gridYSize();
        sizeZ = Debuggability.DSCONFIG.gridZSize() >= 0 ? Debuggability.DSCONFIG.gridZSize(): MathHelper.ceil((float)BLOCK_STATES.size() / (float)sizeX) * MathHelper.abs((float) Debuggability.DSCONFIG.gridZSize());

        gapX = Debuggability.DSCONFIG.gridGapX()+1;
        gapY = Debuggability.DSCONFIG.gridGapY()+1;
        gapZ = Debuggability.DSCONFIG.gridGapZ()+1;

        BlockState blockState = Blocks.AIR.getDefaultState();
        if (x >= 0 && y >= 0 && z >= 0 && x % gapX == 0 && y % gapY == 0 && z % gapZ == 0) {
            x /= (gapX);
            y /= (gapY);
            z /= (gapZ);
            if (x <= sizeX && y <= sizeY && z <= sizeZ) {
                int i = MathHelper.abs((int) (x * sizeX + y * sizeX * sizeZ + z));
                if (i < BLOCK_STATES.size()*Debuggability.DSCONFIG.iterations()) {
                    blockState = (BlockState)BLOCK_STATES.get(i%BLOCK_STATES.size());
                }
            }
        }

        return blockState;
    }
}
