package com.github.telvarost.soundbye.mixin;

import com.github.telvarost.soundbye.Config;
import net.minecraft.entity.Boat;
import net.minecraft.entity.player.PlayerBase;
import net.modificationstation.stationapi.api.entity.player.PlayerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Boat.class)
public class BoatMixin {
    @Inject(
            method = "interact",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerBase;startRiding(Lnet/minecraft/entity/EntityBase;)V"
            )
    )
    public void interact(PlayerBase par1, CallbackInfoReturnable<Boolean> cir) {
        if(Config.config.SOUND_CONFIG.ADD_RIDE_BOAT_SOUND){
            Random rand = new Random();
            PlayerBase player = PlayerHelper.getPlayerFromGame();
            player.level.playSound(player, "soundbye:entity.boat.frog", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
        }
    }
}
