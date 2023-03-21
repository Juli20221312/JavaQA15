import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Game;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

public class GameTest {

    @Test
    public void testFirstStronger() {
        Game game = new Game();
        Player kolja = new Player(1, "Коля", 100);
        Player petja = new Player(2, "Петя", 120);

        game.register(kolja);
        game.register(petja);

        int expected = 1;
        int actual = game.round("Петя", "Коля");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSecondStronger() {
        Game game = new Game();
        Player kolja = new Player(1, "Коля", 100);
        Player petja = new Player(2, "Петя", 120);

        game.register(kolja);
        game.register(petja);

        int expected = 2;
        int actual = game.round("Коля", "Петя");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testBothStronger() {
        Game game = new Game();
        Player kolja = new Player(1, "Коля", 120);
        Player petja = new Player(2, "Петя", 120);

        game.register(kolja);
        game.register(petja);

        int expected = 0;
        int actual = game.round("Петя", "Коля");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSecondNotExists() {
        Game game = new Game();
        Player kolja = new Player(1, "Коля", 120);
        Player petja = new Player(2, "Петя", 120);

        game.register(kolja);
        game.register(petja);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Саша")
        );
    }

    @Test
    public void testFirstNotExists() {
        Game game = new Game();
        Player kolja = new Player(1, "Коля", 120);
        Player petja = new Player(2, "Петя", 120);

        game.register(kolja);
        game.register(petja);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Саша", "Петя")
        );
    }


    @Test
    public void testBothNotExists() {
        Game game = new Game();
        Player kolja = new Player(1, "Коля", 120);
        Player petja = new Player(2, "Петя", 120);

        game.register(kolja);
        game.register(petja);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "Саша")
        );
    }


}
