package net.mcreator.craftkaisenreborn.procedures;

import net.minecraft.world.entity.Entity;

public class ChargeCursedEnergyEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.getPersistentData().getBoolean("chargingRCT")) {
			entity.getPersistentData().putBoolean("chargingCE", false);
			entity.getPersistentData().putDouble("timerCharge", 30);
		} else {
			entity.getPersistentData().putBoolean("chargingRCT", false);
		}
	}
}
