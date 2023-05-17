package com.awilab.permissionsample

import android.os.Build
import androidx.annotation.RequiresApi

object DeviceSDK {
    // Android 13
    val isAfter33: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU

    // Android 12
    val isAfter32: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S_V2
    val isAfter31: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    // Android 11
    val isAfter30: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R

    // Android 10
    val isAfter29: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q

    // Android 9
    val isAfter28: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P

    // Android 8.1
    val isAfter27: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1
    // Android 8
    val isAfter26: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

    // Android 7
    val isAfter25: Boolean
        @RequiresApi(Build.VERSION_CODES.N_MR1)
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1
}