package br.senai.sp.jandira.grupo

import GrupoTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrupoTheme (darkTheme = isSystemInDarkTheme()) {
                MeusGruposScreen()
            }
        }
    }
}



@Composable
fun AppJourney() {
    GrupoTheme(darkTheme = isSystemInDarkTheme()) {
        CriarGrupoScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAppJourney(){
    AppJourney()
}