package com.vullpes.dailypulse.android.screens.source

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vullpes.dailypulse.sources.Source
import org.koin.androidx.compose.getViewModel


@Composable
fun SourceScreen(
    onUpButtonClick:() -> Unit,
    sourcesViewModel: SourceViewModel = getViewModel()
){

    val sourcesState = sourcesViewModel.sources.collectAsState()

    Column{
        ToolbarSource(onUpButtonClick)
        SourceListView(sourcesState.value)
    }
}

@Composable
fun SourceListView(sources: List<Source>) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(sources) { source ->
                SourceItemView(source = source)
            }
        }
}

@Composable
fun SourceItemView(source: Source) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = source.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.description)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${source.country} - ${source.language}",
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarSource(
    onUpButtonClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Sources")
        },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Up button"
                )
            }
        }
    )
}