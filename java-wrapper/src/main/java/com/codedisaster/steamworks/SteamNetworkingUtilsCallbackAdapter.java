package com.codedisaster.steamworks;

class SteamNetworkingUtilsCallbackAdapter extends SteamCallbackAdapter<SteamNetworkingUtilsCallback> {

    private SteamAPINetworkingDebugOutputHook debugOutputHook;

    SteamNetworkingUtilsCallbackAdapter(SteamNetworkingUtilsCallback callback) {
        super(callback);
    }

    void setDebugOutputHook(SteamAPINetworkingDebugOutputHook debugOutputHook) {
        this.debugOutputHook = debugOutputHook;
    }

    void onDebugOutput(int debugType, String message) {
        if (debugOutputHook != null) {
            debugOutputHook.onDebugOutput(debugType, message);
        }
    }

}
