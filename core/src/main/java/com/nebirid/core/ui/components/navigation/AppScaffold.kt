package com.nebirid.core.ui.components.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.window.core.layout.WindowSizeClass
import com.nebirid.core.ui.components.MainDestination
import com.nebirid.core.ui.components.navigation.NavigationType.NAVIGATION_BAR
import com.nebirid.core.ui.components.navigation.NavigationType.NAVIGATION_DRAWER
import com.nebirid.core.ui.components.navigation.NavigationType.NAVIGATION_RAIL

@Composable
fun AppScaffold(
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass,
    destinations: List<MainDestination>,
    selectedDestination: MainDestination,
    onNewDestinationSelected: (MainDestination) -> Unit,
    content: @Composable () -> Unit
) {
    val navigationType = NavigationType.get(windowSizeClass)

    val appNavigationBar: @Composable () -> Unit = {
        AppNavigationBar(
            destinations = destinations,
            selectedDestination = selectedDestination,
            onClick = onNewDestinationSelected
        )
    }

    val appNavigationRail: @Composable (innerPadding: PaddingValues) -> Unit = { paddingValues ->
        Row {
            AppNavigationRail(
                destinations = destinations,
                selectedDestination = selectedDestination,
                onClick = onNewDestinationSelected
            )

            Box(modifier = Modifier.padding(paddingValues)) {
                content()
            }
        }
    }

    val appNavigationDrawer: @Composable (innerPadding: PaddingValues) -> Unit = { paddingValues ->
        AppNavigationDrawer(
            destinations = destinations,
            selectedDestination = selectedDestination,
            onClick = onNewDestinationSelected
        ) {
            Box(modifier = Modifier.padding(paddingValues)) {
                content()
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (navigationType == NAVIGATION_BAR) appNavigationBar()
        }
    ) { innerPadding ->

        when (navigationType) {
            NAVIGATION_RAIL -> appNavigationRail(innerPadding)
            NAVIGATION_DRAWER -> appNavigationDrawer(innerPadding)
            else -> {
                Box(modifier = Modifier.padding(innerPadding)) {
                    content()
                }
            }
        }
    }
}