package com.github.telvarost.soundbye.mixin;

import com.github.telvarost.soundbye.Config;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.monster.Creeper;
import net.minecraft.entity.monster.MonsterBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.entity.player.PlayerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(Creeper.class)
public class CreeperMixin extends MonsterBase {

    public CreeperMixin(Level arg) {
        super(arg);
        this.texture = "/mob/creeper.png";
    }

    @Inject(
            method = "tryAttack",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/monster/Creeper;isCharged()Z"
            )
    )
    public void miscTweaks_tryAttackBeforeCreateExplosion(EntityBase f, float par2, CallbackInfo ci) {
        if (Config.config.SOUND_CONFIG.ADD_CREEPER_EXPLOSION_SOUND)
        {
            Random rand = new Random();
            PlayerBase player = PlayerHelper.getPlayerFromGame();
            player.level.playSound(player, "soundbye:entity.creeper.explosion", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
        }
    }

}

