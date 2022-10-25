package com.codedisaster.steamworks;

@SuppressWarnings("unused")
class SteamNetworkingMessagesCallbackAdapter extends SteamCallbackAdapter<SteamNetworkingMessagesCallback> {

	SteamNetworkingMessagesCallbackAdapter(SteamNetworkingMessagesCallback callback) {
		super(callback);
	}

	void onSteamNetworkingMessagesSessionRequest(long steamIDRemote) {
		SteamID id = new SteamID(steamIDRemote);
		callback.onSteamNetworkingMessagesSessionRequest(id);
	}

	void onSteamNetworkingMessagesSessionFailed(long steamIDRemote) {
		SteamID id = new SteamID(steamIDRemote);
		callback.onSteamNetworkingMessagesSessionFailed(id);
	}
}
