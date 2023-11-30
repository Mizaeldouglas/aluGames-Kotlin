import com.google.gson.Gson
import games.Game
import games.InfoGame
import java.lang.Exception
import java.lang.IllegalStateException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main(args: Array<String>) {

    val sc = Scanner(System.`in`)
    println("Digite um código de jogo para buscar: ")
    val search = sc.nextLine()
    val url = "https://www.cheapshark.com/api/1.0/games?id=${search}"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build()

    val response = client.send(request, BodyHandlers.ofString())

    // Verifica se a solicitação foi bem-sucedida (código de status 200)
    if (response.statusCode() == 200) {
        val json = response.body()
        val gson = Gson()

        val result = runCatching {
            val myInfoGame = gson.fromJson(json, InfoGame::class.java)
            val myGame = Game(myInfoGame.info.title, myInfoGame.info.thumb)
            println(myGame)
        }

        result.onFailure { e ->
            when (e) {
                is IllegalStateException -> {
                    println("O código $search não existe. Digite outro código de 1 até 169.")
                }
                else -> {
                    println("Erro desconhecido: ${e.message}")
                }
            }
        }




    } else {
        println("O código $search não existe. Digite outro código de 1 até 169.")
        println("Erro na solicitação à API. Código de status: ${response.statusCode()}")
    }

    println("Fim...")


}

//    try {
//        val myInfoGame = gson.fromJson(json, InfoGame::class.java)
//        val myGame = Game(myInfoGame.info.title, myInfoGame.info.thumb)
//        println(myGame)
//    } catch (e: Exception) {
//        println("O código ${search} não existe digite outro código de 1 até 169")
//
//    } finally {
//        println("Fim...")
//    }