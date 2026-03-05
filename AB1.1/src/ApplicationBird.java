/**
 * A simulation of flying birds.
 *
 * TODO: change this class according to 'angabe.md'.
 */
import java.util.Arrays;

public class ApplicationBird {

    /**
     * The method {@code ApplicationBird} serves as an entry point for the simulation of flying birds.
     *
     * It demonstrates basic usage of the class {@link Bird}.
     */
    static void main() {

        Vector2D startPos = new Vector2D(100,200);
        Vector2D speed = new Vector2D(2,-1);
        Bird bird = new Bird(startPos, speed);

        System.out.println("Startposition: " + bird.getPos()); // [100, 200]
        bird.update();
        System.out.println("Neue Position: " + bird.getPos()); // [102, 199]
        bird.update();
        System.out.println("Neue Position: " + bird.getPos()); // [104, 198]


    }
}
