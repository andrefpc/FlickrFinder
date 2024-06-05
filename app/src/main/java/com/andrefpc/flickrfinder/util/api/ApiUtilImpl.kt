package com.andrefpc.flickrfinder.util.api

import com.andrefpc.flickrfinder.util.ApiResult
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException
import kotlin.math.exp

class ApiUtilImpl : ApiUtil {
    override fun <T> getResult(response: Response<T>): ApiResult<T> {
        if (!response.isSuccessful) {
            val errorBody = response.errorBody()?.string()
            return ApiResult.Error(errorBody)
        }

        response.body()?.let {
            return ApiResult.Success(it)
        }?: kotlin.run {
            return ApiResult.Error("Unable to get data from the api")
        }
    }

    override fun <T> parseError(exception: Exception): ApiResult<T> {
        return if (exception is IOException)
            ApiResult.Error("Occurred a problem with the connection, please try again!")
        else ApiResult.Error(exception.message)
    }
}