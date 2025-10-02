package br.senai.sp.jandira.grupo


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.ArrowDropDown
import br.senai.sp.jandira.grupo.ui.theme.DarkPrimaryPurple
import br.senai.sp.jandira.grupo.ui.theme.PrimaryPurple
import br.senai.sp.jandira.grupo.ui.theme.white

data class Grupo(
    val nome: String,
    val membros: String,
    val icon: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeusGruposScreen(){
    val grupos = listOf(
        Grupo("Medicina", "30 Membros (limite atingido)", android.R.drawable.ic_menu_info_details),
        Grupo("Desenvolvimento de Sistemas", "12 Membros", android.R.drawable.ic_menu_manage)
    )
    Scaffold (
        topBar =  {
            TopAppBar(
                title = {
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Image(
                            painter = painterResource(id = R.drawable.jclaro),
                            contentDescription = "Logo Journey",
                            modifier = Modifier
                                .size(62.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Journey", color = white)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {/*ação p ir p menu dps*/}) {
                        Icon(Icons.Default.Menu,
                            contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* mudar tema */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.lua),
                            contentDescription = "Tema",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(onClick = {  }) {
                        Image(
                            painter = painterResource(id = R.drawable.perfil),
                            contentDescription = "Perfil",
                            modifier = Modifier.size(24.dp)
                        )
                    }},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkPrimaryPurple
                ))
        }
    ){ padding ->
        Column (modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(Color.White)
        ){
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(DarkPrimaryPurple)
                    .fillMaxSize()
            ){
                Column (
                    modifier = Modifier.padding(16.dp)
                ){  Text(text = "Meus Grupos",
                    style = MaterialTheme.typography.headlineSmall.copy(color = white)
                )
                    Spacer(Modifier.height(12.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Criar Grupo",
                                tint = DarkPrimaryPurple
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                "Criar Grupo", color = DarkPrimaryPurple
                            )
                        }
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = white)
                        ) {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "categoria",
                                tint = DarkPrimaryPurple
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                "Categoria", color = DarkPrimaryPurple
                            )
                        }
                    }

                        Spacer(Modifier.height(16.dp))

                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(grupos) { grupo ->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = PrimaryPurple
                                    )
                                ) {
                                    Row(
                                        modifier = Modifier.padding(16.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Icon(
                                            painter = painterResource(id = grupo.icon),
                                            contentDescription = grupo.nome,
                                            tint= Color.White,
                                            modifier = Modifier.size(32.dp)
                                        )
                                        Spacer(Modifier.width(12.dp))
                                        Column {
                                            Text(grupo.nome, color= Color.White, style = MaterialTheme.typography.titleMedium)
                                            Text(grupo.membros, color = Color.White.copy(alpha = 0.8f))
                                        }
                                    }
                                }
                            }
                        }
                }





                }
            }
        }
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMeusGruposScreen(){
        MeusGruposScreen()
}