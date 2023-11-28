import com.google.gson.Gson
import games.Game
import games.InfoGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


fun main(args: Array<String>) {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=612"))
        .build()
    val response = client.send(request, BodyHandlers.ofString())


    val json = response.body()
    val gson = Gson()
    val mygame = gson.fromJson(json, InfoGame::class.java)

    println(mygame)
}