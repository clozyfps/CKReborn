package net.mcreator.craftkaisenreborn.procedures;

import net.minecraftforge.eventbus.api.Event;

public class RCTFullProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy
				/ (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergyMax) * 100 <= 100
				&& ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy
						/ (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergyMax) * 100 > 67) {
			return true;
		}
		return false;
	}
}
