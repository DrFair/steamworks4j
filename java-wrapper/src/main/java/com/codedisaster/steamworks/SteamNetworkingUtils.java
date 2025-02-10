package com.codedisaster.steamworks;

public class SteamNetworkingUtils extends SteamInterface {

    public enum SteamNetworkingSocketsDebugOutputType
    {
        None(0),
        Bug(1), // You used the API incorrectly, or an internal error happened
        Error(2), // Run-time error condition that isn't the result of a bug.  (E.g. we are offline, cannot bind a port, etc)
        Important(3), // Nothing is wrong, but this is an important notification
        Warning(4),
        Msg(5), // Recommended amount
        Verbose(6), // Quite a bit
        Debug(7), // Practically everything
        Everything(8), // Wall of text, detailed packet contents breakdown, etc
        _Force32Bit(0x7fffffff);

        private final int apiIndex;

        SteamNetworkingSocketsDebugOutputType(int apiIndex){
            this.apiIndex = apiIndex;
        }
    };

    private final SteamNetworkingUtilsCallbackAdapter callbackAdapter;

    public SteamNetworkingUtils() {
        callbackAdapter = new SteamNetworkingUtilsCallbackAdapter(new SteamNetworkingUtilsCallback() {});
        setCallback(SteamNetworkingUtilsNative.createCallback(callbackAdapter));
    }

    public void setDebugOutputHook(SteamNetworkingSocketsDebugOutputType detailLevel, SteamAPINetworkingDebugOutputHook debutOutputHook) {
        callbackAdapter.setDebugOutputHook(debutOutputHook);
        SteamNetworkingUtilsNative.enableDebugOutputHook(this.callback, debutOutputHook != null, detailLevel.apiIndex);
    }

}
