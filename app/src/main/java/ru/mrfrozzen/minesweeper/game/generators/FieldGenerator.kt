package ru.mrfrozzen.minesweeper.game.generators

import ru.mrfrozzen.minesweeper.game.Field

interface FieldGenerator {

    fun generate(rows: Int, columns: Int, args: FieldGenerationArguments): Field

}

data class FieldGenerationArguments(
    val mines: Int
)