package com.github.telvarost.soundbye.mixin;

import com.github.telvarost.soundbye.Config;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.container.DoubleChest;
import net.minecraft.client.util.Session;
import net.minecraft.container.Chest;
import net.minecraft.entity.player.AbstractClientPlayer;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.entity.player.PlayerHelper;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;

import java.util.Random;

@Environment(EnvType.CLIENT)
@Mixin(AbstractClientPlayer.class)
public class AbstractClientPlayerMixin extends PlayerBase {

    @Shadow protected Minecraft minecraft;

    public AbstractClientPlayerMixin(Minecraft minecraft, Level arg, Session arg2, int i) {
        super(arg);
    }

    public void method_494() {
        /** - Do nothing */
    }

    @Inject(method = "openChestScreen", at = @At("TAIL"))
	public void soundBye_openChestScreen(InventoryBase arg, CallbackInfo ci) {
		this.minecraft.openScreen(new DoubleChest(this.inventory, arg));

		if(Config.config.SOUND_CONFIG.ADD_CHEST_OPEN_SOUND) {
			Random rand = new Random();
			PlayerBase player = PlayerHelper.getPlayerFromGame();
			player.level.playSound(player, "soundbye:entity.player.alone", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
		}
	}

	@Inject(method = "closeContainer", at = @At("HEAD"))
	public void soundBye_closeContainer(CallbackInfo ci) {
		if(Config.config.SOUND_CONFIG.ADD_CHEST_CLOSE_SOUND) {
			PlayerBase player = (PlayerBase) (Object) this;
			if(player.container instanceof Chest) {
				Random rand = new Random();
				player.level.playSound(player, "soundbye:entity.player.alone", 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
			}
		}
	}
}
