
package net.mcreator.craftkaisenreborn.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.craftkaisenreborn.procedures.UseReverseCursedEnergyStartProcedure;
import net.mcreator.craftkaisenreborn.procedures.UseReverseCursedEnergyEndProcedure;
import net.mcreator.craftkaisenreborn.CraftkaisenrebornMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UseReverseCursedEnergyBindMessage {
	int type, pressedms;

	public UseReverseCursedEnergyBindMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public UseReverseCursedEnergyBindMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(UseReverseCursedEnergyBindMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(UseReverseCursedEnergyBindMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			UseReverseCursedEnergyStartProcedure.execute(entity);
		}
		if (type == 1) {

			UseReverseCursedEnergyEndProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftkaisenrebornMod.addNetworkMessage(UseReverseCursedEnergyBindMessage.class, UseReverseCursedEnergyBindMessage::buffer, UseReverseCursedEnergyBindMessage::new, UseReverseCursedEnergyBindMessage::handler);
	}
}
