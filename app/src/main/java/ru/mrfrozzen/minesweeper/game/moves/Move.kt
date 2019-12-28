package ru.mrfrozzen.minesweeper.game.moves

import ru.mrfrozzen.minesweeper.game.Board

interface Move {

    enum class Type {
        Reveal,
        Flag,
        RemoveFlag
    }

    fun execute(board: Board, changeSet: Board.ChangeSet)

}