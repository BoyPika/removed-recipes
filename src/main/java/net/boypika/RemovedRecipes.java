package net.boypika;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

import static net.minecraft.item.Items.register;

public class RemovedRecipes implements ModInitializer {
	//Items
	public static final Item FIRE;

	static {
		FIRE = register((new Identifier("removedrecipes", "fire")), new AliasedBlockItem(Blocks.FIRE, new Item.Settings().fireproof()));
	}
	//Block
	public static final Block REACTOR = registerBlock(
			new Block(AbstractBlock.Settings.create().solid().hardness(5.0F).requiresTool().mapColor(DyeColor.LIGHT_BLUE).resistance(10.0F)));
	//BS to register the Reactor
	private static Block registerBlock(Block block) {
		registerBlockItem(block);
		return Registry.register(Registries.BLOCK, new Identifier("removedrecipes", "nether_reactor_core"), block);
	}

	private static void registerBlockItem(Block block) {
		Registry.register(Registries.ITEM, new Identifier("removedrecipes", "nether_reactor_core"),
				new BlockItem(block, new FabricItemSettings()));
	}
	//Let the people know of the mods presence
	@Override
	public void onInitialize() {
		System.out.println("[1.20 - 1.20.1] Recipes Init");
	}
}