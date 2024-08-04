package com.nebirid.core.ui.components.navigation

import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

enum class NavigationType {
    NAVIGATION_BAR,
    NAVIGATION_RAIL,
    NAVIGATION_DRAWER;

    companion object {
        fun get(windowSizeClass: WindowSizeClass): NavigationType {
            return when (windowSizeClass.windowWidthSizeClass) {
                WindowWidthSizeClass.COMPACT -> NAVIGATION_BAR
                WindowWidthSizeClass.MEDIUM -> NAVIGATION_RAIL
                WindowWidthSizeClass.EXPANDED -> NAVIGATION_DRAWER
                else -> NAVIGATION_BAR
            }
        }
    }
}