package games

data class Game(val title: String,val cover: String) {

    override fun toString(): String {
        return "Meus Jogos: \n- Titulo: $title\n- Capa: $cover\n"
    }

}