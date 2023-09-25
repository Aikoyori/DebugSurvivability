package debugsurvivability.mixins;

import net.minecraft.client.gui.screen.world.WorldCreator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldCreator.class)
public class WorldCreatorMixin {
    @Inject(method = "isDebug",at = @At("RETURN"),cancellable = true)
    void debugless(CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(false);
    }
}
