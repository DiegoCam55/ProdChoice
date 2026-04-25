package com.example.prodchoice.ui.screens

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebScreen() {
    var urlInput by remember { mutableStateOf("https://www.nperf.com/es/") }
    var urlToLoad by remember { mutableStateOf("https://www.nperf.com/es/") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Caja de texto para la URL
        OutlinedTextField(
            value = urlInput,
            onValueChange = { urlInput = it },
            label = { Text("Ingresar URL") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { 
                    // Asegurarse de que la URL tenga el protocolo http/https
                    urlToLoad = if (!urlInput.startsWith("http://") && !urlInput.startsWith("https://")) {
                        "https://$urlInput"
                    } else {
                        urlInput
                    }
                }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Cargar")
                }
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Contenedor del WebView
        Card(
            modifier = Modifier.fillMaxSize(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            AndroidView(
                factory = { context ->
                    WebView(context).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        webViewClient = WebViewClient()
                        settings.javaScriptEnabled = true // Habilitar JS para sitios modernos
                    }
                },
                update = { webView ->
                    webView.loadUrl(urlToLoad)
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
