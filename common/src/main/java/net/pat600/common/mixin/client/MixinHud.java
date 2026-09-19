package net.pat600.common.mixin.client;


import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.pat600.common.client.antiOffhandPlaceClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.pat600.common.antiOffhandPlace.LOG;

@Mixin(value = net.minecraft.client.gui.Gui.class)
public abstract class MixinHud {

    @Shadow
    protected abstract Player getCameraPlayer();

    @Shadow
    protected int screenWidth;

    @Shadow
    protected int screenHeight;


    @Inject(
            method = "renderHotbar",
            at = @At("TAIL")
    )
    private void renderHotBarIndicator(float partialTick, GuiGraphics guiGraphics, CallbackInfo ci){
        Player player = this.getCameraPlayer();
            if (player != null){
            ItemStack itemStack = player.getOffhandItem();
            HumanoidArm humanoidArm = player.getMainArm().getOpposite();

                if (!itemStack.isEmpty()) {
                int m = this.screenHeight - 16 - 3;
                int i = this.screenWidth / 2;
                int color = 0x8000FF00;
                if (antiOffhandPlaceClient.toggled) color = 0x80FF0000;
                if (humanoidArm == HumanoidArm.LEFT) {
                    //LOG.info("Left");
                    guiGraphics.vLine(i - 91 - 26, m-1, m + 16, color);
                } else {
                    //LOG.info("Right");
                    guiGraphics.vLine(i + 91 + 26, m-1, m + 16, color);

                }
            }
        }
    }
}
