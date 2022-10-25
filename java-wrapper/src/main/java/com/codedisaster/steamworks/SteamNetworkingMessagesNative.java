package com.codedisaster.steamworks;

public class SteamNetworkingMessagesNative {

    // @off

	/*JNI
		#include <steam_api.h>
		#include "SteamNetworkingMessagesCallback.h"
	*/

    static native long createCallback(SteamNetworkingMessagesCallbackAdapter javaCallback); /*
		return (intp) new SteamNetworkingMessagesCallback(env, javaCallback);
	*/

    static native int sendMessageToUser(long steamIDRemote, byte[] data, int dataSize, int sendFlags, int channel); /*
        SteamNetworkingIdentity identity;
        identity.SetSteamID64(steamIDRemote);
		return SteamNetworkingMessages()->SendMessageToUser(identity, data, dataSize, sendFlags, channel);
	*/

    static native int receiveMessagesOnChannel(int channel, SteamNetworkingMessage[] outMessages, int maxMessages); /*
	    SteamNetworkingMessage_t* msgs[32];
	    int res = SteamNetworkingMessages()->ReceiveMessagesOnChannel(channel, msgs, maxMessages);
	    for (int i = 0; i < res; i++) {
		    jclass javaMessageClass = env->FindClass("com/codedisaster/steamworks/SteamNetworkingMessage");
		    jclass javaMessageGlobalClass = reinterpret_cast<jclass>(env->NewGlobalRef(javaMessageClass));
		    jmethodID javaMessageConstructor = env->GetMethodID(javaMessageGlobalClass, "<init>", "(Ljava/nio/ByteBuffer;IJ)V");

		    SteamNetworkingMessage_t* message = msgs[i];
		    jobject messageObject = env->NewObject(javaMessageGlobalClass, javaMessageConstructor, env->NewDirectByteBuffer(message->m_pData, message->m_cbSize), message->m_cbSize, message->m_identityPeer.GetSteamID64());
		    env->SetObjectArrayElement(outMessages, i, messageObject);

		    message->Release();
	    }
	    return res;
	*/

    static native boolean acceptSessionWithUser(long steamIDRemote); /*
        SteamNetworkingIdentity identity;
        identity.SetSteamID64(steamIDRemote);
        return SteamNetworkingMessages()->AcceptSessionWithUser(identity);
    */

    static native boolean closeSessionWithUser(long steamIDRemote); /*
        SteamNetworkingIdentity identity;
        identity.SetSteamID64(steamIDRemote);
        return SteamNetworkingMessages()->CloseSessionWithUser(identity);
    */

    static native boolean closeChannelWithUser(long steamIDRemote, int channel); /*
        SteamNetworkingIdentity identity;
        identity.SetSteamID64(steamIDRemote);
        return SteamNetworkingMessages()->CloseChannelWithUser(identity, channel);
    */

}
