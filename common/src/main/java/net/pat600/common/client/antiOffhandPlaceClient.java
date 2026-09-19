package net.pat600.common.client;

import com.mojang.blaze3d.platform.InputConstants;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static net.pat600.common.antiOffhandPlace.LOG;

public class antiOffhandPlaceClient {
    public static void init() {
        antiOffhandPlaceInit();
        KeyMappingRegistry.register(togglebind);
        toggleOnTick();
        LOG.info( "Initialized anti-offhand_place client" );
    }//[note] setup button in inventory to toggle and add configs
    // no

    private static final KeyMapping togglebind = new KeyMapping(
            "key.antiOffhandPlace.togglebind",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_G,
            //InputConstants.MOD_CONTROL,
            "category.antiOffhandPlace.antiOffhandPlace"
    );

    public static boolean toggled=false;

    private static void toggleOnTick(){
        ClientTickEvent.CLIENT_POST.register(minecraft -> {
            while (togglebind.consumeClick())
                    toggled= !toggled;
        });
    }

    private static void antiOffhandPlaceInit() {
        BlockEvent.PLACE.register((level,pos,blockState,entity) -> {
            Player player = (Player) entity;
            if (player == null) return EventResult.pass();
            Item mhItem = player.getMainHandItem().getItem();
            Item ohItem = player.getOffhandItem().getItem();

            if ((mhItem instanceof BlockItem && ohItem instanceof BlockItem)||toggled||ohItem==ItemStack.EMPTY.getItem())
                return EventResult.pass();

            return EventResult.interruptFalse();
        });
    }


}
