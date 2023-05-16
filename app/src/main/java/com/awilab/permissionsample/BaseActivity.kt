package com.awilab.permissionsample

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.READ_MEDIA_AUDIO
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.READ_MEDIA_VIDEO
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.permissionx.guolindev.PermissionX

open class BaseActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        requestPermission()
    }

    private fun requestPermission() {
        PermissionX.init(this)
            .permissions(
                ACCESS_FINE_LOCATION,
                READ_MEDIA_IMAGES,
                READ_MEDIA_VIDEO,
                READ_MEDIA_AUDIO
            )
            .request { allGranted, grantedList, deniedList ->
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