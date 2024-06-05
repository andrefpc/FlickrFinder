package com.andrefpc.flickrfinder.ui.view.main

import android.view.View
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import com.andrefpc.flickrfinder.data.FlickrItem
import com.andrefpc.flickrfinder.data.FlickrMedia
import com.andrefpc.flickrfinder.ui.theme.RobotoBold
import com.andrefpc.flickrfinder.ui.theme.RobotoRegular
import com.andrefpc.flickrfinder.ui.theme.Typography
import com.andrefpc.flickrfinder.ui.widget.CustomImage

@Composable
fun MainItemView(
    flickrItem: FlickrItem,
    view: View = LocalView.current,
    onClick: (FlickrItem) -> Unit
) {
    Row {
        Column(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .clickable(onClick = {
                    onClick.invoke(flickrItem)
                })
        ) {
            CustomImage(
                url = flickrItem.media.url,
                description = flickrItem.description,
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(16.dp)).graphicsLayer {
                    ViewCompat.setTransitionName(view, "imageTransition")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuestItemPreview() {
    MainItemView(
        flickrItem = FlickrItem(
            title = "",
            link = "",
            media = FlickrMedia(url = ""),
            description = "",
            author = "",
            published = "",
            tags = "",
        ),
        onClick = {}
    )
}