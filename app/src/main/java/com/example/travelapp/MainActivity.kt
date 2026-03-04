package com.example.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TravelPlannerApp()
            }
        }
    }
}

data class Destination(
    val city: String,
    val country: String,
    val bestSeason: String,
    val budget: String,
)

@Composable
fun TravelPlannerApp() {
    val destinations = listOf(
        Destination("Lizbona", "Portugalia", "Wiosna", "Średni"),
        Destination("Reykjavik", "Islandia", "Lato", "Wysoki"),
        Destination("Kioto", "Japonia", "Jesień", "Wysoki"),
        Destination("Tbilisi", "Gruzja", "Wiosna", "Niski")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Twoja aplikacja podróżnicza") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        DestinationList(destinations = destinations, contentPadding = innerPadding)
    }
}

@Composable
private fun DestinationList(destinations: List<Destination>, contentPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = contentPadding
    ) {
        item { Spacer(modifier = Modifier.height(10.dp)) }
        items(destinations) { destination ->
            DestinationCard(destination)
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
    }
}

@Composable
private fun DestinationCard(destination: Destination) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${destination.city}, ${destination.country}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            InfoRow(label = "Najlepszy sezon", value = destination.bestSeason)
            InfoRow(label = "Budżet", value = destination.budget)
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row {
        Text(text = "$label: ", fontWeight = FontWeight.SemiBold)
        Text(text = value)
    }
}


@Preview(showBackground = true)
@Composable
private fun TravelPlannerPreview() {
    MaterialTheme {
        TravelPlannerApp()
    }
}
