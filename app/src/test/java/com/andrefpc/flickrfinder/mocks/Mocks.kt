package com.andrefpc.flickrfinder.mocks

import com.andrefpc.flickrfinder.data.FlickrItem
import com.andrefpc.flickrfinder.data.FlickrMedia
import com.andrefpc.flickrfinder.data.FlickrResponse

object Mocks {
    val flickrItems = listOf(
        FlickrItem(
        title = "",
        link = "",
        media = FlickrMedia(url = ""),
        description = "",
        author = "",
        published = "",
        tags = "",
    )
    )
    val flickrResponse = FlickrResponse(title = "", link = "", items = flickrItems)
}