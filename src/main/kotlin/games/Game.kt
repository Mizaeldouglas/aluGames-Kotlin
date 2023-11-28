package games

import com.google.gson.annotations.SerializedName

class Game(
    @SerializedName("title") val title: String,
    @SerializedName("thumb") val cover: String,
    val description: String
) {

    override fun toString(): String {
        return "Jogos: \nTitulo: $title\nCapa: $cover\nDescrição: $description\n"
    }

}