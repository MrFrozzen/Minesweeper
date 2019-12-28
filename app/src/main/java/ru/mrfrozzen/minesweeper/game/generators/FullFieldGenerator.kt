package ru.mrfrozzen.minesweeper.game.generators

import ru.mrfrozzen.minesweeper.game.Field

class FullFieldGenerator : FieldGenerator {

    override fun generate(rows: Int, columns: Int, args: FieldGenerationArguments): Field {
        return Field(rows, columns).apply {
            for (i in 0 until rows)
                for (j in 0 until columns)
                    this[i, j] = true
        }
    }

}