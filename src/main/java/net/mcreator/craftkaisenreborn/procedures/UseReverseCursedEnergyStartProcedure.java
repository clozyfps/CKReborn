package net.mcreator.craftkaisenreborn.procedures;

import net.minecraftforge.eventbus.api.Event;

public class UseReverseCursedEnergyStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
				&& (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy > 0) {
			entity.getPersistentData().putBoolean("usingRCT", true);
		}
	}
}
