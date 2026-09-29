package dev.emi.emi.screen.widget.config;

import java.util.List;
import java.util.function.Supplier;

import dev.emi.emi.EmiPort;
import dev.emi.emi.screen.ConfigScreen.Mutator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

public class StringWidget extends ConfigEntryWidget {
	public final TextFieldWidget text;

	public StringWidget(Text name, List<TooltipComponent> tooltip, Supplier<String> search, Mutator<String> mutator) {
		super(name, tooltip, search, 20);
		MinecraftClient client = MinecraftClient.getInstance();
		text = new TextFieldWidget(client.textRenderer, 0, 0, 150, 18, EmiPort.literal(""));
		text.setMaxLength(4096);
		text.setText(mutator.get());
		text.setChangedListener(mutator::set);
		this.setChildren(List.of(text));
	}

	@Override
	public void update(int y, int x, int width, int height) {
		text.x = x + width - 150;
		text.y = y + 1;
	}
}
