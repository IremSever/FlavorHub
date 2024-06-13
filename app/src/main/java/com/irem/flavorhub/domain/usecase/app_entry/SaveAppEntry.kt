package com.irem.flavorhub.domain.usecase.app_entry

import com.irem.flavorhub.domain.LocalUserManager

import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}