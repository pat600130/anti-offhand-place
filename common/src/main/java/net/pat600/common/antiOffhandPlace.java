package net.pat600.common;

import net.pat600.common.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class antiOffhandPlace {
    public static final String MOD_ID = "anti_offhand_place";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOG.info("Initializing anti-offhand_place");

    }
    public static void clientInit() {
        LOG.info("Initializing anti-offhand_place client");
        antiOffhandPlaceClient.init();
    }
}
