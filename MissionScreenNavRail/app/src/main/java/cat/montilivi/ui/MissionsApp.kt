package cat.montilivi.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass

@Composable
fun MissionsApp() {
    val navigationController = rememberNavController();
    val windowInfo = currentWindowAdaptiveInfo()
    val isWiderThanMedium = windowInfo.windowSizeClass
        .isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)

    if (isWiderThanMedium)
        AppNavigationRail(navigationController)
    else
        AppNavigationBar(navigationController)
}