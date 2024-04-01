package com.github.telvarost.soundbye;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.*;

public class Config {

    @GConfig(value = "config", visibleName = "Sound Fixed")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigCategory("Sound Config")
        public SoundConfig SOUND_CONFIG = new SoundConfig();
    }

    public static class SoundConfig {

        @ConfigName("Add Sound: Chest Open")
        public Boolean ADD_CHEST_OPEN_SOUND = true;

        @ConfigName("Add Sound: Chest Close")
        public Boolean ADD_CHEST_CLOSE_SOUND = true;

        @ConfigName("Add Sound: Chicken Death")
        public Boolean ADD_CHICKEN_DEATH_SOUND = true;

        @ConfigName("Add Sound: Cow Milked")
        public Boolean ADD_COW_MILKED_SOUND = true;

        @ConfigName("Add Sound: Creeper Explosion")
        public Boolean ADD_CREEPER_EXPLOSION_SOUND = true;

        @ConfigName("Add Sound: Fishing Successful")
        public Boolean ADD_FISHING_SUCCESSFUL_SOUND = true;

        @ConfigName("Add Sound: Food Eat")
        public Boolean ADD_FOOD_EAT_SOUND = true;

        @ConfigName("Add Sound: Ghast Shoot")
        public Boolean ADD_GHAST_SHOOT_SOUND = true;

        @ConfigName("Add Sound: Item Breaking")
        public Boolean ADD_ITEM_BREAK_SOUND = true;

        @ConfigName("Add Sound: Ride Boat")
        public Boolean ADD_RIDE_BOAT_SOUND = true;

        @ConfigName("Add Sound: Sheep Shear")
        public Boolean ADD_SHEEP_SHEAR_SOUND = true;

        @ConfigName("Add Sound: Wolf Tame")
        public Boolean ADD_WOLF_TAME_SOUND = true;

        @ConfigName("Fix Sound: Ghast Ambient")
        public Boolean FIX_GHAST_AMBIENT_SOUND = true;

        @ConfigName("Fix Sound: Ghast Death")
        public Boolean FIX_GHAST_DEATH_SOUND = true;

        @ConfigName("Fix Sound: Ghast Hurt")
        public Boolean FIX_GHAST_HURT_SOUND = true;
    }
}
