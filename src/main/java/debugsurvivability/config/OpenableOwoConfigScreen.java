package debugsurvivability.config;

import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.ui.ConfigScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class OpenableOwoConfigScreen extends ConfigScreen {
    protected OpenableOwoConfigScreen(Identifier modelId, ConfigWrapper<?> config, @Nullable Screen parent) {
        super(modelId, config, parent);
    }
}