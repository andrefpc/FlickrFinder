package com.andrefpc.flickrfinder.util.api

import com.andrefpc.flickrfinder.util.ApiResult
import retrofit2.Response

interface ApiUtil {
    fun <T> getResult(response: Response<T>): ApiResult<T>
    fun <T> parseError(exception: Exception): ApiResult<T>
}