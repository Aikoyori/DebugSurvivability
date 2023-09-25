package debugsurvivability.mixins;

import debugsurvivability.Debuggability;
import io.wispforest.owo.config.ui.ConfigScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.LevelScreenProvider;
import net.minecraft.client.gui.screen.world.WorldCreator;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Consumer;

@Mixin(CreateWorldScreen.WorldTab.class)
class ShowCustomizeWorld{
    @Shadow
    @Final
    CreateWorldScreen field_42182;
    @Inject(method = "openCustomizeScreen",at = @At("TAIL"),locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    void desu$openConfig(CallbackInfo ci, LevelScreenProvider levelScreenProvider){
        if (levelScreenProvider == null) {
            MinecraftClient.getInstance().send(() -> {
                MinecraftClient.getInstance().setScreen(ConfigScreen.create(Debuggability.DSCONFIG,field_42182));
            });
        }
    }
    @ModifyArg(method = "<init>",at = @At(value = "INVOKE",target = "Lnet/minecraft/client/gui/screen/world/WorldCreator;addListener(Ljava/util/function/Consumer;)V",ordinal = 1))
    Consumer<WorldCreator> desu$cd(Consumer<WorldCreator> listener){

        return (creator) -> {
            ((CreateWorldScreen.WorldTab)(Object)(this)).customizeButton.active = creator.getLevelScreenProvider() != null || creator.getGeneratorOptionsHolder().selectedDimensions().getChunkGenerator() instanceof DebugChunkGenerator;
        };
    }
}
