package com.bilalhaider.ticketmastertechtest.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.EventModel
import com.bilalhaider.ticketmastertechtest.domain.data.remote.models.sampleEvent
import com.bilalhaider.ticketmastertechtest.extension.toReadableDate

@Composable
fun SearchResultItem(
    event: EventModel,
    onAddClickCallback: (event: EventModel) -> Unit
) {

    Surface(
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Image(
                    painter = rememberImagePainter(data = event.images.first().url),
                    contentDescription = "Image of ${event.name}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(
                            Brush.radialGradient(
                                colors = listOf(Color.Transparent, Color.Black),
                                radius = 350f
                            )
                        )
                )

                Text(
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(all = 20.dp),
                    text = event.name
                )
            }

            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            Button(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                onClick = {
                    onAddClickCallback(event)
                }
            ) {
                Text(
                    color = Color.White,
                    text = "Add to saved events"
                )
            }

            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            Text(
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp),
                text = event.dates.start.localDate.toReadableDate()
            )

            Text(
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp),
                text = event.venuesAndAttractions.venues.first().name
            )

            Text(
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp),
                text = event.venuesAndAttractions.venues.first().address.line1
            )

            Text(
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp),
                text = event.venuesAndAttractions.venues.first().city.name
            )
        }
    }


}


@Preview
@Composable
fun SearchResultItemPreview() {
    MaterialTheme {
        SearchResultItem(sampleEvent) {}
    }
}