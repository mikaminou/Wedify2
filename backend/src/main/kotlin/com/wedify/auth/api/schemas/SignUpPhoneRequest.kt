package com.wedify.auth.api.schemas

import kotlinx.serialization.Serializable

@Serializable
data class SignUpPhoneRequest(
    val phone: String,
    val password: String,
    val channel: PhoneChannel = PhoneChannel.SMS
)

@Serializable
enum class PhoneChannel {
    SMS,
    WHATSAPP
}
