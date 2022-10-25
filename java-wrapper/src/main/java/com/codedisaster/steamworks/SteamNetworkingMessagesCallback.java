package com.codedisaster.steamworks;

public interface SteamNetworkingMessagesCallback {

    default void onSteamNetworkingMessagesSessionRequest(SteamID identityRemote) {
    }

    default void onSteamNetworkingMessagesSessionFailed(SteamID identityRemote) {
    }
}
