package com.nebirid.greengram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.nebirid.greengram.ui.theme.GreenGramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenGramTheme(
                dynamicColor = false
            ) {
                GreenGramApp()
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = "Monstera Unique",
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Preview(
    name = "Light Theme - Phone",
    group = "Phone",
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO,
    device = Devices.PHONE
)
@Composable
fun LightThemePhonePreview() {
    GreenGramTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Greeting(modifier = Modifier.fillMaxSize())
    }
}

@Preview(
    name = "Dark Theme - Phone",
    group = "Phone",
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES,
    device = Devices.PHONE
)
@Composable
fun DarkThemePhonePreview() {
    GreenGramTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        Greeting(modifier = Modifier.fillMaxSize())
    }
}

@Preview(
    name = "Light Theme - Tablet",
    group = "Tablet",
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO,
    device = Devices.TABLET
)
@Composable
fun LightThemeTabletPreview() {
    GreenGramTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Greeting(modifier = Modifier.fillMaxSize())
    }
}

@Preview(
    name = "Dark Theme - Tablet",
    group = "Tablet",
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES,
    device = Devices.TABLET
)
@Composable
fun DarkThemeTabletPreview() {
    GreenGramTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        Greeting(modifier = Modifier.fillMaxSize())
    }
}