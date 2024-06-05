package com.andrefpc.flickrfinder.ui.view.details

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andrefpc.flickrfinder.R
import com.andrefpc.flickrfinder.data.FlickrItem
import com.andrefpc.flickrfinder.data.FlickrMedia
import com.andrefpc.flickrfinder.extensions.StringExtensions.extractImageSize
import com.andrefpc.flickrfinder.extensions.StringExtensions.formatDate
import com.andrefpc.flickrfinder.extensions.StringExtensions.removeHtmlTags
import com.andrefpc.flickrfinder.ui.theme.Typography
import com.andrefpc.flickrfinder.ui.widget.CustomImage
import com.andrefpc.flickrfinder.ui.widget.CustomToolbar

@Composable
fun DetailsView(
    flickrItem: FlickrItem,
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxHeight()
    ) {
        CustomToolbar(
            title = stringResource(R.string.image_details),
            leftIcon = R.drawable.ic_back,
            leftIconClick = onBackClick,
            rightIcon = R.drawable.ic_share,
            rightIconClick = onShareClick
        )
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            CustomImage(
                url = flickrItem.media.url,
                description = flickrItem.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = flickrItem.title,
                style = Typography.titleMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Author:",
                style = Typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = flickrItem.author,
                style = Typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Image Size:",
                style = Typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = flickrItem.description.extractImageSize(),
                style = Typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Published Date:",
                style = Typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = flickrItem.published.formatDate(),
                style = Typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Decription:",
                style = Typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = flickrItem.description.removeHtmlTags(),
                style = Typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview() {
    DetailsView(
        flickrItem = FlickrItem(
            title = "",
            link = "",
            media = FlickrMedia(url = ""),
            description = "",
            author = "",
            published = "",
            tags = "",
        )
    )
}