package com.nebirid.greengram.ui.components

import android.annotation.SuppressLint
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.window.core.layout.WindowSizeClass
import com.nebirid.core.ui.components.MainDestination
import com.nebirid.core.ui.components.navigation.AppScaffold
import com.nebirid.greengram.ui.theme.GreenGramTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GreenGramApp(
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
) {
    var selectedDestination by remember {
        mutableStateOf(HomeDestination)
    }

    val onNewDestinationSelected: (MainDestination) -> Unit = {
        selectedDestination = it
    }

    AppScaffold(
        destinations = destinations,
        selectedDestination = selectedDestination,
        onNewDestinationSelected = onNewDestinationSelected
    ) {
        // screens here
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
        GreenGramApp()
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
        GreenGramApp()
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
        GreenGramApp()
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
        GreenGramApp()
    }
}