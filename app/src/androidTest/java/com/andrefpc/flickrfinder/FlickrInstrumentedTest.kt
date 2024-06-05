package com.andrefpc.flickrfinder

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withTagValue
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.andrefpc.flickrfinder.ui.view.main.MainActivity
import com.andrefpc.flickrfinder.util.FlickrRepositoryMock
import com.andrefpc.flickrfinder.util.Modules
import com.andrefpc.flickrfinder.util.TestContextProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class FlickrInstrumentedTest {
    private val testDispatcher = TestContextProvider()
    private val flickrRepositoryMock = FlickrRepositoryMock()

    private val modules = Modules(
        dispatcher = testDispatcher,
        flickrRepository = flickrRepositoryMock
    )

    @Before
    fun setUpKoinModules() {
        loadKoinModules(modules.getList())
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.andrefpc.flickrfinder", appContext.packageName)
    }

    @Test
    fun verifyResponses() {
        flickrRepositoryMock.changeResponseToSuccess()
        launchActivity<MainActivity>()
        searchInput.perform(typeText("cat"))
    }

    // View Interactions
    private val searchInput = onView(withTagValue(`is`("search_input")))

}