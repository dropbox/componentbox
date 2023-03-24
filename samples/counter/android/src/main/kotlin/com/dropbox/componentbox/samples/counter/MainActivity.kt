package com.dropbox.componentbox.samples.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.dropbox.componentbox.samples.counter.common.zipline.ComponentBoxService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val service = ComponentBoxService(scope)
    private val componentBox = service.componentBox
    private val render = RenderingEngine()
    override fun onStart() {
        super.onStart()
        service.launch(LOCAL_MANIFEST_URL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val root = componentBox.collectAsState()
            render {
                root.value
            }
        }
    }

    companion object {
        private const val JS_BINARY_URL = "https://api.componentbox.dropboxer.io/best/js/1"
        private const val LOCAL_MANIFEST_URL = "http://10.0.2.2:8080/manifest.zipline.json"
    }
}