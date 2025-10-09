package br.senai.sp.jandira.grupo.ui.theme


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent(
    onCloseDrawer: () -> Unit,
    onNavigateToMeusGrupos: () -> Unit,
    onNavigateToCriarGrupo: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "Menu",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = onNavigateToMeusGrupos,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Meus Grupos", color = MaterialTheme.colorScheme.onPrimary)
        }
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = onNavigateToCriarGrupo,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Criar Grupo", color = MaterialTheme.colorScheme.onPrimary)
        }
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = onCloseDrawer,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text("Fechar Menu")
        }
    }
}
