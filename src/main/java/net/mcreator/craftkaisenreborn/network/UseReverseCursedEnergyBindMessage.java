
package net.mcreator.craftkaisenreborn.network;

import net.mcreator.craftkaisenreborn.CraftkaisenrebornMod;

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

			UseReverseCursedEnergyStartProcedure.execute();
		}

		if (type == 1) {

			UseReverseCursedEnergyEndProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftkaisenrebornMod.addNetworkMessage(UseReverseCursedEnergyBindMessage.class, UseReverseCursedEnergyBindMessage::buffer, UseReverseCursedEnergyBindMessage::new, UseReverseCursedEnergyBindMessage::handler);
	}

}
