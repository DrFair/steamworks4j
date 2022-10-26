package com.codedisaster.steamworks;

import java.nio.ByteBuffer;

public class SteamNetworkingMessagesNative {

    // @off

	/*JNI
		#include <steam_api.h>
		#include "SteamNetworkingMessagesCallback.h"
	*/

    static native long createCallback(SteamNetworkingMessagesCallbackAdapter javaCallback); /*
		return (intp) new SteamNetworkingMessagesCallback(env, javaCallback);
	*/

    static native int sendMessageToUser(long steamIDRemote, ByteBuffer data, int offset, int size, int sendFlags, int channel); /*
        SteamNetworkingIdentity identity;
        identity.SetSteamID64(steamIDRemote);
		return SteamNetworkingMessages()->SendMessageToUser(identity, &data[offset], size, sendFlags, channel);
	*/

    static native int receiveMessagesOnChannel(int channel, SteamNetworkingMessage[] outMessages, int maxMessages); /*
	    SteamNetworkingMessage_t* msgs[32];
	    int res = SteamNetworkingMessages()->ReceiveMessagesOnChannel(channel, msgs, maxMessages);
	    for (int i = 0; i < res; i++) {
		    jclass javaMessageClass = env->FindClass("com/codedisaster/steamworks/SteamNetworkingMessage");
		    jclass javaMessageGlobalClass = reinterpret_cast<jclass>(env->NewGlobalRef(javaMessageClass));
		    jmethodID javaMessageConstructor = env->GetMethodID(javaMessageGlobalClass, "<init>", "(JLjava/nio/ByteBuffer;IIJ)V");

		    SteamNetworkingMessage_t* message = msgs[i];
		    jobject messageObject = env->NewObject(javaMessageGlobalClass, javaMessageConstructor,
		        (uintptr_t)message,
		        env->NewDirectByteBuffer(message->m_pData, message->m_cbSize),
		        message->m_cbSize,
		        message->m_nChannel,
		        message->m_identityPeer.GetSteamID64()
		    );

		    env->SetObjectArrayElement(outMessages, i, messageObject);
		    // Message is freed using releaseMessage(...)
	    }
	    return res;
	*/

    static native void releaseMessage(long messagePointer); /*
        SteamNetworkingMessage_t* message = (SteamNetworkingMessage_t*) messagePointer;
        message->Release();
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
