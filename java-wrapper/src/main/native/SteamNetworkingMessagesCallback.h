#pragma once

#include "SteamCallbackAdapter.h"
#include <steam_api.h>

class SteamNetworkingMessagesCallback : public SteamCallbackAdapter {

public:
	SteamNetworkingMessagesCallback(JNIEnv* env, jobject callback);
	~SteamNetworkingMessagesCallback();

	STEAM_CALLBACK(SteamNetworkingMessagesCallback, onSteamNetworkingMessagesSessionRequest, SteamNetworkingMessagesSessionRequest_t, m_CallbackSteamNetworkingMessagesSessionRequest);
	STEAM_CALLBACK(SteamNetworkingMessagesCallback, onSteamNetworkingMessagesSessionFailed, SteamNetworkingMessagesSessionFailed_t, m_CallbackSteamNetworkingMessagesSessionFailed);
};
