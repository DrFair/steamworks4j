package com.codedisaster.steamworks;

final class SteamNetworkingUtilsNative {

	// @off

	/*JNI
		#include <steam_api.h>
		#include "SteamNetworkingUtilsCallback.h"
	*/

	static native long createCallback(SteamNetworkingUtilsCallbackAdapter javaCallback); /*
		return (intp) new SteamNetworkingUtilsCallback(env, javaCallback);
	*/

	static native void enableDebugOutputHook(long callback, boolean enable, int detailLevel); /*
		SteamNetworkingUtilsCallback* cb = (SteamNetworkingUtilsCallback*) callback;
		cb->enableDebugOutputHook(enable, detailLevel);
	*/

}
