package net.mcreator.craftkaisenreborn.procedures;

import net.minecraft.world.entity.Entity;

public class ChargeCursedEnergyStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getPersistentData().getDouble("timerCharge") > 0)) {
			entity.getPersistentData().putBoolean("chargingCE", true);
		} else {
			entity.getPersistentData().putBoolean("chargingRCT", true);
		}
	}
}
