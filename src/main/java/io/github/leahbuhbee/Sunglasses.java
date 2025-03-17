package io.github.leahbuhbee;

import io.github.leahbuhbee.item.SunglassesItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sunglasses implements ModInitializer {
	public static final String ID = "sunglasses";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);


	@Override
	public void onInitialize() {
		Item sunglasses = Registry.register(Registries.ITEM, Identifier.of(Sunglasses.ID, "sunglasses"), new SunglassesItem(new Item.Settings()));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addBefore(Items.ELYTRA, sunglasses));
		LOGGER.info("[Sunglasses] Barks at your sun");
	}
}
