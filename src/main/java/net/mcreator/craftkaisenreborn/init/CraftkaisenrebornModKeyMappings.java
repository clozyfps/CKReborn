
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.craftkaisenreborn.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.craftkaisenreborn.network.UseReverseCursedEnergyBindMessage;
import net.mcreator.craftkaisenreborn.network.ChargeCursedEnergyBindMessage;
import net.mcreator.craftkaisenreborn.CraftkaisenrebornMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CraftkaisenrebornModKeyMappings {
	public static final KeyMapping CHARGE_CURSED_ENERGY_BIND = new KeyMapping("key.craftkaisenreborn.charge_cursed_energy_bind", GLFW.GLFW_KEY_V, "key.categories.ck") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CraftkaisenrebornMod.PACKET_HANDLER.sendToServer(new ChargeCursedEnergyBindMessage(0, 0));
				ChargeCursedEnergyBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				CHARGE_CURSED_ENERGY_BIND_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - CHARGE_CURSED_ENERGY_BIND_LASTPRESS);
				CraftkaisenrebornMod.PACKET_HANDLER.sendToServer(new ChargeCursedEnergyBindMessage(1, dt));
				ChargeCursedEnergyBindMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_REVERSE_CURSED_ENERGY_BIND = new KeyMapping("key.craftkaisenreborn.use_reverse_cursed_energy_bind", GLFW.GLFW_KEY_G, "key.categories.ck") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CraftkaisenrebornMod.PACKET_HANDLER.sendToServer(new UseReverseCursedEnergyBindMessage(0, 0));
				UseReverseCursedEnergyBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_REVERSE_CURSED_ENERGY_BIND_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_REVERSE_CURSED_ENERGY_BIND_LASTPRESS);
				CraftkaisenrebornMod.PACKET_HANDLER.sendToServer(new UseReverseCursedEnergyBindMessage(1, dt));
				UseReverseCursedEnergyBindMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long CHARGE_CURSED_ENERGY_BIND_LASTPRESS = 0;
	private static long USE_REVERSE_CURSED_ENERGY_BIND_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(CHARGE_CURSED_ENERGY_BIND);
		event.register(USE_REVERSE_CURSED_ENERGY_BIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				CHARGE_CURSED_ENERGY_BIND.consumeClick();
				USE_REVERSE_CURSED_ENERGY_BIND.consumeClick();
			}
		}
	}
}
