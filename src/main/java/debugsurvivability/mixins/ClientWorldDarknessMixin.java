package debugsurvivability.mixins;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.HeightLimitView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientWorld.Properties.class)
public class ClientWorldDarknessMixin {/*
    @ModifyConstant(method = "getSkyDarknessHeight",constant = @Constant(doubleValue = 63.0))
    public double epilepsyFix(double constant){
        return 60.0;
    }*/
    @Inject(method = "getSkyDarknessHeight",at=@At("HEAD"),cancellable = true)
    public void debugSurv$skynoflashy(HeightLimitView world, CallbackInfoReturnable<Double> cir)
    {
        cir.setReturnValue(60d);
    }
}
