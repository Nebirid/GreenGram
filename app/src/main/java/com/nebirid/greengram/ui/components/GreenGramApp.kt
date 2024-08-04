package com.nebirid.greengram.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass.Companion.COMPACT
import com.nebirid.core.ui.components.MainDestination
import com.nebirid.greengram.ui.theme.GreenGramTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GreenGramApp(
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
) {
    val showBottomBar = windowSizeClass.windowWidthSizeClass == COMPACT
    val showNavigationRail = windowSizeClass.windowWidthSizeClass != COMPACT

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) GreenGramNavigationBar(destinations, SearchDestination)
        }
    ) { innerPadding ->

        if (showNavigationRail){ GreenGramNavigationRail(destinations, SearchDestination) }
    }
}

@Composable
fun GreenGramNavigationBar(
    destinations: List<MainDestination>,
    selectedDestination: MainDestination
) {
    NavigationBar {
        destinations.forEach { destination ->

            val selected by derivedStateOf { destination == selectedDestination }

            val iconId = if (selected && destination.selectedIconId != null) {
                destination.selectedIconId!!
            } else {
                destination.unselectedIconId
            }

            NavigationBarItem(
                selected = selected,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = iconId),
                        contentDescription = destination.name
                    )
                }
            )
        }
    }
}

@Composable
fun GreenGramNavigationRail(
    destinations: List<MainDestination>,
    selectedDestination: MainDestination
) {
    NavigationRail {
        destinations.forEach { destination ->

            val selected by derivedStateOf { destination == selectedDestination }

            val iconId = if (selected && destination.selectedIconId != null) {
                destination.selectedIconId!!
            } else {
                destination.unselectedIconId
            }

            NavigationRailItem(
                selected = selected,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = iconId),
                        contentDescription = destination.name
                    )
                }
            )
        }
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