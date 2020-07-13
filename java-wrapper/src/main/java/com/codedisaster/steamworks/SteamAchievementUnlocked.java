package com.codedisaster.steamworks;

public class SteamAchievementUnlocked {

    public final boolean unlocked;
    public final long unlockTime;

    SteamAchievementUnlocked(boolean unlocked, long unlockTime) {
        this.unlocked = unlocked;
        this.unlockTime = unlockTime;
    }
}
