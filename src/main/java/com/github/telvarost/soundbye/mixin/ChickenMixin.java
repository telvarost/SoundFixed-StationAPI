package com.github.telvarost.soundbye.mixin;

import com.github.telvarost.soundbye.Config;
import net.minecraft.entity.animal.Chicken;
import net.minecraft.entity.player.PlayerBase;
import net.modificationstation.stationapi.api.entity.player.PlayerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Chicken.class)
public class ChickenMixin {

    @Inject(
        method = "getDeathSound",
        at = @At("HEAD")
    )
    protected void getDeathSound(CallbackInfoReturnable<String> cir) {
        if(Config.config.SOUND_CONFIG.ADD_CHICKEN_DEATH_SOUND){
            Random rand = new Random();
            PlayerBase player = PlayerHelper.getPlayerFromGame();
            player.level.playSound(player, "soundbye:entity.chicken.turkey", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
        }
    }
}
