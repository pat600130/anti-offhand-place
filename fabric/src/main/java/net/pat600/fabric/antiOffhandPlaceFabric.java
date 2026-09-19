package net.pat600.fabric;

import net.fabricmc.api.ModInitializer;

import net.pat600.common.antiOffhandPlace;

public final class antiOffhandPlaceFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        antiOffhandPlace.init();
    }
}
