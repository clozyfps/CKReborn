package net.mcreator.craftkaisenreborn.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.craftkaisenreborn.network.CraftkaisenrebornModVariables;
import net.mcreator.craftkaisenreborn.init.CraftkaisenrebornModParticleTypes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy > (entity
				.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).MaxCursedEnergy) {
			{
				double _setval = (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).MaxCursedEnergy;
				entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CursedEnergy = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity.getPersistentData().getDouble("timerCharge") > 0) {
			entity.getPersistentData().putDouble("timerCharge", (entity.getPersistentData().getDouble("timerCharge") - 1));
		}
		if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.MOVEMENT_SPEED)) {
			entity.setMaxUpStep((float) 1.2);
		} else {
			entity.setMaxUpStep((float) 0.6);
		}
		if (entity.getPersistentData().getBoolean("chargingCE")) {
			if (!((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).SelectedAbility).contains("Domain Expansion:")) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (CraftkaisenrebornModParticleTypes.CE_PARTICLE.get()), x, y, z, 6, 0, 0, 0, 0.05);
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (CraftkaisenrebornModParticleTypes.BURST_CE_PARTICLE.get()), x, y, z, 3, 0, 0, 0, 0.05);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (CraftkaisenrebornModParticleTypes.BURST_CE_PARTICLE.get()), x, y, z, 3, 0, 0, 0, 0.1);
			}
			if ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy < (entity
					.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).MaxCursedEnergy) {
				{
					double _setval = (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy + 1;
					entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CursedEnergy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2, 1, false, false));
			}
			if (entity.isShiftKeyDown()) {
				if (!(entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.MOVEMENT_SPEED))) {
					if ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy >= 25) {
						{
							double _setval = (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy - 25;
							entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.CursedEnergy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2, false, false));
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("chargingRCT")) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (CraftkaisenrebornModParticleTypes.RCT_PARTICLE.get()), x, y, z, 6, 0, 0, 0, 0.05);
			if ((entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy >= 2
					&& (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy < (entity
							.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergyMax) {
				{
					double _setval = (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).CursedEnergy - 2;
					entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CursedEnergy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy + 1;
					entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ReverseCursedEnergy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (entity.getPersistentData().getBoolean("usingRCT")) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle dust{color:[1.0,1.0,1.0],scale:\".25\"} ~ ~1 ~ .2 .6 .2 0 3 force");
				}
			}
			{
				double _setval = (entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CraftkaisenrebornModVariables.PlayerVariables())).ReverseCursedEnergy - 1;
				entity.getCapability(CraftkaisenrebornModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ReverseCursedEnergy = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("ticksRCTUsed", (entity.getPersistentData().getDouble("ticksRCTUsed") + 1));
			if (entity.getPersistentData().getDouble("ticksRCTUsed") == 30) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
				entity.getPersistentData().putDouble("ticksRCTUsed", (Mth.nextInt(RandomSource.create(), 0, 10)));
			}
		}
	}
}
