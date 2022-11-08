package customclient.ui;

import java.awt.Color;
import java.util.Comparator;
import java.util.List;

import customclient.module.Mod;
import customclient.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class Hud {

	private static MinecraftClient mc = MinecraftClient.getInstance();
	
	public static void render(MatrixStack matrics, float tickDelta) {
		renderArrayList(matrics);
	}
	
	public static void renderArrayList(MatrixStack matrics) {
		int index = 0;
		int sWidth = mc.getWindow().getScaledWidth();
		int sHeight = mc.getWindow().getScaledHeight();
		
		List<Mod> enabled = ModuleManager.INSTANCE.getEnabledModules();
		
		enabled.sort(Comparator.comparingInt(n -> mc.textRenderer.getWidth(((Mod)n).getDisplayName())).reversed());
		
		for (Mod mod : enabled ) {
			mc.textRenderer.drawWithShadow(matrics, mod.getDisplayName(), (sWidth -4) - mc.textRenderer.getWidth(mod.getDisplayName()), 10 +(index * mc.textRenderer.fontHeight), -1);
			index++;
		}
	}
	

}
