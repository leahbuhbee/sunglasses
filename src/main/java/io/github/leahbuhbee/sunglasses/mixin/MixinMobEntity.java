package io.github.leahbuhbee.sunglasses.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.leahbuhbee.sunglasses.Sunglasses;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MobEntity.class)
public class MixinMobEntity {
	@ModifyReturnValue(method = "isAffectedByDaylight", at = @At("RETURN"))
	private boolean dontBurnWithSunglasses(boolean original) {
		MobEntity self = (MobEntity) (Object) this;
		boolean hasGlasses = self.getEquippedStack(EquipmentSlot.HEAD).isOf(Sunglasses.SUNGLASSES);
		return original && !hasGlasses;
	}

}
