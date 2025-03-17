package io.github.leahbuhbee.sunglasses.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SunglassesItem extends Item implements Equipment {
	public SunglassesItem(Settings settings) {
		super(settings);
	}


	@Override
	public EquipmentSlot getSlotType() {
		return EquipmentSlot.HEAD;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		return this.equipAndSwap(this, world, user, hand);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		EquipmentSlot equipmentSlot = target.getPreferredEquipmentSlot(stack);
		if (target.getEquippedStack(equipmentSlot).isEmpty() ) {
			target.equipStack(getSlotType(),stack.copyWithCount(1));
			stack.decrement(1);
		}
		return super.postHit(stack, target, attacker);
	}
}
