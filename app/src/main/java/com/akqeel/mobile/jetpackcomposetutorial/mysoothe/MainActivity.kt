package com.akqeel.mobile.jetpackcomposetutorial.mysoothe

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akqeel.mobile.jetpackcomposetutorial.basics.ui.theme.JetpackComposeTutorialTheme
import com.akqeel.mobile.jetpackcomposetutorial.mysoothe.model.AlignYourBodyData
import com.akqeel.mobile.jetpackcomposetutorial.mysoothe.model.FavouritesCollectionData
import com.akqeel.mobile.jetpackcomposetutorial.mysoothe.ui.*

class MainActivity : ComponentActivity() {

}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(modifier = Modifier)
}

@Preview
@Composable
fun AlignYourBodyElementPreview() {
    AlignYourBodyElement(
        modifier = Modifier,
        text = com.akqeel.mobile.jetpackcomposetutorial.R.string.app_name,
        drawable = com.akqeel.mobile.jetpackcomposetutorial.R.drawable.ic_launcher_background,
    )
}

@Preview
@Composable
fun FavoriteCollectionCardPreview() {
    FavoriteCollectionCard(
        drawable = com.akqeel.mobile.jetpackcomposetutorial.R.drawable.ic_launcher_background,
        text = com.akqeel.mobile.jetpackcomposetutorial.R.string.app_name,
    )
}

@Preview
@Composable
fun AlignYourBodyRowPreview() {
    AlignYourBodyRow(alignYourBodyData = createAlignYourBodyDataList())
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    JetpackComposeTutorialTheme {
        HomeSection(com.akqeel.mobile.jetpackcomposetutorial.R.string.app_name) {
            AlignYourBodyRow(
                alignYourBodyData = createAlignYourBodyDataList()
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, heightDp = 500)
@Composable
fun HomeScreenPreview() {
    JetpackComposeTutorialTheme {
        HomeScreen(
            alignYourBodyData = createAlignYourBodyDataList(),
            favoriteCollectionsData = createFavouriteCollectionDataList(),
        )
    }
}

private fun createAlignYourBodyDataList() = listOf(
    AlignYourBodyData(
        text = com.akqeel.mobile.jetpackcomposetutorial.R.string.app_name,
        drawable = com.akqeel.mobile.jetpackcomposetutorial.R.drawable.ic_launcher_background,
    ), AlignYourBodyData(
        text = com.akqeel.mobile.jetpackcomposetutorial.R.string.app_name,
        drawable = com.akqeel.mobile.jetpackcomposetutorial.R.drawable.ic_launcher_background,
    ), AlignYourBodyData(
        text = com.akqeel.mobile.jetpackcomposetutorial.R.string.app_name,
        drawable = com.akqeel.mobile.jetpackcomposetutorial.R.drawable.ic_launcher_background,
    )
)

private fun createFavouriteCollectionDataList() = listOf(
    FavouritesCollectionData(
        text = com.akqeel.mobile.jetpackcomposetutorial.R.string.app_name,
        drawable = com.akqeel.mobile.jetpackcomposetutorial.R.drawable.ic_launcher_background,
    ),
    FavouritesCollectionData(
        text = com.akqeel.mobile.jetpackcomposetutorial.R.string.app_name,
        drawable = com.akqeel.mobile.jetpackcomposetutorial.R.drawable.ic_launcher_background,
    ),
)