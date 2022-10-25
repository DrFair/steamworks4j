package com.codedisaster.steamworks;

public interface SteamNetworkingMessagesCallback {

    default void onSteamNetworkingMessagesSessionRequest(SteamID steamIDRemote) {
    }

    default void onSteamNetworkingMessagesSessionFailed(SteamID steamIDRemote) {
    }
}
