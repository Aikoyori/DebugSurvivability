package debugsurvivability.mixins;

import net.minecraft.client.gui.screen.world.MoreOptionsDialog;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MoreOptionsDialog.class)
public class ShowMoreOptionsDebugMixin {
    @Inject(method="isDebugWorld",at=@At("HEAD"),cancellable = true)
    public void showMoreWorldOptions(CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(false);
    }
}
