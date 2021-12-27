package com.mistpaag.moviesapp.presentation.popular

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mistpaag.data.ResultData
import com.mistpaag.domain.Movie
import com.mistpaag.sharedtesting.CoroutineTestRule
import com.mistpaag.usecases.GetPopularMoviesUseCase
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PopularMoviesViewModelTest{
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: PopularMoviesViewModel

    @RelaxedMockK
    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    @RelaxedMockK
    lateinit var observable: Observer<PopularMovieState>

    var slot = slot<PopularMovieState>()
    var stateList = mutableListOf<PopularMovieState>()

    @Before
    fun setup(){
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        viewModel = PopularMoviesViewModel(
            getPopularMoviesUseCase
        ).apply { state.observeForever(observable) }
        every { observable.onChanged(capture(slot)) } answers {stateList.add(slot.captured) }
    }

    @Test
    fun `GIVEN getPopularMoviesIntent WHEN executeIntent THEN stateIsPopularList`() = runBlockingTest{
        coEvery { getPopularMoviesUseCase.invoke(1) } returns  fakeMovieFlow

        viewModel.execute(PopularMovieIntent.GetPopularMovies)

        verify(exactly = 1) { getPopularMoviesUseCase.invoke(any()) }
        assertEquals(2, stateList.size)
        assertTrue(stateList[0] is PopularMovieState.Loading)
        assertTrue(stateList[1] is PopularMovieState.PopularList)
    }

    @Test
    fun `GIVEN getPopularMoviesIntent WHEN executeIntent THEN stateIsError`() = runBlockingTest{
        coEvery { getPopularMoviesUseCase.invoke(1) } returns  fakeMovieFlowError

        viewModel.execute(PopularMovieIntent.GetPopularMovies)

        verify(exactly = 1) { getPopularMoviesUseCase.invoke(any()) }
        assertEquals(2, stateList.size)
        assertTrue(stateList[0] is PopularMovieState.Loading)
        assertTrue(stateList[1] is PopularMovieState.Error)
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
private val fakeMovieFlow = flowOf(ResultData.Success(listOf(fakeMovie)))

private val error = "error"
private val fakeMovieFlowError = flowOf(ResultData.Error(error))