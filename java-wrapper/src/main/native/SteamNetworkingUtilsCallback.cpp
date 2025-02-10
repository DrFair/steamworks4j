#include "SteamNetworkingUtilsCallback.h"

static SteamNetworkingUtilsCallback* s_outputHookInstance = NULL;

SteamNetworkingUtilsCallback::SteamNetworkingUtilsCallback(JNIEnv* env, jobject callback)
	: SteamCallbackAdapter(env, callback) {
}

SteamNetworkingUtilsCallback::~SteamNetworkingUtilsCallback() {

}

extern "C" void __cdecl SteamAPIDebugOutputTextHook(ESteamNetworkingSocketsDebugOutputType debugType, const char *debugText) {
	if (s_outputHookInstance != NULL) {
		s_outputHookInstance->onDebugOutput(debugType, debugText);
	}
}

void SteamNetworkingUtilsCallback::enableDebugOutputHook(bool enabled, int detailLevel) {
	s_outputHookInstance = enabled ? this : NULL;
	SteamNetworkingUtils()->SetDebugOutputFunction((ESteamNetworkingSocketsDebugOutputType)detailLevel, enabled ? &SteamAPIDebugOutputTextHook : NULL);
}

void SteamNetworkingUtilsCallback::onDebugOutput(int debugType, const char *debugText) {
	invokeCallback({
		callVoidMethod(env, "onDebugOutput", "(ILjava/lang/String;)V",
			debugType, env->NewStringUTF(debugText));
	});
}
