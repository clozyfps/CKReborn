package net.mcreator.craftkaisenreborn.procedures;

import net.minecraftforge.eventbus.api.Event;

public class Ce3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy
				/ (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).MaxCursedEnergy) * 100 <= 52
				&& ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy
						/ (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).MaxCursedEnergy) * 100 > 36) {
			return true;
		}
		return false;
	}
}
