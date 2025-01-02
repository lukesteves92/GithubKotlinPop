package com.challenge.kotlinpop.domain.mapping

import br.com.challenge.kotlinpop.common.domain.platform.PlatformModel
import com.challenge.kotlinpop.platform.Platform

fun Platform.toModel() = PlatformModel(
    isDebugVersion = this.isDebugVersion,
    appVersion = this.appVersion,
    osName = this.osName,
    osVersion = this.osVersion,
    deviceModel = this.deviceModel,
    density = this.density
)