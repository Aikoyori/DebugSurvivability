package debugsurvivability.mixins.legacy;

import net.minecraft.server.world.ServerChunkManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerChunkManager.class)
public class BreakableChunkTicksMixin {
    @ModifyVariable(method = "tickChunks", at = @At("STORE"), ordinal = 2)
    public boolean noFuckDebug(boolean b)
    {
        return false;
    }
}
