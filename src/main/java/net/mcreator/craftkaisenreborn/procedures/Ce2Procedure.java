package net.mcreator.craftkaisenreborn.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.craftkaisenreborn.network.CraftkaisenrebornModVariables;

public class Ce2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy
				/ (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).MaxCursedEnergy) * 100 <= 36
				&& ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy
						/ (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).MaxCursedEnergy) * 100 > 20) {
			return true;
		}
		return false;
	}
}
