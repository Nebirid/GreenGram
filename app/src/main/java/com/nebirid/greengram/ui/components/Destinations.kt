package com.nebirid.greengram.ui.components

import com.nebirid.core.ui.components.MainDestination
import com.nebirid.greengram.R

val HomeDestination = MainDestination(
    route = "",
    unselectedIconId = R.drawable.home_24dp_e8eaed_fill0_wght400_grad0_opsz24,
    selectedIconId = R.drawable.home_24dp_e8eaed_fill1_wght400_grad0_opsz24,
    name = "Home"
)

val SearchDestination = MainDestination(
    route = "",
    unselectedIconId = R.drawable.search_24dp_e8eaed_fill1_wght400_grad0_opsz24,
    selectedIconId = R.drawable.search_24dp_e8eaed_fill0_wght600_grad0_opsz24,
    name = "Search"
)

val SettingsDestination = MainDestination(
    route = "",
    unselectedIconId = R.drawable.settings_24dp_e8eaed_fill0_wght400_grad0_opsz24,
    selectedIconId = R.drawable.settings_24dp_e8eaed_fill1_wght400_grad0_opsz24,
    name = "Settings"
)

val destinations: List<MainDestination> =
    listOf(HomeDestination, SearchDestination, SettingsDestination)