package debugsurvivability.mixins.legacy;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(targets = "net.minecraft.client.render.chunk.RenderedChunk")
public class BreakableRenderedChunkMixin {
    /*
    @Redirect(method = "<init>(Lnet/minecraft/world/chunk/WorldChunk;)V",at=@At(value = "INVOKE",target="Lnet/minecraft/world/World;isDebugWorld()Z", shift = At.Shift.AFTER))
    public void lol(RenderedChunk instance, boolean value)
    {
        instance.debugWorld = false;
    }*/

    @ModifyVariable(method = "<init>", at = @At("STORE"), ordinal = 1)
    public boolean debugWorld(boolean value)
    {
        return false;
    }
}
