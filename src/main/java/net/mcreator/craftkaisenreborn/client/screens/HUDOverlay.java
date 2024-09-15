
package net.mcreator.craftkaisenreborn.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.craftkaisenreborn.procedures.RCTFullProcedure;
import net.mcreator.craftkaisenreborn.procedures.RCTEmptyProcedure;
import net.mcreator.craftkaisenreborn.procedures.RCT2Procedure;
import net.mcreator.craftkaisenreborn.procedures.RCT1Procedure;
import net.mcreator.craftkaisenreborn.procedures.DisplayReverseCursedEnergyProcedure;
import net.mcreator.craftkaisenreborn.procedures.DisplayCursedEnergyProcedure;
import net.mcreator.craftkaisenreborn.procedures.CeEmptyProcedure;
import net.mcreator.craftkaisenreborn.procedures.Ce5Procedure;
import net.mcreator.craftkaisenreborn.procedures.Ce4Procedure;
import net.mcreator.craftkaisenreborn.procedures.Ce3Procedure;
import net.mcreator.craftkaisenreborn.procedures.Ce2Procedure;
import net.mcreator.craftkaisenreborn.procedures.Ce1Procedure;
import net.mcreator.craftkaisenreborn.procedures.CEFullProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class HUDOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (RCT1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/rct1.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (RCT2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/rct2.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (RCTFullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/rctfull.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (CEFullProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/cefull.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (Ce5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/ce5.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (Ce4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/ce4.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (Ce3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/ce3.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (Ce2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/ce2.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (Ce1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/ce1.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (CeEmptyProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/ceempty.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			if (RCTEmptyProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("craftkaisenreborn:textures/screens/rctempty.png"), -18, -11, 0, 0, 427, 240, 427, 240);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayCursedEnergyProcedure.execute(entity), 7, h - 17, -16724788, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayReverseCursedEnergyProcedure.execute(entity), 7, h - 29, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
