package debugsurvivability.config;

import io.wispforest.owo.config.annotation.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;
@Modmenu(modId = "debugsurvivability")
@Config(name = "debugsurvivability", wrapperName = "DebugSurvivabilityConfig")
public class DebugSurvivabilityConfigModel {
    @SectionHeader("gridSizeConfig")
    @RestartRequired
    public int gridXSize = -1;
    @RangeConstraint(min = 0, max = 384)
    @RestartRequired
    public int gridYSize = 1;
    @RestartRequired
    public int gridZSize = -1;
    @RangeConstraint(min = 0, max = 1000)
    @RestartRequired
    public int gridGapX = 1;
    @RangeConstraint(min = 0, max = 384)
    @RestartRequired
    public int gridGapY = 1;
    @RangeConstraint(min = 0, max = 1000)
    @RestartRequired
    public int gridGapZ = 1;
    @RestartRequired
    public int iterations = 1;
    public int blockSize = 1;
    @SectionHeader("misc")
    @RangeConstraint(min = -64, max = 319)
    public int barrierLevel = 60;
    @RangeConstraint(min = -64, max = 319)
    public int blocksLevel = 70;
}
