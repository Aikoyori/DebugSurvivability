package debugsurvivability.mixins.legacy;

import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ServerPlayerEntity.class)
public class BreakableServerPlayerMixin {
    @ModifyArg(method = "teleport",at=@At(value="INVOKE",target = "Lnet/minecraft/network/packet/s2c/play/PlayerRespawnS2CPacket;<init>(Lnet/minecraft/util/registry/RegistryKey;Lnet/minecraft/util/registry/RegistryKey;JLnet/minecraft/world/GameMode;Lnet/minecraft/world/GameMode;ZZZLjava/util/Optional;)V"),index = 5)
    public boolean noDebugFuck(boolean deubg)
    {
        return false;
    }
    @ModifyArg(method = "moveToWorld",at=@At(value="INVOKE",target = "Lnet/minecraft/network/packet/s2c/play/PlayerRespawnS2CPacket;<init>(Lnet/minecraft/util/registry/RegistryKey;Lnet/minecraft/util/registry/RegistryKey;JLnet/minecraft/world/GameMode;Lnet/minecraft/world/GameMode;ZZZLjava/util/Optional;)V"),index = 5)
    public boolean noDebugFuck2(boolean deubg)
    {
        return false;
    }
}
