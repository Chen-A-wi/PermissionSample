package com.awilab.permissionsample

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.MANAGE_EXTERNAL_STORAGE
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_AUDIO
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.READ_MEDIA_VIDEO
import android.Manifest.permission.READ_PHONE_STATE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.request.PermissionBuilder

open class BaseActivity : AppCompatActivity() {

    private val permissions: MutableList<String> = mutableListOf(
        ACCESS_FINE_LOCATION,
        READ_EXTERNAL_STORAGE,
        READ_PHONE_STATE,
        MANAGE_EXTERNAL_STORAGE,
        READ_MEDIA_IMAGES,
        READ_MEDIA_VIDEO,
        READ_MEDIA_AUDIO
    )

    override fun onResume() {
        super.onResume()

        requestPermission()
    }

    private fun getAPIPermissions(): List<String> {
        return if (DeviceSDK.isAfter33) {
            permissions.removeAll(
                setOf(
                    MANAGE_EXTERNAL_STORAGE,
                    READ_EXTERNAL_STORAGE,
                    MANAGE_EXTERNAL_STORAGE
                )
            )
            permissions.toList()
        } else if (DeviceSDK.isAfter30) {
            permissions.removeAll(
                setOf(
                    READ_MEDIA_AUDIO,
                    READ_MEDIA_IMAGES,
                    READ_MEDIA_VIDEO,
                    READ_EXTERNAL_STORAGE,
                    MANAGE_EXTERNAL_STORAGE
                )
            )
            permissions.toList()
        } else {
            permissions.removeAll(
                setOf(
                    READ_MEDIA_AUDIO,
                    READ_MEDIA_IMAGES,
                    READ_MEDIA_VIDEO,
                    MANAGE_EXTERNAL_STORAGE,
                )
            )
            permissions.toList()
        }
    }

    private fun getPermissionBuild(): PermissionBuilder {
        return PermissionX.init(this).permissions(getAPIPermissions())
    }

    private fun requestPermission() {
        getPermissionBuild().request { allGranted, grantedList, deniedList ->
            if (allGranted) {
                Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    this,
                    "These permissions are denied: $deniedList",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}