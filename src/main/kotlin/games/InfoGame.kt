package games

import service.InfoApiShark

data class InfoGame(val info:InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}