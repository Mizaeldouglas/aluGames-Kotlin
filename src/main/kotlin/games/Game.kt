package games

data class Game(val title: String,val cover: String) {

    override fun toString(): String {
        return "Jogos: \nTitulo: $title\nCapa: $cover\n"
    }

}