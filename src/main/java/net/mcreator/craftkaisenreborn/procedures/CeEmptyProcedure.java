package net.mcreator.craftkaisenreborn.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.craftkaisenreborn.network.CraftkaisenrebornModVariables;

public class CeEmptyProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy <= 0) {
			return true;
		}
		return false;
	}
}
