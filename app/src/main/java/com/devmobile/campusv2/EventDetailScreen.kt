package com.devmobile.campusv2


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import com.devmobile.campusv2.ui.theme.MyApplicationTheme

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import android.content.res.Configuration

@Composable
fun EventDetailScreen(
    event: Event,
    onBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.event_image),
            contentDescription = "Image de l'événement",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Text(
            text = event.title,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = event.category,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = event.location ?: stringResource(R.string.location_unknown)
        )

        HorizontalDivider()

        Text(
            text = event.description,
            style = MaterialTheme.typography.bodyLarge
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

@Preview(showBackground = true, name = "Détail clair")
@Composable
fun EventDetailLightPreview() {
    MyApplicationTheme {
        EventDetailScreen(
            event = events[0],
            onBook = {}
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Détail sombre"
)
@Composable
fun EventDetailDarkPreview() {
    MyApplicationTheme(darkTheme = true) {
        EventDetailScreen(
            event = events[0],
            onBook = {}
        )
    }
}

