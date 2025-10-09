package br.senai.sp.jandira.grupo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import br.senai.sp.jandira.grupo.ui.theme.DrawerContent
import kotlinx.coroutines.launch
import br.senai.sp.jandira.grupo.ui.theme.GrupoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var isDarkTheme by remember { mutableStateOf(false) }
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()


            var currentScreen by remember { mutableStateOf("meus_grupos") }

            GrupoTheme(darkTheme = isDarkTheme) {

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        DrawerContent (
                            onCloseDrawer = {
                                scope.launch { drawerState.close() }
                            },
                            onNavigateToMeusGrupos = {
                                currentScreen = "meus_grupos"
                                scope.launch { drawerState.close() }
                            },
                            onNavigateToCriarGrupo = {
                                currentScreen = "criar_grupo"
                                scope.launch { drawerState.close() }
                            }
                        )
                    }
                ) {
                    when (currentScreen) {
                        "meus_grupos" -> MeusGruposScreen(
                            drawerState = drawerState,
                            scope = scope,
                            isDarkTheme = isDarkTheme,
                            onThemeToggle = { isDarkTheme = !isDarkTheme },
                            onNavigateToCreate = { currentScreen = "criar_grupo" }
                        )

                        "criar_grupo" -> CriarGrupoScreen(
                            drawerState = drawerState,
                            scope = scope,
                            isDarkTheme = isDarkTheme,
                            onThemeToggle = { isDarkTheme = !isDarkTheme },
                            onNavigateBack = { currentScreen = "meus_grupos" }
                        )
                    }
                }
            }
        }
    }
}
