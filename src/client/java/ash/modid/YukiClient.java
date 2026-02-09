package ash.modid;


import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class YukiClient implements ClientModInitializer
{
	public static KeyMapping zoomkey;

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		zoomkey = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.yuki.zoom",
				InputConstants.Type.KEYSYM,
				GLFW.GLFW_KEY_C,
				KeyMapping.Category.MISC
		));

	}
}