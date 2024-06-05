package com.andrefpc.flickrfinder.repository

import com.andrefpc.flickrfinder.data.FlickrResponse
import com.andrefpc.flickrfinder.util.ApiResult

interface FlickrRepository {
    suspend fun getFeeds(search: String): ApiResult<FlickrResponse>
}