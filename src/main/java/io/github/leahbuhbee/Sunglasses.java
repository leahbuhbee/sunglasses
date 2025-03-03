package io.github.leahbuhbee;

import io.github.leahbuhbee.item.SunglassesItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sunglasses implements ModInitializer {
	public static final String ID = "sunglasses";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);


	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, Identifier.of(Sunglasses.ID, "sunglasses"), new SunglassesItem(new Item.Settings()));
        LOGGER.info("[Sunglasses] Barks at your sun");
	}
}
