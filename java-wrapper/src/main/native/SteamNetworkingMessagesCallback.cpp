#include "SteamNetworkingMessagesCallback.h"

SteamNetworkingMessagesCallback::SteamNetworkingMessagesCallback(JNIEnv* env, jobject callback)
	: SteamCallbackAdapter(env, callback)
	, m_CallbackSteamNetworkingMessagesSessionRequest(this, &SteamNetworkingMessagesCallback::onSteamNetworkingMessagesSessionRequest)
	, m_CallbackSteamNetworkingMessagesSessionFailed(this, &SteamNetworkingMessagesCallback::onSteamNetworkingMessagesSessionFailed) {

}

SteamNetworkingMessagesCallback::~SteamNetworkingMessagesCallback() {

}

void SteamNetworkingMessagesCallback::onSteamNetworkingMessagesSessionRequest(SteamNetworkingMessagesSessionRequest_t* callback) {
	invokeCallback({
		callVoidMethod(env, "onSteamNetworkingMessagesSessionRequest", "(J)V",
			(jlong) callback->m_identityRemote.GetSteamID64());
	});
}

void SteamNetworkingMessagesCallback::onSteamNetworkingMessagesSessionFailed(SteamNetworkingMessagesSessionFailed_t* callback) {
	invokeCallback({
		callVoidMethod(env, "onSteamNetworkingMessagesSessionFailed", "(J)V",
			(jlong) callback->m_info.m_identityRemote.GetSteamID64());
	});
}
