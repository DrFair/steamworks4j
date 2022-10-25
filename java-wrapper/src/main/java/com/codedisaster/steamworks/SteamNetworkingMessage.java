package com.codedisaster.steamworks;

import java.nio.ByteBuffer;

public class SteamNetworkingMessage {

    public final ByteBuffer data;
    public final int size;
    public final SteamID remoteSteamID;

    public SteamNetworkingMessage(ByteBuffer data, int size, long remoteSteamID) {
        this.data = data;
        this.size = size;
        this.remoteSteamID = new SteamID(remoteSteamID);
    }
}
