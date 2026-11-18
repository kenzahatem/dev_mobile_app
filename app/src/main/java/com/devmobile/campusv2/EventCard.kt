package com.devmobile.campusv2
import androidx.compose.ui.res.pluralStringResource

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
//preview
import androidx.compose.ui.tooling.preview.Preview
@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit,
    onBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = event.title,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = event.category,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = event.location ?: stringResource(R.string.location_unknown)
            )

            Text(
                pluralStringResource(
                    R.plurals.available_places,
                    event.capacity,
                    event.capacity
                )
            )

            Button(
                onClick = onBook,
                enabled = event.capacity > 0,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.book))
            }
        }
    }



}
@Preview(showBackground = true)
@Composable
fun EventCardPreview() {
    EventCard(
        event = Event(
            id = 2,
            title = "Tournoi de football",
            category = "Sport",
            location = "Stade universitaire",
            capacity = 0 ,
            description = "descrpion"
        ),
        onClick = {},
        onBook = {}
    )
}

