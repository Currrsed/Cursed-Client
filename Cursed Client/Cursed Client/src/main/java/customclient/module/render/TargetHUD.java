package customclient.module.render;

import java.awt.Color;

import customclient.module.Mod;
import customclient.module.settings.BooleanSetting;

public class TargetHUD  extends Mod {
	
	public static final int modalWidth = 160;
	public static final int modalHeight = 42;
	static final Color GREEN = new Color(100, 255, 20);
	static final Color RED = new Color(255, 50,20);
	final BooleanSetting showPing = 
	
	public TargetHUD() {
		super("TargetHUD", "Shows information about your opponent", Category.RENDER);
	}
	
}
