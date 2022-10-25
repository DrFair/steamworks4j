package com.codedisaster.steamworks;

public class SteamNetworkingMessages extends SteamInterface {

    public SteamNetworkingMessages(SteamNetworkingMessagesCallback callback) {
        super(SteamNetworkingMessagesNative.createCallback(new SteamNetworkingMessagesCallbackAdapter(callback)));
    }

    public SteamResult sendMessageToUser(SteamID steamIDRemote, byte[] data, int dataSize, int sendFlags, int channel) {
        int value = SteamNetworkingMessagesNative.sendMessageToUser(SteamNativeHandle.getNativeHandle(steamIDRemote), data, dataSize, sendFlags, channel);
        return SteamResult.byValue(value);
    }

    public int receiveMessagesOnChannel(int channel, SteamNetworkingMessage[] outMessages, int maxMessages) {
        if (maxMessages > 32) throw new IllegalArgumentException("Cannot receive moe than 32 messages at once");
        return SteamNetworkingMessagesNative.receiveMessagesOnChannel(channel, outMessages, maxMessages);
    }

    public boolean acceptSessionWithUser(SteamID steamIDRemote) {
        return SteamNetworkingMessagesNative.acceptSessionWithUser(SteamNativeHandle.getNativeHandle(steamIDRemote));
    }

    public boolean closeSessionWithUser(SteamID steamIDRemote) {
        return SteamNetworkingMessagesNative.closeSessionWithUser(SteamNativeHandle.getNativeHandle(steamIDRemote));
    }

    public boolean closeChannelWithUser(SteamID steamIDRemote, int channel) {
        return SteamNetworkingMessagesNative.closeChannelWithUser(SteamNativeHandle.getNativeHandle(steamIDRemote), channel);
    }
}
