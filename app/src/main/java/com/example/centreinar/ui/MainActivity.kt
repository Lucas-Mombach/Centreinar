    package com.example.centreinar.ui

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Text
    import androidx.compose.material3.TopAppBar
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.remember
    import androidx.hilt.navigation.compose.hiltViewModel
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import androidx.navigation.navigation
    import com.example.centreinar.ui.classificationProcess.screens.ClassificationInputScreen
    import com.example.centreinar.ui.classificationProcess.screens.ClassificationResult
    import com.example.centreinar.ui.classificationProcess.screens.ColorClassInput
    import com.example.centreinar.ui.classificationProcess.screens.DisqualificationScreen
    import com.example.centreinar.ui.classificationProcess.screens.GrainScreen
    import com.example.centreinar.ui.classificationProcess.screens.GroupSelectionScreen
    import com.example.centreinar.ui.classificationProcess.screens.HomeScreen
    import com.example.centreinar.ui.classificationProcess.screens.LimitInputScreen
    import com.example.centreinar.ui.classificationProcess.screens.OfficialOrNotOfficialScreen
    import com.example.centreinar.ui.classificationProcess.viewmodel.ClassificationViewModel
    import com.example.centreinar.ui.theme.CentreinarTheme
    import dagger.hilt.android.AndroidEntryPoint

    @AndroidEntryPoint
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                CentreinarTheme {
                    CentreinarApp()
                }
            }
        }
    }
//    modifier = Modifier.padding(padding)

    @Composable
    fun CentreinarApp() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "main_flow"
        ) {
            navigation(
                startDestination = "home",
                route = "main_flow"
            ) {
                composable("home") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    HomeScreen(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }

                composable("grainSelection") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    GrainScreen(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }

                composable("groupSelection") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    GroupSelectionScreen(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }

                composable("officialOrNot") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    OfficialOrNotOfficialScreen(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }

                composable("limitInput") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    LimitInputScreen(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }

                composable("disqualification") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    DisqualificationScreen(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }

                composable("classification") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    ClassificationInputScreen(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }

                composable("classificationResult") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    ClassificationResult(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }
                composable("colorClassInput") { backStackEntry ->
                    val parentEntry = remember(backStackEntry) {
                        navController.getBackStackEntry("main_flow")
                    }
                    ColorClassInput(
                        navController,
                        hiltViewModel<ClassificationViewModel>(parentEntry)
                    )
                }


                composable("discount") { /* Similar structure for discount screen */ }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun SimpleAppBar() {
        TopAppBar(
            title = { Text("Centreinar") },
        )
    }