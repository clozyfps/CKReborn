package net.mcreator.craftkaisenreborn.procedures;

import net.minecraft.world.entity.Entity;

public class ChargeCursedEnergyEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("chargingCE", false);
	}
}
