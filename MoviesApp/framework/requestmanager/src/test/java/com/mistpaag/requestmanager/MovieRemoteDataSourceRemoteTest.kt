package com.mistpaag.requestmanager

import com.mistpaag.data.getSuccess
import com.mistpaag.data.isSuccess
import com.mistpaag.domain.Movie
import com.mistpaag.requestmanager.base.BaseRemoteTest
import com.mistpaag.sharedtesting.CoroutineTestRule
import io.mockk.MockKAnnotations
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class MovieRemoteDataSourceRemoteTest: BaseRemoteTest() {
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()


    private lateinit var remote: MovieRemoteDataSource

    @Before
    override fun setup(){
        super.setup()
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        remote = MovieRemoteDataSource(movieService = movieService)
    }

    @Test
    fun `get location list from search location endpoint`() = runBlocking{

        val response = remote.getPopularMovies(1)

        response.collect { remoteData->
            assert(remoteData.isSuccess())
            assertEquals(remoteData.getSuccess()?.first()?.id, fakePopularMovie.id)
        }
    }
}

val fakePopularMovie = Movie(
    adult= false,
    backdropPath= "/msU3F9DVNFvCsQVxhxliyWSO03D.jpg",
    genreIds= emptyList(),
    id= 10196,
    originalLanguage= "en",
    originalTitle= "The Last Airbender",
    overview= "The story follows the adventures of Aang, a young successor to a long line of Avatars, who must put his childhood ways aside and stop the Fire Nation from enslaving the Water, Earth and Air nations.",
    popularity= 128.908,
    posterPath= "/zgwRTYWEEPivTwjB9S03HtmMcbM.jpg",
    releaseDate= "2010-06-30",
    title= "The Last Airbender",
    video= false,
    voteAverage= 4.7,
    voteCount= 3128
)