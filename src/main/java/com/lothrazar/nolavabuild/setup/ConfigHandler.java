package com.lothrazar.nolavabuild.setup;

import java.nio.file.Path;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.nolavabuild.LavaBlockMod;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {

  private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
  public static ForgeConfigSpec COMMON_CONFIG;
  //  public static ForgeConfigSpec.BooleanValue TOOLTIPS;
  static {
    initConfig();
  }

  private static void initConfig() {
    COMMON_BUILDER.comment("General settings").push(LavaBlockMod.MODID);
    //    TOOLTIPS = COMMON_BUILDER.comment("Testing config Tooltip").define("itemTooltip", true);
    COMMON_BUILDER.pop();
    COMMON_CONFIG = COMMON_BUILDER.build();
  }

  public static void loadConfig(ForgeConfigSpec spec, Path path) {
    final CommentedFileConfig configData = CommentedFileConfig.builder(path)
        .sync()
        .autosave()
        .writingMode(WritingMode.REPLACE)
        .build();
    configData.load();
    spec.setConfig(configData);
  }
}
