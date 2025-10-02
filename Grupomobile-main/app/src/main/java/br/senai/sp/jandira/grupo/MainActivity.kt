package br.senai.sp.jandira.grupo

import GrupoTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrupoTheme(darkTheme = isSystemInDarkTheme()) {
                AppJourney()
            }
        }
    }
}

@Composable
fun AppJourney() {
    var currentScreen by remember { mutableStateOf("meusGrupos") }

    Box(modifier = Modifier.fillMaxSize()) {
        when (currentScreen) {
            "meusGrupos" -> MeusGruposScreen(
                onNavigateToCreate = { currentScreen = "criarGrupo" }
            )
            "criarGrupo" -> CriarGrupoScreen(
                onNavigateBack = { currentScreen = "meusGrupos" }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAppJourney() {
    GrupoTheme(darkTheme = false) {
        AppJourney()
    }
}
