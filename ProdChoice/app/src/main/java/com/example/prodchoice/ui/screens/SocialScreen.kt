package com.example.prodchoice.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class SocialNetwork(
    val name: String,
    val url: String,
    val icon: ImageVector,
    val description: String
)

@Composable
fun SocialScreen() {
    val uriHandler = LocalUriHandler.current
    
    // Lista de redes sociales con iconos estándar y URLs
    val socialNetworks = listOf(
        SocialNetwork(
            "Facebook",
            "https://www.facebook.com",
            Icons.Default.ThumbUp,
            "Síguenos para novedades y eventos."
        ),
        SocialNetwork(
            "Instagram",
            "https://www.instagram.com",
            Icons.Default.AccountCircle,
            "Mira nuestras mejores fotos de productos."
        ),
        SocialNetwork(
            "Twitter (X)",
            "https://www.twitter.com",
            Icons.Default.Info,
            "Entérate de las noticias al instante."
        ),
        SocialNetwork(
            "LinkedIn",
            "https://www.linkedin.com",
            Icons.Default.Build,
            "Conecta con nuestro equipo profesional."
        ),
        SocialNetwork(
            "WhatsApp",
            "https://wa.me/123456789",
            Icons.Default.Call,
            "Escríbenos directamente para soporte."
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Nuestras Redes",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(socialNetworks) { network ->
                SocialCard(network) {
                    uriHandler.openUri(network.url)
                }
            }
        }
    }
}

@Composable
fun SocialCard(network: SocialNetwork, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Contenedor del icono
            Surface(
                modifier = Modifier.size(48.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = network.icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Información de la red
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = network.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = network.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = network.url,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            
            // Icono de acción
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Ir a red social",
                tint = MaterialTheme.colorScheme.outline
            )
        }
    }
}
