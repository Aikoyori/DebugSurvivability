package debugsurvivability.mixins;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.screen.ScreenTexts;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CreateWorldScreen.class)
public class BreakableDebugNoDebug {
    @ModifyArg(method = "startServer" ,at=@At(value="INVOKE",target = "Lnet/minecraft/client/gui/screen/world/CreateWorldScreen;createLevelInfo(Z)Lnet/minecraft/world/level/LevelInfo;"))
    private boolean injected(boolean debugWorld) {
        return false;
    }
    /*@ModifyArg(method = "init",at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/world/CreateWorldScreen;addDrawableChild(Lnet/minecraft/client/gui/Element;)Lnet/minecraft/client/gui/Element;"),index = 0)

    T addSpectatorMode(T drawableElement)
    {

        return ((Element & Drawable) CyclingButtonWidget.builder(CreateWorldScreen.Mode::asText).values((CreateWorldScreen.Mode[])new CreateWorldScreen.Mode[]{CreateWorldScreen.Mode.SURVIVAL, CreateWorldScreen.Mode.HARDCORE, CreateWorldScreen.Mode.CREATIVE}).initially(this.currentMode).narration(button -> ClickableWidget.getNarrationMessage(button.getMessage()).append(ScreenTexts.SENTENCE_SEPARATOR).append(this.firstGameModeDescriptionLine).append(" ").append(this.secondGameModeDescriptionLine)).build(i, 100, 150, 20, GAME_MODE_TEXT, (button, mode) -> this.tweakDefaultsTo((CreateWorldScreen.Mode)((Object)mode))));
    }*/
}
