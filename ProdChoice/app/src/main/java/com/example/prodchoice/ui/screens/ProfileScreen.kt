package com.example.prodchoice.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            // Sección de Foto y Nombre
            item {
                ProfileHeader()
            }

            // Sección de Estudios
            item {
                InfoCard(
                    title = "Estudios",
                    icon = Icons.Default.Book,
                    content = "• Ingeniería en Sistemas - Universidad Nacional (2018 - 2022)\n" +
                              "• Especialización en Desarrollo Móvil - Tech Academy (2023)\n" +
                              "• Certificación en UI/UX Design - Online Learning (2021)\n" +
                              "• Diplomado en Gestión de Proyectos Ágiles (2022)"
                )
            }

            // Sección de Experiencia
            item {
                InfoCard(
                    title = "Experiencia",
                    icon = Icons.Default.Work,
                    content = "• Desarrollador Senior en Tech Solutions (2022 - Presente): Liderazgo de proyectos Android y optimización de rendimiento.\n" +
                              "• Desarrollador Jr en AppFactory (2020 - 2022): Creación de interfaces dinámicas y consumo de APIs REST.\n" +
                              "• Pasante de IT en SoftCorp (2019 - 2020): Soporte técnico y mantenimiento de bases de datos.\n" +
                              "• Freelance Developer (2018 - 2019): Desarrollo de aplicaciones personalizadas para pequeños negocios."
                )
            }

            // Sección de Otros (Habilidades / Sobre mí)
            item {
                InfoCard(
                    title = "Habilidades y Sobre mí",
                    icon = Icons.Default.Person,
                    content = "Soy un apasionado del desarrollo de software con enfoque en la experiencia de usuario. " +
                              "Dominio técnico en Kotlin, Jetpack Compose, y arquitecturas modernas como MVVM. " +
                              "Me encanta aprender nuevas tecnologías y colaborar en equipos multidisciplinarios para crear soluciones innovadoras."
                )
            }

            // Botón de Cerrar Sesión
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Lógica de cerrar sesión */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE57373),
                        contentColor = Color.White
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                        contentDescription = "Cerrar sesión"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Cerrar Sesión", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(130.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = null,
                contentDescription = "Foto de perfil",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(70.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Usuario ProdChoice",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Text(
            text = "Ingeniero de Software",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun InfoCard(title: String, icon: ImageVector, content: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 22.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
