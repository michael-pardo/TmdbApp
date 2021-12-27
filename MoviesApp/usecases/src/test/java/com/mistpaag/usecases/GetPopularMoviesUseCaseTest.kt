package com.mistpaag.usecases

import com.mistpaag.data.*
import com.mistpaag.domain.Movie
import com.mistpaag.sharedtesting.CoroutineTestRule
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test

@ExperimentalCoroutinesApi
class GetPopularMoviesUseCaseTest {

    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    @RelaxedMockK
    lateinit var repository: MovieRepository

    @Before
    fun setup(){
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        getPopularMoviesUseCase = GetPopularMoviesUseCase(repository)
    }

    @Test
    fun `GIVEN page1ReturnsSuccessData WHEN invokeUseCase THEN returnSuccessList`() = runBlockingTest{
        coEvery { repository.getPopularMovies(1) } returns fakeFlowPopularMovies
        val fakeCurrentPage = 1

        val result = getPopularMoviesUseCase.invoke(page = fakeCurrentPage)


        result.collect { popularMoviesData->
            coVerify(exactly = 1) { repository.getPopularMovies(any()) }
            assert(popularMoviesData.isSuccess())
            assertEquals(popularMoviesData.getSuccess()?.first(), fakePopularMovies.first())
        }
    }

    @Test
    fun `GIVEN page1ReturnsErrorData WHEN invokeUseCase THEN returnMessageError`() = runBlockingTest{
        coEvery { repository.getPopularMovies(1) } returns fakeFlowPopularMoviesError
        val fakeCurrentPage = 1

        val result = getPopularMoviesUseCase.invoke(page = fakeCurrentPage)

        result.collect { popularMoviesData->
            coVerify(exactly = 1) { repository.getPopularMovies(any()) }
            assert(popularMoviesData.isError())
            assertEquals(popularMoviesData.getError(), fakePopularMovieError)
        }
    }
}


private val fakePopularMovie : Movie = mockk()
private val fakePopularMovies : List<Movie> = listOf(fakePopularMovie)
private val fakeFlowPopularMovies = flowOf(ResultData.Success(fakePopularMovies))

private val fakePopularMovieError : String = "error"
private val fakeFlowPopularMoviesError = flowOf(ResultData.Error(fakePopularMovieError))