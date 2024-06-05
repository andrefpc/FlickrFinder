package com.andrefpc.flickrfinder.repository

import com.andrefpc.flickrfinder.api.FlickrApi
import com.andrefpc.flickrfinder.data.FlickrResponse
import com.andrefpc.flickrfinder.util.ApiResult
import com.andrefpc.flickrfinder.util.api.ApiUtil
import retrofit2.Response

class FlickrRepositoryImpl(
    private val flickrApi: FlickrApi,
    private val apiUtil: ApiUtil
) : FlickrRepository {
    override suspend fun getFeeds(search: String): ApiResult<FlickrResponse> {
        return try {
            val response: Response<FlickrResponse> = flickrApi.getFeeds(search = search)
            apiUtil.getResult(response)
        } catch (exception: Exception) {
            apiUtil.parseError(exception)
        }
    }
}