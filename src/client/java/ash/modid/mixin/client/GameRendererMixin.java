package ash.modid.mixin.client;

import ash.modid.YukiClient;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin
{
    @Inject(method = "getFov", at = @At("RETURN"), cancellable = true)
    private void onGetFov(Camera camera, float partialTicks, boolean applyEffects, CallbackInfoReturnable<Float> cir) {
        if (YukiClient.zoomkey.isDown())
        {
            double originalFov = cir.getReturnValue();
            float newFov = (float) (originalFov / 4.0);
            cir.setReturnValue(newFov);
        }
    }
}