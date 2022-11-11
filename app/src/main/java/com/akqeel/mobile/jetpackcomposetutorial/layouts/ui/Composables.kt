package com.akqeel.mobile.jetpackcomposetutorial.layouts.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.akqeel.mobile.jetpackcomposetutorial.layouts.model.AlignYourBodyData
import com.akqeel.mobile.jetpackcomposetutorial.layouts.model.FavouritesCollectionData
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier,
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(),
        placeholder = {
            Text("Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
    alignYourBodyData: List<AlignYourBodyData>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData.size) { item ->
            val data = alignYourBodyData[item]
            AlignYourBodyElement(data.drawable, data.text)
        }
    }
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
    favoriteCollectionsData: List<FavouritesCollectionData>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {
        items(favoriteCollectionsData.size) { item ->
            val data = favoriteCollectionsData[item]
            FavoriteCollectionCard(
                drawable = data.drawable,
                text = data.text,
                modifier = Modifier.height(56.dp)
            )
        }
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = text),
            )
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    alignYourBodyData: List<AlignYourBodyData>,
    favoriteCollectionsData: List<FavouritesCollectionData>,
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = com.akqeel.mobile.jetpackcomposetutorial.R.string.align_your_body) {
            AlignYourBodyRow(alignYourBodyData = alignYourBodyData)
        }
        HomeSection(title = com.akqeel.mobile.jetpackcomposetutorial.R.string.favourite_collections) {
            FavoriteCollectionsGrid(favoriteCollectionsData = favoriteCollectionsData)
        }
    }
}
