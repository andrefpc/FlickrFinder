package com.andrefpc.flickrfinder.util

import com.andrefpc.flickrfinder.data.FlickrItem
import com.andrefpc.flickrfinder.data.FlickrMedia
import com.andrefpc.flickrfinder.data.FlickrResponse

object Mocks {
    val flickrItems = listOf(
        FlickrItem(
            title = "test 1",
            link = "",
            media = FlickrMedia(url = "https://link1.com"),
            description = "Description 1",
            author = "Author 1",
            published = "2024-06-01T15:32:23Z",
            tags = "",
        ),
        FlickrItem(
            title = "test 2",
            link = "",
            media = FlickrMedia(url = "https://link2.com"),
            description = "Description 2",
            author = "Author 2",
            published = "2024-06-02T15:32:23Z",
            tags = "",
        )
    )
    val flickrResponse = FlickrResponse(title = "", link = "", items = flickrItems)
}