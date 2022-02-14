package org.snappier.camera.camera

import androidx.camera.core.ImageCapture
import org.snappier.camera.MainActivity
import org.snappier.camera.capturer.Capturer
import org.snappier.camera.capturer.ImageCapturer

class PhotoCamera(
        private val activity: MainActivity) : Camera(activity) {
    private var captureMode: Int = ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY

    override fun buildCapturer(): Capturer {
        return ImageCapturer(activity.contentResolver, captureMode, activity.mainExecutor)
    }

    fun handleCaptureModeChange(captureMode: Int) {
        this.captureMode = captureMode
    }

    fun takePhoto() {
        (capturer as ImageCapturer).takePhoto()
    }
}