package customclient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import customclient.module.Mod;
import customclient.module.ModuleManager;
import customclient.ui.screens.clickgui.ClickGUI;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

public class Client implements ModInitializer {
	
	public static final Client INSTANCE = new Client();
	public Logger logger = LogManager.getLogger(Client.class);
	
	private MinecraftClient mc = MinecraftClient.getInstance();
	
	@Override
	public void onInitialize() {
		logger.info("Hello World");
		
	}
	
	public void onKeyPress(int key, int action) {
		if (action == GLFW.GLFW_PRESS) {
			for (Mod module : ModuleManager.INSTANCE.getModules()) {
				if (key == module.getKey()) module.toggle();
			}
			
			if (key == GLFW.GLFW_KEY_RIGHT_SHIFT) mc.setScreen(ClickGUI.INSANCE);
		}
		
	}
	public void onTick() {
		if (mc.player != null) {
			for (Mod module : ModuleManager.INSTANCE.getEnabledModules()) {
				module.onTick();
			}
		}
	}
}
