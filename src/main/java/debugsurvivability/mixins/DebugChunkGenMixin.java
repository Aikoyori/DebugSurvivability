package debugsurvivability.mixins;

import debugsurvivability.Debuggability;
import debugsurvivability.config.DebugSurvivabilityConfig;
import debugsurvivability.util.DebugBlockStateGetter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DebugChunkGenerator.class)
public abstract class DebugChunkGenMixin extends ChunkGenerator {
    public DebugChunkGenMixin(BiomeSource biomeSource) {
        super(biomeSource);
    }

    @Inject(method = "generateFeatures",at=@At("HEAD"), cancellable = true)
    void desu$genFeat(StructureWorldAccess world, Chunk chunk, StructureAccessor structureAccessor, CallbackInfo ci){

        BlockPos.Mutable mutable = new BlockPos.Mutable();
        ChunkPos chunkPos = chunk.getPos();
        int chunkX = chunkPos.x;
        int chunkZ = chunkPos.z;

        for(int iterY = 0; iterY < Debuggability.DSCONFIG.gridYSize(); iterY++) {
            for(int iterX = 0; iterX < 16; iterX++) {
                for(int iterZ = 0; iterZ < 16; iterZ++) {
                    int realX = ChunkSectionPos.getOffsetPos(chunkX, iterX);
                    int realZ = ChunkSectionPos.getOffsetPos(chunkZ, iterZ);
                    world.setBlockState(mutable.set(realX, Debuggability.DSCONFIG.barrierLevel(), realZ), Registries.BLOCK.get(new Identifier(Debuggability.DSCONFIG.barrierBlockType())).getDefaultState(), Block.NOTIFY_LISTENERS);
                    BlockState blockState = DebugBlockStateGetter.getBlockState(realX, iterY, realZ);
                    world.setBlockState(mutable.set(realX, Debuggability.DSCONFIG.blocksLevel()+iterY, realZ), blockState, Block.NOTIFY_LISTENERS);
                }
            }
        }
        super.generateFeatures(world, chunk, structureAccessor);
        ci.cancel();
    }
}
