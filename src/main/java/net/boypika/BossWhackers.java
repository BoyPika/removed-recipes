package net.boypika;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

public class BossWhackers implements ModInitializer {
	public static final Item FIRE = new Item(new FabricItemSettings().fireproof());
	public static final Item COPPER = new Item(new FabricItemSettings().maxCount(1));
	public static final Block REACTOR = registerBlock("nether_reactor_core",
			new Block(FabricBlockSettings.create().breakInstantly().liquid()));
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier("removedrecipes", name), block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier("removedrecipes", name),
				new BlockItem(block, new FabricItemSettings()));
	}

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("removedrecipes", "fire"), FIRE);
		Registry.register(Registries.ITEM, new Identifier("removedrecipes", "copper_horn"), COPPER);
		System.out.println("[1.19.3 - 1.20.1] Boss Whackers Init");

	}
}