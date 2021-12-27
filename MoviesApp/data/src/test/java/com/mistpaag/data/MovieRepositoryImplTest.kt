package com.mistpaag.data

import com.mistpaag.data.source.ConnectivityChecker
import com.mistpaag.data.source.MovieLocalSource
import com.mistpaag.data.source.MovieRemoteSource
import com.mistpaag.domain.Movie
import com.mistpaag.sharedtesting.CoroutineTestRule
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieRepositoryImplTest{
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()


    private lateinit var repository: MovieRepository

    @RelaxedMockK
    lateinit var remoteSource: MovieRemoteSource

    @RelaxedMockK
    lateinit var localSource: MovieLocalSource

    @RelaxedMockK
    lateinit var connectivityChecker: ConnectivityChecker

    @Before
    fun setup(){
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        repository = MovieRepositoryImpl(remoteSource,localSource, connectivityChecker)
    }

    @Test
    fun `GIVEN internetAvailable WHEN invokeGetPopularMovies THEN returnSuccessList`() = runBlockingTest{
        coEvery { remoteSource.getPopularMovies(1) } returns fakeFlowPopularMovies
        coEvery { localSource.getPopularMovies(1) } returns fakeFlowPopularMovies
        every { connectivityChecker.isInternetAvailable() } returns true
        val fakeCurrentPage = 1

        val result = repository.getPopularMovies(page = fakeCurrentPage)

        result.collect { popularMoviesData->
            coVerify(exactly = 1) {
                remoteSource.getPopularMovies(any())
                localSource.getPopularMovies(any())
                connectivityChecker.isInternetAvailable()
            }
            assert(popularMoviesData.isSuccess())
            Assert.assertEquals(popularMoviesData.getSuccess()?.first(), fakePopularMovies.first())
        }
    }

    @Test
    fun `GIVEN internetUnavailableANDpage1RemoteReturnsErrorDataAndLocalReturnSuccess WHEN invokeUseCase THEN returnSuccessData`() = runBlockingTest{
        coEvery { remoteSource.getPopularMovies(1) } returns fakeFlowPopularMoviesError
        coEvery { localSource.getPopularMovies(1) } returns fakeFlowPopularMovies
        every { connectivityChecker.isInternetAvailable() } returns false
        val fakeCurrentPage = 1

        val result = repository.getPopularMovies(page = fakeCurrentPage)


        result.collect { popularMoviesData->
            coVerify(exactly = 0) { remoteSource.getPopularMovies(any()) }
            coVerify(exactly = 1) {
                localSource.getPopularMovies(any())
                connectivityChecker.isInternetAvailable()
            }
            assert(popularMoviesData.isSuccess())
            Assert.assertEquals(popularMoviesData.getSuccess()?.first(), fakePopularMovies.first())
        }
    }

    @Test
    fun `GIVEN internetAvailableANDpage1RemoteReturnsErrorDataAndLocalReturnSuccess WHEN invokeUseCase THEN returnSuccessData`() = runBlockingTest{
        coEvery { remoteSource.getPopularMovies(1) } returns fakeFlowPopularMoviesError
        coEvery { localSource.getPopularMovies(1) } returns fakeFlowPopularMovies
        every { connectivityChecker.isInternetAvailable() } returns true
        val fakeCurrentPage = 1

        val result = repository.getPopularMovies(page = fakeCurrentPage)

        result.collect { popularMoviesData->
            coVerify(exactly = 1) {
                remoteSource.getPopularMovies(any())
                localSource.getPopularMovies(any())
                connectivityChecker.isInternetAvailable()
            }
            assert(popularMoviesData.isSuccess())
            Assert.assertEquals(popularMoviesData.getSuccess()?.first(), fakePopularMovies.first())
        }
    }


}
private val fakePopularMovie : Movie = mockk()
private val fakePopularMovies : List<Movie> = listOf(fakePopularMovie)
private val fakeFlowPopularMovies = flowOf(ResultData.Success(fakePopularMovies))

private val fakePopularMovieError : String = "error"
private val fakeFlowPopularMoviesError = flowOf(ResultData.Error(fakePopularMovieError))