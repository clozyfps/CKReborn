package net.mcreator.craftkaisenreborn.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.craftkaisenreborn.network.CraftkaisenrebornModVariables;

public class RCT1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy
				/ (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergyMax) * 100 <= 34
				&& ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy
						/ (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergyMax) * 100 > 1) {
			return true;
		}
		return false;
	}
}
