import org.assertj.core.api.Assertions
import org.example.Play
import org.example.Status
import org.junit.jupiter.api.Test


class PlayKtTest {


    @Test
    fun `when player B and A is ROCK then draws`() {
        val play = Play(1) { Status.ROCK.ordinal };
        play.main()
        Assertions.assertThat(play.draws).isEqualTo(1)
        Assertions.assertThat(play.aWins).isEqualTo(0)
        Assertions.assertThat(play.bWins).isEqualTo(0)
    }

    @Test
    fun `when player B is PAPER and A is ROCK then B wins`() {
        val play = Play(1) { Status.PAPER.ordinal }
        play.main()
        Assertions.assertThat(play.draws).isEqualTo(0)
        Assertions.assertThat(play.aWins).isEqualTo(0)
        Assertions.assertThat(play.bWins).isEqualTo(1)
    }

    @Test
    fun `when player B is SCISSORS and A is ROCK then A wins`() {
        val play = Play(1) { Status.SCISSORS.ordinal }
        play.main()
        Assertions.assertThat(play.draws).isEqualTo(0)
        Assertions.assertThat(play.aWins).isEqualTo(1)
        Assertions.assertThat(play.bWins).isEqualTo(0)
    }

}