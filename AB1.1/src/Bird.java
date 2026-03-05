/**
 * The class {@code Bird} models a simple moving object in a two-dimensional space.
 *
 * A bird has a position and a velocity vector. The position determines the
 * current location of the bird, while the velocity describes direction and
 * speed of movement.
 *
 * Birds can update their position over time and may adjust their velocity vector
 * in order to avoid other objects and maintain a minimum distance.
 */
public class Bird {

    private Vector2D pos;
    private Vector2D speed;

    public Bird(Vector2D pos1, Vector2D speed1){
        this.pos = pos1;
        this.speed = speed1;
    }

    public void update(){
        pos = pos.sum(speed);
    }

    //getter / setter
    public Vector2D getPos(){
        return pos;
    }
    public Vector2D getSpeed(){
        return speed;
    }

    //Richtungswechsel
    public void changeDirection(Vector2D newDirection){
        //ein Geschwindigkeitsvektor besteht aus Richtung und Geschwindigkeit
        newDirection.normalize(); //somit enhält der Vektor nur mehr die Richtung und die Geschwindigkeit ist 1
        newDirection.scale(speed.length()); //um die gleiche Geschwindigkeit trotz normalize beizubehalten
        speed = newDirection;
    }

    public void avoid(){
        //da die parameter von speed privat sind muss man sie mit bereits implementierten Methoden holen.
        double[] v = speed.toArray();
        double x = v[0];
        double y = v[1];

        speed.newCoordinates(-y, x);
    }


}
