package com.wedify.domain.mappers

import com.wedify.api.dto.auth.AuthUserInfo
import io.github.jan.supabase.auth.user.UserInfo

fun UserInfo.toAuthUserInfo(): AuthUserInfo =
    AuthUserInfo(
        id = id,
        email = email,
        phone = phone,
        createdAt = createdAt?.toString(),
        confirmedAt = confirmedAt?.toString()
    )
