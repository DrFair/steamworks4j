package com.codedisaster.steamworks;

import java.nio.ByteBuffer;

@SuppressWarnings("unused")
public class SteamNetworkingMessage {

    public final long messagePointer;
    public final ByteBuffer data;
    public final int size;
    public final int channel;
    public final SteamID remoteSteamID;

    public SteamNetworkingMessage(long messagePointer, ByteBuffer data, int size, int channel, long remoteSteamID) {
        this.messagePointer = messagePointer;
        this.data = data;
        this.size = size;
        this.channel = channel;
        this.remoteSteamID = new SteamID(remoteSteamID);
    }

    public void free() {
        SteamNetworkingMessagesNative.releaseMessage(messagePointer);
    }
}
