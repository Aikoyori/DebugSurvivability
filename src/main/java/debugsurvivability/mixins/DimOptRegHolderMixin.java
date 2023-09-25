package debugsurvivability.mixins;

import net.minecraft.registry.Registry;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionOptionsRegistryHolder;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionOptionsRegistryHolder.class)
public class DimOptRegHolderMixin {
    @Inject(method = "isDebug",cancellable = true,at=@At("HEAD"))
    public void desu$totallyNotDebug(CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(false);
    }
    @Inject(method = "getSpecialProperty",cancellable = true,at = @At("RETURN"))
    private static void desu$special(Registry<DimensionOptions> dimensionOptionsRegistry, CallbackInfoReturnable<LevelProperties.SpecialProperty> cir){
        if(cir.getReturnValue() == LevelProperties.SpecialProperty.DEBUG) cir.setReturnValue(LevelProperties.SpecialProperty.NONE);
    }
}
