package customclient.module.movement;

import org.lwjgl.glfw.GLFW;

import customclient.module.Mod;

public class Sprint extends Mod {

	public Sprint() {
		super("Sprint", "Keeps your sprint", Category.MOVEMENT);
		this.setKey(GLFW.GLFW_KEY_V);
	}
	@Override
	public void onTick() {
		mc.player.setSprinting(true);
		super.onTick();
	}
}
