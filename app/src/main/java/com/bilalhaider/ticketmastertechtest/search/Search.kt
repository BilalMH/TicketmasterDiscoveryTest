package com.bilalhaider.ticketmastertechtest.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Search() {

    val searchEventsViewModel: SearchEventsViewModel = viewModel()
    val textState = remember { mutableStateOf(TextFieldValue) }
    val searchResults = searchEventsViewModel.events.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    ) {

/*        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                label = Text("Search for an Event"),
                modifier = Modifier.wrapContentHeight(),
                singleLine = true,
                value = textState.value,
                onValueChange = {
                    textState.value = it
                }
            )

            Button(
                modifier = Modifier
                    .height(48.dp)
                    .padding(start = 5.dp),
                onClick = {
                    searchEventsViewModel.searchForEvent(textState.value.text)
                    keyboardController?.hide()
                }
            ) {
                Text(text = "Search")
            }
        }

        LazyColumn {
            if (searchResults.value.isNotEmpty()) {
                item {
                    Text(
                        color = Color.White,
                        modifier = Modifier
                            .weight(1f)
                            .padding(all = 16.dp),
                        text = "${searchResults.value.size} results",
                        fontSize = 16.sp
                    )
                }

                items(items = searchResults.value) {
                    SearchResultItem(event = it)
                }
            }
        }*/
    }

}