package com.lothrazar.nolavabuild;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(LavaBlockMod.MODID)
public class LavaBlockMod {

  public static final String MODID = "nolavabuild";

  //TODO: config, fluid tag, lib power
  public LavaBlockMod() {
    NeoForge.EVENT_BUS.register(new LavaBlockEvent());
  }
}
