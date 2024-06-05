package com.andrefpc.flickrfinder.util

sealed class ApiResult<out T> {
    class Error(val error: String?) : ApiResult<Nothing>()
    class Success<T>(val result: T?) : ApiResult<T>()
}