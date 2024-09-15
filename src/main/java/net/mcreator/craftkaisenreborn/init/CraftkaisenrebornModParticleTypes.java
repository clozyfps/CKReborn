
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.craftkaisenreborn.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.craftkaisenreborn.CraftkaisenrebornMod;

public class CraftkaisenrebornModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CraftkaisenrebornMod.MODID);
	public static final RegistryObject<SimpleParticleType> CE_PARTICLE = REGISTRY.register("ce_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BURST_CE_PARTICLE = REGISTRY.register("burst_ce_particle", () -> new SimpleParticleType(true));
}
