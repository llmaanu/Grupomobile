package br.senai.sp.jandira.grupo
import GrupoTheme
import android.R.attr.fontWeight
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.input.KeyboardType
import br.senai.sp.jandira.grupo.ui.theme.DarkPrimaryPurple
import br.senai.sp.jandira.grupo.ui.theme.LightAccent
import br.senai.sp.jandira.grupo.ui.theme.lightpurple
import br.senai.sp.jandira.grupo.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CriarGrupoScreen(onNavigateBack: () -> Unit) {

    var nomeGrupo by remember { mutableStateOf("") }
    var areaEspecifica by remember { mutableStateOf("") }
    var limiteMembros by remember { mutableStateOf("") }
    var fotoperfil by remember { mutableStateOf("") }

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
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = LightAccent
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Image(
                            painter = painterResource(id = R.drawable.lua),
                            contentDescription = "Tema",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(id = R.drawable.perfil),
                            contentDescription = "Perfil",
                            modifier = Modifier.size(24.dp)
                        )
                    }},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkPrimaryPurple
                )
            )
        }
    ){ padding ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(lightpurple)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                "Crie Seu Grupo no JOURNEY!",
                style = MaterialTheme.typography.headlineSmall,
                color = DarkPrimaryPurple,
                fontWeight = FontWeight.Bold,
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(DarkPrimaryPurple)
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LightAccent
                        ),
                        modifier = Modifier.align(Alignment.Start)
                    ) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = DarkPrimaryPurple,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            "Voltar",
                            color = DarkPrimaryPurple,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }


                    Text(
                        text = "Nome do Grupo: ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    OutlinedTextField(
                        value = nomeGrupo,
                        onValueChange = { nomeGrupo = it },
                        placeholder = { Text("Digite o Nome do Grupo") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(50),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedPlaceholderColor = Color.LightGray,
                            unfocusedPlaceholderColor = Color.LightGray,
                        )
                    )

                    Text(
                        text = "Área Específica: ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    OutlinedTextField(
                        value = areaEspecifica,
                        onValueChange = { areaEspecifica = it },
                        placeholder = { Text("Digite a categoria") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(50),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedPlaceholderColor = Color.LightGray,
                            unfocusedPlaceholderColor = Color.LightGray,
                        )
                    )


                    Text(
                        text = "Limite de Membros: ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    OutlinedTextField(
                        value = limiteMembros,
                        onValueChange = { limiteMembros = it },
                        placeholder = { Text("Máximo 30 Participantes") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(50),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedPlaceholderColor = Color.LightGray,
                            unfocusedPlaceholderColor = Color.LightGray,
                        )
                    )
                    Text(
                        text = "Enviar foto: ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    OutlinedTextField(
                        value = fotoperfil,
                        onValueChange = { fotoperfil = it },
                        placeholder = { Text("Selecionar Arquivo ↓") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(50),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedPlaceholderColor = Color.LightGray,
                            unfocusedPlaceholderColor = Color.LightGray,
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = { println("Criar grupo") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LightAccent
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "Criar Grupo",
                            color = DarkPrimaryPurple,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            }
        }
    }


@Preview(showBackground = true, showSystemUi = true, name = "CriarGrupo - Claro")
@Composable
fun PreviewCriarGrupoLight() {
    GrupoTheme(darkTheme = false) {
        CriarGrupoScreen(onNavigateBack = {})
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "CriarGrupo - Escuro")
@Composable
fun PreviewCriarGrupoDark() {
    GrupoTheme(darkTheme = true) {
        CriarGrupoScreen(onNavigateBack = {})
    }
}