package com.codedisaster.steamworks;

public interface SteamAPINetworkingDebugOutputHook {
	void onDebugOutput(int debugType, String message);
}
