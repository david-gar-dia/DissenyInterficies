package cat.montilivi.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.model.Mission
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.pantalles.MissionDetailsScreen
import kotlinx.coroutines.launch

@Composable
fun AppTabs() {
    MyTabsScaffold();
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompletePager(modifier: Modifier, missions: List<Mission>) {
    val pagerState = rememberPagerState(pageCount = { missions.size });
    val coroutineScope = rememberCoroutineScope();

    Column(
        modifier = modifier,
    ) {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp,
        ) {
            missions.forEachIndexed { index, mission ->
                Tab(
                    selected = index == pagerState.currentPage,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    content = {
                        Text(text = mission.solicitant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                )
            }
        }
        HorizontalPager(
            modifier= Modifier.weight(1f),
            state = pagerState
        ) {
                page ->
            MissionDetailsScreen(
                missionId = missions[page].id.toString()
            )
        }
    }
}
