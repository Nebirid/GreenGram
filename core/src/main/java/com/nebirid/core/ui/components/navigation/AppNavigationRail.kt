package com.nebirid.core.ui.components.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.nebirid.core.ui.components.MainDestination

@Composable
fun AppNavigationRail(
    destinations: List<MainDestination>,
    selectedDestination: MainDestination,
    onClick: (MainDestination) -> Unit
) {
    NavigationRail {
        destinations.forEach { destination ->

            val selected by derivedStateOf { destination == selectedDestination }

            val iconId = if (selected && destination.selectedIconId != null) {
                destination.selectedIconId
            } else {
                destination.unselectedIconId
            }

            NavigationRailItem(
                selected = selected,
                onClick = { onClick(destination) },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = iconId),
                        contentDescription = destination.name
                    )
                },
                label = {
                    destination.name?.let {
                        Text(text = it, style = MaterialTheme.typography.labelLarge)
                    }
                }
            )
        }
    }
}