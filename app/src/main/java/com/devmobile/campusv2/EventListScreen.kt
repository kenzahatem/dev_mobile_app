package com.devmobile.campusv2

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import android.content.res.Configuration

import androidx.compose.foundation.lazy.LazyRow
import com.devmobile.campusv2.ui.theme.MyApplicationTheme

private const val TAG = "Campus"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(events: List<Event>) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Campus") }
            )
        }
    ) { innerPadding ->


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // En-tête : catégories horizontales
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        listOf("Tous", "Sport", "Culture", "Informatique", "Musique")
                    ) { category ->
                        SuggestionChip(
                            onClick = {
                                Log.d(TAG, "Catégorie sélectionnée : $category")
                            },
                            label = { Text(category) }
                        )
                    }
                }
            }

            // Liste verticale des événements
            items(
                items = events,
                key = { event -> event.id }
            ) { event ->

                EventCard(
                    event = event,
                    onClick = {
                        Log.d(TAG, "Clic sur événement ${event.id}")
                    },
                    onBook = {
                        Log.d(TAG, "Réservation événement ${event.id}")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
@Preview(showBackground = true, name = "Catalogue clair")
@Composable
fun EventListLightPreview() {
    MyApplicationTheme {
        EventListScreen(events = events)
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Catalogue sombre"
)
@Composable
fun EventListDarkPreview() {
    MyApplicationTheme(darkTheme = true) {
        EventListScreen(events = events)
    }
}
