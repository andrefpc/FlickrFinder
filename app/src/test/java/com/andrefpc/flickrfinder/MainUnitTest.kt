package com.andrefpc.flickrfinder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.andrefpc.flickrfinder.mocks.FlickerRepositoryMock
import com.andrefpc.flickrfinder.mocks.Mocks
import com.andrefpc.flickrfinder.ui.view.main.MainViewModel
import com.andrefpc.flickrfinder.util.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class MainUnitTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val flickrRepository = FlickerRepositoryMock()

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getFeeds should update feeds and loading state on success`() = runBlockingTest {
        flickrRepository.changeResponseToSuccess()
        val viewModel = MainViewModel(CoroutineContextProvider(), flickrRepository)
        // When
        viewModel.getFeeds("cats")

        // Then
        assertEquals(viewModel.loading.value, true)
        delay(1000)
        assertEquals(viewModel.loading.value, false)
        assertEquals(viewModel.feed.value, Mocks.flickrItems)
    }

    @Test
    fun `getFeeds should update loading state on error`() = runBlockingTest {
        flickrRepository.changeResponseToError()
        val viewModel = MainViewModel(CoroutineContextProvider(), flickrRepository)
        // When
        viewModel.getFeeds("cats")

        // Then
        assertEquals(viewModel.loading.value, true)
        delay(1000)
        assertEquals(viewModel.loading.value, false)
        assertEquals(viewModel.feed.value, null)
    }
}