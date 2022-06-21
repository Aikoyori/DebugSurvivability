package debugsurvivability.mixins.legacy;

import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(World.class)
public class BreakableInDebugMixin {
    @Redirect(method="setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;II)Z",
            at=@At(value="INVOKE",target = "Lnet/minecraft/world/World;isDebugWorld()Z"))
    private boolean injectBlockState(World instance) {
        return false;
    }
}
