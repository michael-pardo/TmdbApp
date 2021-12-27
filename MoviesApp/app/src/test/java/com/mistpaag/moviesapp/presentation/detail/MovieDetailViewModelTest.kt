package com.mistpaag.moviesapp.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mistpaag.domain.Movie
import com.mistpaag.sharedtesting.CoroutineTestRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.slot
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieDetailViewModelTest{
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: MovieDetailViewModel

    @RelaxedMockK
    lateinit var observable: Observer<MovieDetailState>

    var slot = slot<MovieDetailState>()
    var stateList = mutableListOf<MovieDetailState>()

    @Before
    fun setup(){
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        viewModel = MovieDetailViewModel(

        ).apply { state.observeForever(observable) }
        every { observable.onChanged(capture(slot)) } answers {stateList.add(slot.captured) }
    }

    @Test
    fun `GIVEN seeMovieInfoInten WHEN executeIntent THEN stateIsPopularList`() = runBlockingTest{
        viewModel.execute(MovieDetailIntent.SeeMovieInfo(fakeMovie))

        assertEquals(1, stateList.size)
        assertTrue(stateList[0] is MovieDetailState.MovieInfo)
    }
}

private val fakeMovie = Movie(
    adult= false,
    backdropPath= "/msU3F9DVNFvCsQVxhxliyWSO03D.jpg",
    id= 10196,
    originalLanguage= "en",
    genreIds = emptyList(),
    originalTitle= "The Last Airbender",
    overview= "The story follows the adventures of Aang, a young successor to a long line of Avatars, who must put his childhood ways aside and stop the Fire Nation from enslaving the Water, Earth and Air nations.",
    popularity= 128.908,
    posterPath= "/zgwRTYWEEPivTwjB9S03HtmMcbM.jpg",
    releaseDate= "2010-06-30",
    title= "The Last Airbender",
    video= false,
    voteAverage= 4.7,
    voteCount= 3128,
)
