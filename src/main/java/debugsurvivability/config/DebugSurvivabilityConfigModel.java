package debugsurvivability.config;

import io.wispforest.owo.config.annotation.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;
import org.apache.logging.log4j.core.config.plugins.validation.Constraint;

@Modmenu(modId = "debugsurvivability")
@Config(name = "debugsurvivability", wrapperName = "DebugSurvivabilityConfig",defaultHook = true)
public class DebugSurvivabilityConfigModel {
    @SectionHeader("worldgen")
    public String barrierBlockType = "minecraft:barrier";
    public boolean generateNetherPortal = false;
    public boolean generateEndPortal = false;
    @SectionHeader("gridSizeConfig")
    public double gridXSize = -1;
    @RangeConstraint(min = 0, max = 384)
    public double gridYSize = 1;
    public double gridZSize = -1;
    @RangeConstraint(min = 0, max = 1000)
    public int gridGapX = 1;
    @RangeConstraint(min = 0, max = 384)
    public int gridGapY = 1;
    @RangeConstraint(min = 0, max = 1000)
    public int gridGapZ = 1;
    public int iterations = 1;
    public int blockSize = 1;
    @SectionHeader("misc")
    @RangeConstraint(min = -64, max = 319)
    @Hook
    public int barrierLevel = 60;
    @RangeConstraint(min = -64, max = 319)
    @Hook
    public int blocksLevel = 70;
    @RangeConstraint(min = -256, max = 512)
    @Hook
    public double voidDarknessLevel = 60;
}
