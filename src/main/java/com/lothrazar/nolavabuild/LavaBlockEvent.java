package com.lothrazar.nolavabuild;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LavaBlockEvent {

  @SubscribeEvent
  public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
    BlockState current = event.getLevel().getBlockState(event.getPos().relative(event.getFace()));
    if (current.getBlock() == Blocks.LAVA && current.getFluidState().isSource()) {
      event.setCanceled(true);
    }
  }
}
