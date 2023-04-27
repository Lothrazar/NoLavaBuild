package com.lothrazar.nolavabuild;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(LavaBlockMod.MODID)
public class LavaBlockMod {

  public static final String MODID = "nolavabuild";

  //TODO: config, fluid tag, lib power
  public LavaBlockMod() {
    MinecraftForge.EVENT_BUS.register(new LavaBlockEvent());
  }
}
