package net.boypika;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

import static net.minecraft.item.Items.register;

public class RemovedRecipes implements ModInitializer {
	//Items
	public static final Item FIRE = register((new Identifier("removedrecipes","fire")), new AliasedBlockItem(Blocks.FIRE, new Item.Settings().fireproof()));
	public static final Item COPPER = new Item(new FabricItemSettings().maxCount(1));
	public static final Block REACTOR = registerBlock(
			new Block(FabricBlockSettings.create().breakInstantly().solid()));
	//BS to register the Reactor
	private static Block registerBlock(Block block) {
		registerBlockItem(block);
		return Registry.register(Registries.BLOCK, new Identifier("removedrecipes", "nether_reactor_core"), block);
	}

	private static void registerBlockItem(Block block) {
		Registry.register(Registries.ITEM, new Identifier("removedrecipes", "nether_reactor_core"),
				new BlockItem(block, new FabricItemSettings()));
	}
	//Register the copper horn and let the people know of the mods presence
	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("removedrecipes", "copper_horn"), COPPER);
		System.out.println("[1.19.3 - 1.20.1] Recipes Init");
	}
}