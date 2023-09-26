package debugsurvivability;

import debugsurvivability.config.DebugSurvivabilityConfig;
import io.wispforest.owo.config.ui.ConfigScreen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.screen.world.LevelScreenProvider;
import net.minecraft.world.gen.WorldPresets;

import java.util.Map;
import java.util.Optional;

public class Debuggability implements ModInitializer {
    public static final DebugSurvivabilityConfig DSCONFIG = DebugSurvivabilityConfig.createAndLoad();
    @Override
    public void onInitialize() {
        
    }
}
