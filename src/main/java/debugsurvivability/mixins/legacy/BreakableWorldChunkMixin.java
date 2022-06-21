package debugsurvivability.mixins.legacy;

import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldChunk.class)
public class BreakableWorldChunkMixin {
    @Redirect(method="getBlockState",at=@At(value = "INVOKE",target="Lnet/minecraft/world/World;isDebugWorld()Z"))
    public boolean serverChunks(World instance)
    {

        return false;
    }
}
