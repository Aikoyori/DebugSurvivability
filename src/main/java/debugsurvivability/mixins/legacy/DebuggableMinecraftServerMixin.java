package debugsurvivability.mixins.legacy;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MinecraftServer.class)
public class DebuggableMinecraftServerMixin {
    /*
    @ModifyVariable(method="createWorlds",at = @At("STORE"),ordinal = 3)
    public boolean modifyDebug(boolean value)
    {

        return false;
    }*/
}
