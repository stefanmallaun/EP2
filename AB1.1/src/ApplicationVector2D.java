/**
 * The class {@code ApplicationVector2D} serves as an entry point for testing {@link Vector2D}.
 *
 * It demonstrates basic vector operations using an array-based
 * representation of two-dimensional vectors.
 *
 * TODO: change this class according to 'angabe.md'.
 */
import java.util.Arrays;

public class ApplicationVector2D {

    /**
     * Runs a small demonstration of basic vector operations.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        double[] v1 = new double[] {3, 4};   // length = 5
        double[] v2 = new double[2];
        newCoordinates(v2, 1, -2);

        System.out.println("v1 = " + Arrays.toString(v1));
        System.out.println("v2 = " + Arrays.toString(v2));
        System.out.println();

        double[] sum = add(v1, v2);
        System.out.println("v1 + v2 = " + Arrays.toString(sum));

        double[] diff = subtract(v1, v2);
        System.out.println("v1 - v2 = " + Arrays.toString(diff));

        System.out.println("length(v1) = " + length(v1));

        double d = distance(v1, v2);
        System.out.println("distance(v1, v2) = " + d);

        scale(v1, 2.0);
        System.out.println("scaled v1 (factor 2) = " + Arrays.toString(v1));

        double[] copy = toArray(v1);
        normalize(v1);
        System.out.println("v1 normalized = " + Arrays.toString(v1));
        System.out.println("v1 before normalize = " + Arrays.toString(copy));
        System.out.println("length(v1) after normalize = " + length(v1));

        double[] zero = new double[] {0, 0};
        System.out.println("isZero(zero) = " + isZero(zero));
    }

    /**
     * Computes the Euclidean length of a two-dimensional vector.
     *
     * @param v vector coordinates, v != null && v.length == 2
     * @return the Euclidean length of {@code v}
     */
    public static double length(double[] v) {
        return Math.sqrt(v[0] * v[0] + v[1] * v[1]);
    }

    /**
     * Assigns the given coordinates to a two-dimensional vector.
     *
     * @param v vector to be modified, v != null && v.length == 2
     * @param x x-coordinate to assign
     * @param y y-coordinate to assign
     */
    public static void newCoordinates(double[] v, double x, double y) {
        v[0] = x;
        v[1] = y;
    }

    /**
     * Returns the sum of two two-dimensional vectors.
     *
     * @param v1 first vector, v1 != null && v1.length == 2
     * @param v2 second vector, v2 != null && v2.length == 2
     * @return new vector representing {@code v1 + v2}
     */
    public static double[] add(double[] v1, double[] v2) {
        return new double[] {
                v1[0] + v2[0],
                v1[1] + v2[1]
        };
    }

    /**
     * Subtracts one two-dimensional vector from another and returns the result.
     *
     * @param v1 first vector, v1 != null && v1.length == 2
     * @param v2 second vector, v2 != null && v2.length == 2
     * @return new vector representing {@code v1 - v2}
     */
    public static double[] subtract(double[] v1, double[] v2) {
        return new double[] {
                v1[0] - v2[0],
                v1[1] - v2[1]
        };
    }

    /**
     * Scales a two-dimensional vector by a constant factor.
     *
     * @param v vector, v != null && v.length == 2
     * @param factor scaling factor
     * @return new vector representing {@code factor * v}
     */
    public static void scale(double[] v, double factor) {
        v[0] *= factor;
        v[1] *= factor;
    }

    /**
     * Normalizes a two-dimensional vector in place.
     *
     * @param v vector to be modified,
     *          v != null && v.length == 2 && !isZero(v)
     */
    public static void normalize(double[] v) {
        double len = length(v);
        v[0] /= len;
        v[1] /= len;
    }

    /**
     * Computes the Euclidean distance between two vectors (interpreted as points).
     *
     * @param v1 first point, v1 != null && v1.length == 2
     * @param v2 second point, v2 != null && v2.length == 2
     * @return the Euclidean distance between {@code v1} and {@code v2}
     */
    public static double distance(double[] v1, double[] v2) {
        return length(subtract(v1, v2));
    }

    /**
     * Checks whether a vector is (approximately) the zero vector.
     *
     * @param v vector, v != null && v.length == 2
     * @return {@code true} if {@code length(v) < 1e-12}
     */
    public static boolean isZero(double[] v) {
        return length(v) < 1e-12;
    }

    /**
     * Creates a copy of a vector.
     *
     * @param v vector, v != null && v.length == 2
     * @return new array containing the same coordinates as {@code v}
     */
    public static double[] toArray(double[] v) {
        return new double[]{v[0], v[1]};
    }
}