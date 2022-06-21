package debugsurvivability.mixins;

import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ClientWorld.Properties.class)
public class ClientWorldDarknessMixin {
    @ModifyConstant(method = "getSkyDarknessHeight",constant = @Constant(doubleValue = 63.0))
    public double epilepsyFix(double constant){
        return 60.0;
    }
}
