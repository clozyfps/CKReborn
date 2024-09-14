
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.craftkaisenreborn.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.craftkaisenreborn.item.TestItem;
import net.mcreator.craftkaisenreborn.CraftkaisenrebornMod;

public class CraftkaisenrebornModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CraftkaisenrebornMod.MODID);
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
	// Start of user code block custom items
	// End of user code block custom items
}
