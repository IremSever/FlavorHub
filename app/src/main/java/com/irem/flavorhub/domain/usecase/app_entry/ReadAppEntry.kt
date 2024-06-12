package com.irem.flavorhub.domain.usecase.app_entry

import com.irem.flavorhub.domain.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}