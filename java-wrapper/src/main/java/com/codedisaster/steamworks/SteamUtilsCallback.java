package com.codedisaster.steamworks;

public interface SteamUtilsCallback {

	default void onSteamShutdown() {
	}

	default void onGamepadTextInputDismissed(boolean submitted) {
	}

	default void onFloatingGamepadTextInputDismissed() {
	}

}
