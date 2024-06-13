package com.irem.flavorhub.data.source.network.usecase.app_entry

import com.irem.flavorhub.data.source.network.LocalUserManager

import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}