package com.nebirid.core.ui.components

import androidx.compose.runtime.Stable

@Stable
data class MainDestination(
    val route: String,
    val unselectedIconId: Int,
    val selectedIconId: Int? = null,
    val name: String? = null
)