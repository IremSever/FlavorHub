package com.irem.flavorhub.domain.usecase.app_entry

import com.irem.flavorhub.domain.LocalUserManager

class SaveAppEntry(
    private val localUserManger: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}