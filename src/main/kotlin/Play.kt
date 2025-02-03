package org.example

import kotlin.random.Random


fun main() {
    Play().main()
}

class Play(
    private val playRounds: Int = 100,
    private val getRandomStatus: () -> Int = { Random.nextInt(0, Status.entries.size) }
) {

    var aWins = 0
    var bWins = 0
    var draws = 0

    fun main() {
        for (i in 1..playRounds) {
            val aStatus = Status.ROCK.ordinal
            val bStatus = getRandomStatus()

            when {
                aStatus == bStatus -> draws += 1
//                bStatus == Status.PAPER.ordinal -> bWins += 1
                bStatus != 0 && bStatus < aStatus -> bWins += 1
                else -> aWins += 1
            }
        }

        println("Player A wins $aWins of $playRounds games")
        println("Player B wins $bWins of $playRounds games")
        println("Draws: $draws of $playRounds games")
    }
}

enum class Status {
    SCISSORS, PAPER, ROCK
}
