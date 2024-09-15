package net.mcreator.craftkaisenreborn.procedures;

import net.minecraftforge.eventbus.api.Event;

public class RCTEmptyProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy <= 0) {
			return true;
		}
		return false;
	}
}
