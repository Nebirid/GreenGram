package com.nebirid.core.ui.components.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.nebirid.core.ui.components.MainDestination

@Composable
fun AppNavigationDrawer(
    destinations: List<MainDestination>,
    selectedDestination: MainDestination,
    onClick: (MainDestination) -> Unit,
    content: @Composable () -> Unit
) {
    val drawerContent: @Composable () -> Unit = {
        Column {
            destinations.forEach { destination ->

                val selected by derivedStateOf { destination == selectedDestination }

                val iconId = if (selected && destination.selectedIconId != null) {
                    destination.selectedIconId
                } else {
                    destination.unselectedIconId
                }

                NavigationDrawerItem(
                    label = {
                        destination.name?.let {
                            Text(text = it, style = MaterialTheme.typography.labelLarge)
                        }
                    },
                    selected = selected,
                    onClick = { onClick(destination) },
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = iconId),
                            contentDescription = destination.name
                        )
                    },
                )
            }
        }
    }

    PermanentNavigationDrawer(
        drawerContent = drawerContent
    ) {
        content()
    }
}