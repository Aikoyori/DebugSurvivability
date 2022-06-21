package debugsurvivability.mixins;

import net.minecraft.world.gen.GeneratorOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GeneratorOptions.class)
public class GeneratorOptionMixins {
    @Inject(method = "isDebugWorld",at = @At("RETURN"),cancellable = true)
    void debugless(CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(false);
    }
}
