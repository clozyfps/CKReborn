
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.craftkaisenreborn.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.craftkaisenreborn.client.particle.RCTParticleParticle;
import net.mcreator.craftkaisenreborn.client.particle.CEParticleParticle;
import net.mcreator.craftkaisenreborn.client.particle.BurstCEParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CraftkaisenrebornModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(CraftkaisenrebornModParticleTypes.CE_PARTICLE.get(), CEParticleParticle::provider);
		event.registerSpriteSet(CraftkaisenrebornModParticleTypes.BURST_CE_PARTICLE.get(), BurstCEParticleParticle::provider);
		event.registerSpriteSet(CraftkaisenrebornModParticleTypes.RCT_PARTICLE.get(), RCTParticleParticle::provider);
	}
}
