package com.andrefpc.flickrfinder.util

import com.andrefpc.flickrfinder.util.CoroutineContextProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.StandardTestDispatcher
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class TestContextProvider : CoroutineContextProvider() {
    //val testCoroutineDispatcher = StandardTestDispatcher()

    //override val Main: CoroutineContext = testCoroutineDispatcher
   //override val IO: CoroutineContext = testCoroutineDispatcher
}
