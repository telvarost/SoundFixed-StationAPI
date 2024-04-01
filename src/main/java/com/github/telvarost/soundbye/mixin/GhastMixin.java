package com.github.telvarost.soundbye.mixin;

import com.github.telvarost.soundbye.Config;
import net.minecraft.entity.living.FlyingBase;
import net.minecraft.entity.monster.Ghast;
import net.minecraft.entity.monster.MonsterEntityType;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.entity.player.PlayerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Ghast.class)
public class GhastMixin extends FlyingBase implements MonsterEntityType {

    public GhastMixin(Level arg) {
        super(arg);
        this.texture = "/mob/ghast.png";
        this.setSize(4.0F, 4.0F);
        this.immuneToFire = true;
    }

    @Inject(
            method = "tickHandSwing",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/level/Level;spawnEntity(Lnet/minecraft/entity/EntityBase;)Z"
            )
    )
    public void miscTweaks_spawnGhastFireball(CallbackInfo ci) {
        if (Config.config.SOUND_CONFIG.ADD_GHAST_SHOOT_SOUND)
        {
            Random rand = new Random();
            PlayerBase player = PlayerHelper.getPlayerFromGame();
            player.level.playSound(player, "soundbye:entity.ghast.snake", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
        }
    }


    @Inject(
            method = "getAmbientSound",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void getAmbientSound(CallbackInfoReturnable<String> cir) {
        if (Config.config.SOUND_CONFIG.FIX_GHAST_AMBIENT_SOUND)
        {
            Random rand = new Random();
            PlayerBase player = PlayerHelper.getPlayerFromGame();
            player.level.playSound(player, "soundbye:entity.ghast.bee", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
            cir.setReturnValue("");
        }
    }

    @Inject(
            method = "getHurtSound",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void getHurtSound(CallbackInfoReturnable<String> cir) {
        if (Config.config.SOUND_CONFIG.FIX_GHAST_HURT_SOUND)
        {
            Random rand = new Random();
            PlayerBase player = PlayerHelper.getPlayerFromGame();
            player.level.playSound(player, "soundbye:entity.ghast.crow", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
            cir.setReturnValue("");
        }
    }

    @Inject(
            method = "getDeathSound",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void getDeathSound(CallbackInfoReturnable<String> cir) {
        if (Config.config.SOUND_CONFIG.FIX_GHAST_DEATH_SOUND)
        {
            Random rand = new Random();
            PlayerBase player = PlayerHelper.getPlayerFromGame();
            player.level.playSound(player, "soundbye:entity.ghast.owl", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
            cir.setReturnValue("");
        }
    }
}
