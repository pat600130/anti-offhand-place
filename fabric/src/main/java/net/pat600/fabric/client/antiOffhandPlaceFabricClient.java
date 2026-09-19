package net.pat600.fabric.client;

import net.fabricmc.api.ClientModInitializer;

public final class antiOffhandPlaceFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        net.pat600.common.antiOffhandPlace.clientInit();
    }
}
