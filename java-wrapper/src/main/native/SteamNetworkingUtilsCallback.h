#pragma once

#include "SteamCallbackAdapter.h"
#include <steam_api.h>

class SteamNetworkingUtilsCallback : public SteamCallbackAdapter {

public:
	SteamNetworkingUtilsCallback(JNIEnv* env, jobject callback);
	~SteamNetworkingUtilsCallback();

	void enableDebugOutputHook(bool enabled, int detailLevel);
	void onDebugOutput(int debugType, const char *debugText);
};
