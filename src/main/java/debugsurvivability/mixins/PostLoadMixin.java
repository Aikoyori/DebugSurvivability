package debugsurvivability.mixins;


import net.minecraft.Bootstrap;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Registries.class)

public class PostLoadMixin {
    @Inject(method = "bootstrap",
            at=@At(value = "INVOKE",target = "Lnet/minecraft/registry/Registries;freezeRegistries()V",shift = At.Shift.AFTER),locals = LocalCapture.CAPTURE_FAILSOFT
            ,cancellable = true)
    private static void debug$addLuigi(CallbackInfo ci){

    }
}
