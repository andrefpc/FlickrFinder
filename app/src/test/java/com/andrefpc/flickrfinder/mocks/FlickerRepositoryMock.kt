package com.andrefpc.flickrfinder.mocks

import com.andrefpc.flickrfinder.data.FlickrResponse
import com.andrefpc.flickrfinder.repository.FlickrRepository
import com.andrefpc.flickrfinder.util.ApiResult

class FlickerRepositoryMock: FlickrRepository {
    var response: ApiResult<FlickrResponse> = ApiResult.Success(Mocks.flickrResponse)
    override suspend fun getFeeds(search: String): ApiResult<FlickrResponse> {
        return response
    }

    fun changeResponseToSuccess(){
        response = ApiResult.Success(Mocks.flickrResponse)
    }

    fun changeResponseToError(){
        response = ApiResult.Error("Error")
    }

}