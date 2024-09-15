
package net.mcreator.craftkaisenreborn.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class BoredTestItem extends Item {
	public BoredTestItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		BoredTestUsedProcedure.execute(entity);
		return ar;
	}
}