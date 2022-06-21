package debugsurvivability.mixins.legacy;

import net.minecraft.server.PlayerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerManager.class)
public class BreakablePlayerMixin {
    @ModifyArg(method = "onPlayerConnect",at=@At(value="INVOKE",target = "Lnet/minecraft/network/packet/s2c/play/GameJoinS2CPacket;<init>(IZLnet/minecraft/world/GameMode;Lnet/minecraft/world/GameMode;Ljava/util/Set;Lnet/minecraft/util/registry/DynamicRegistryManager$Immutable;Lnet/minecraft/util/registry/RegistryKey;Lnet/minecraft/util/registry/RegistryKey;JIIIZZZZLjava/util/Optional;)V"),index = 14)
    public boolean noDebugFuck(boolean deubg)
    {
        return false;
    }
    @ModifyArg(method = "respawnPlayer",at=@At(value="INVOKE",target = "Lnet/minecraft/network/packet/s2c/play/PlayerRespawnS2CPacket;<init>(Lnet/minecraft/util/registry/RegistryKey;Lnet/minecraft/util/registry/RegistryKey;JLnet/minecraft/world/GameMode;Lnet/minecraft/world/GameMode;ZZZLjava/util/Optional;)V"),index = 5)
    public boolean noDebugFuck2(boolean deubg)
    {
        return false;
    }
}
