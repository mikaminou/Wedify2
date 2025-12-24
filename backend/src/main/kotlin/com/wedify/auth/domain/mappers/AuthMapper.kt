package com.wedify.auth.domain.mappers

import com.wedify.auth.api.schemas.AuthUserInfo
import io.github.jan.supabase.auth.user.UserInfo

fun UserInfo.toAuthUserInfo(): AuthUserInfo =
    AuthUserInfo(
        id = id,
        email = email,
        phone = phone,
        createdAt = createdAt?.toString(),
        confirmedAt = confirmedAt?.toString()
    )
