package com.example.prodchoice.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prodchoice.R
import com.example.prodchoice.ui.components.ProductCard

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val image: Any, // Cambiado a Any para aceptar R.drawable
    val price: String
)

@Composable
fun ProductScreen() {
    val dummyProducts = listOf(
        Product(
            1,
            "Reloj Inteligente Pro",
            "Reloj smart con monitoreo de salud, notificaciones y resistencia al agua.",
            R.drawable.reloj,
            "$199.00"
        ),
        Product(
            2,
            "Lámpara LED Moderna",
            "Lámpara LED regulable con diseño minimalista y bajo consumo energético.",
            R.drawable.lampara,
            "$59.00"
        ),
        Product(
            3,
            "Zapatos Deportivos",
            "Calzado cómodo y ligero, ideal para correr y actividades diarias.",
            R.drawable.zapatos,
            "$89.00"
        ),
        Product(
            4,
            "Auriculares Inalámbricos",
            "Audífonos con cancelación de ruido y sonido de alta fidelidad.",
            R.drawable.audifono,
            "$149.00"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dummyProducts) { product ->
            ProductCard(
                title = product.title,
                description = product.description,
                price = product.price,
                imageSource = product.image,
                onAddToCart = { /* Lógica para agregar */ },
                onRemoveFromCart = { /* Lógica para quitar */ }
            )
        }
    }
}
