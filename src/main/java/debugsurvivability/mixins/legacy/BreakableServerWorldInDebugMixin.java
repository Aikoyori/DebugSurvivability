package debugsurvivability.mixins.legacy;

import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public class BreakableServerWorldInDebugMixin {
    @Redirect(method="tick",
            at=@At(value="INVOKE",target = "Lnet/minecraft/server/world/ServerWorld;isDebugWorld()Z"))
    private boolean injectTick(ServerWorld instance) {
        return false;
    }
    @Redirect(method="updateNeighbors",
            at=@At(value="INVOKE",target = "Lnet/minecraft/server/world/ServerWorld;isDebugWorld()Z"))
    private boolean injectUpdate(ServerWorld instance) {
        return false;
    }
}
