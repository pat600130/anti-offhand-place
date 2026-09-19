package net.pat600.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.pat600.common.antiOffhandPlace;

@Mod(antiOffhandPlace.MOD_ID)
public final class antiOffhandPlaceForge {
    public antiOffhandPlaceForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(antiOffhandPlace.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        antiOffhandPlace.init();
    }
}
