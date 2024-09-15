package net.mcreator.craftkaisenreborn.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BoredTestUsedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown()) {
			{
				double _setval = 1000;
				entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MaxCursedEnergy = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 500;
				entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ReverseCursedEnergyMax = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				String _setval = "Domain Expansion: Unlimited Void";
				entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SelectedAbility = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
