package net.mcreator.craftkaisenreborn.procedures;

import net.minecraft.world.entity.Entity;

public class UseReverseCursedEnergyEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("usingRCT", false);
	}
}
