package com.andrefpc.flickrfinder.data

import java.io.Serializable

data class FlickrResponse(
    val title: String,
    val link: String,
    val items: List<FlickrItem>
): Serializable
