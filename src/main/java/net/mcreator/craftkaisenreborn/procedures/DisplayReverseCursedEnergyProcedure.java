package net.mcreator.craftkaisenreborn.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.craftkaisenreborn.network.CraftkaisenrebornModVariables;

public class DisplayReverseCursedEnergyProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Reverse Cursed Energy: "
				+ new java.text.DecimalFormat("#").format((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy) + "/"
				+ new java.text.DecimalFormat("#").format((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergyMax);
	}
}
