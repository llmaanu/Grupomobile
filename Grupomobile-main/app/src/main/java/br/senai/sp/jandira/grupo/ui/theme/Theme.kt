import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import br.senai.sp.jandira.grupo.ui.theme.BackgroundWhite
import br.senai.sp.jandira.grupo.ui.theme.DarkPrimaryPurple
import br.senai.sp.jandira.grupo.ui.theme.LightAccent
import br.senai.sp.jandira.grupo.ui.theme.PrimaryPurple
import br.senai.sp.jandira.grupo.ui.theme.PrimaryPurpleDark
import br.senai.sp.jandira.grupo.ui.theme.ReallyDarkPrimaryPurple
import br.senai.sp.jandira.grupo.ui.theme.white


private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimaryPurple,
    secondary = LightAccent,
    background = PrimaryPurpleDark,
    surface = ReallyDarkPrimaryPurple,
    onPrimary = white,
    onBackground = white,
    onSurface = white
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryPurple,
    secondary = LightAccent,
    background = BackgroundWhite,
    surface = white,
    onPrimary = white,
    onBackground = Color.Black,
    onSurface = Color.Black
)
@Composable
fun GrupoTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
