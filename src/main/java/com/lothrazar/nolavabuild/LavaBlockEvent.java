package com.lothrazar.nolavabuild;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class LavaBlockEvent {

  @SubscribeEvent
  public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
    BlockState current = event.getLevel().getBlockState(event.getPos().relative(event.getFace()));
    if (current.getBlock() == Blocks.LAVA && current.getFluidState().isSource()) {
      event.setCanceled(true);
    }
  }

  @SubscribeEvent
  public void onFallingBlockTick(EntityTickEvent.Pre event) {
    if (!(event.getEntity() instanceof FallingBlockEntity falling)) return;
    BlockPos pos = falling.blockPosition();
    BlockState at = falling.level().getBlockState(pos);
    if (at.getBlock() == Blocks.LAVA && at.getFluidState().isSource()) {
      Block.dropResources(falling.getBlockState(), falling.level(), pos);
      falling.discard();
    }
  }
}
