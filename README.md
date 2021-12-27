
# Popular Movies
A simple Android app for The [Movie DB](https://www.themoviedb.org/) API 

## Development setup

You require the latest Android Studio Artict Fox to be able to build the app.

### Libraries

- Application entirely written in [Kotlin](https://kotlinlang.org)
- Asynchronous processing using [Coroutines](https://kotlin.github.io/kotlinx.coroutines/)
- Uses [Hilt](https://dagger.dev/hilt/) for dependency injection
- [Room](https://developer.android.com/jetpack/androidx/releases/room) for persistence
- [Retrofit](https://square.github.io/retrofit/) for api request
- [Navigation](https://developer.android.com/guide/navigation) for fragment navigation
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for ui

### API keys

You need to supply your API / client keys for the service the app uses.

- [TMDb](https://developers.themoviedb.org)

Once you obtain the key, you can set them in your `~/local.properties`:

```
# Get this from TMDb
tmdb.key=<your_api_key>
```
