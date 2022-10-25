package com.codedisaster.steamworks;

import java.nio.ByteBuffer;

public class SteamNetworkingMessages extends SteamInterface {

    public enum SendFlag {
        Unreliable(0),
        NoNagle(1),
        UnreliableNoNagle(1),
        NoDelay(4),
        UnreliableNoDelay(5),
        Reliable(8),
        ReliableNoNagle(9);

        public final int value;
        SendFlag(int value) {
            this.value = value;
        }
    }


    public SteamNetworkingMessages(SteamNetworkingMessagesCallback callback) {
        super(SteamNetworkingMessagesNative.createCallback(new SteamNetworkingMessagesCallbackAdapter(callback)));
    }

    public SteamResult sendMessageToUser(SteamID steamIDRemote, ByteBuffer data, SendFlag sendFlags, int channel) throws SteamException {
        if (!data.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }

        int value = SteamNetworkingMessagesNative.sendMessageToUser(SteamNativeHandle.getNativeHandle(steamIDRemote), data, data.position(), data.remaining(), sendFlags.value, channel);
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
