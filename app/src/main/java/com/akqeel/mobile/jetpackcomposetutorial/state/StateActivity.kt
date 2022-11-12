package com.akqeel.mobile.jetpackcomposetutorial.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akqeel.mobile.jetpackcomposetutorial.basics.ui.theme.JetpackComposeTutorialTheme
import com.akqeel.mobile.jetpackcomposetutorial.state.model.WellnessTask
import com.akqeel.mobile.jetpackcomposetutorial.state.ui.WellnessScreen
import com.akqeel.mobile.jetpackcomposetutorial.state.ui.WellnessTaskItem

class StateActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun StateActivityPreview() {
    JetpackComposeTutorialTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WellnessScreen()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}
