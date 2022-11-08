package customclient.ui.screens.clickgui.setting;

import java.awt.Color;

import customclient.module.settings.ModeSetting;
import customclient.module.settings.Setting;
import customclient.ui.screens.clickgui.ModuleButton;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public class ModeBox extends Component {
	
	private ModeSetting modeSet = (ModeSetting)setting;

	public ModeBox(Setting setting, ModuleButton parent, int offset) {
		super(setting, parent, offset);
		this.modeSet = (ModeSetting)setting;
	}
	@Override
	public void render(MatrixStack matrics, int mouseX, int mouseY, float delta) {
		DrawableHelper.fill(matrics, parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x + parent.parent.width, parent.parent.y + parent.offset + offset + parent.parent.height, new Color(0, 0, 0, 160).getRGB());
		int textOffset = ((parent.parent.height / 2) - mc.textRenderer.fontHeight / 2);
		mc.textRenderer.drawWithShadow(matrics, modeSet.getName() + ": " + modeSet.getMode(), parent.parent.x + textOffset, parent.parent.y + parent.offset + offset + textOffset, -1);
		super.render(matrics, mouseX, mouseY, delta);
	}
	@Override
	public void mouseClicked(double mouseX, double mouseY, int button) {
		if (isHovered(mouseX, mouseY) && button == 0) modeSet.cycle();
		super.mouseClicked(mouseX, mouseY, button);
	}
}
