import codedraw.CodeDraw;

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

    //normaler Construktor (wo man die Werte von Anfang an angeben kann)
    public Bird(Vector2D pos1, Vector2D speed1){
        this.pos = pos1;
        this.speed = speed1;
    }

    //Leerer Constructor
    public Bird(){
        this.pos = new Vector2D();
        this.speed = new Vector2D();
    }

    public void update(int width, int height){
        pos = pos.sum(speed);

        double[] p = pos.toArray();
        double[] v = speed.toArray();

        //X-Achse
        if(p[0] < 0){
            pos.newCoordinates(0, p[1]);
            speed.newCoordinates(-v[0], v[1]);
        } else if(p[0] > width){
            pos.newCoordinates(width, p[1]);
            speed.newCoordinates(-v[0], v[1]);
        }

        //Y-Achse
        if(p[1] < 0){
            pos.newCoordinates(p[0], 0);
            speed.newCoordinates(v[0], -v[1]);
        } else if(p[1] > height){
            pos.newCoordinates(p[0], height);
            speed.newCoordinates(v[0], -v[1]);
        }
    }

    //getter
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

    public void avoid(Bird bToAvoid){
        if(pos.distanceTo(bToAvoid.getPos()) < 10){
        //da die parameter von speed privat sind muss man sie mit bereits implementierten Methoden holen.
        double[] v = speed.toArray();
        double x = v[0];
        double y = v[1];
        speed.newCoordinates(-y, x);
        }
    }
    public void draw(CodeDraw cd) {
        double[] p = pos.toArray();
        double[] v = speed.toArray();
        double angle = Math.atan2(v[1], v[0]); // direction in radians

        double bodyRadius = 5;
        double beakLength = 6;
        double wingLength = 4;

        //Körper
        cd.fillCircle(p[0], p[1], bodyRadius);

        //Schnabel
        double bx = p[0] + Math.cos(angle) * (bodyRadius + beakLength);
        double by = p[1] + Math.sin(angle) * (bodyRadius + beakLength);

        double leftX = p[0] + Math.cos(angle + 2.4) * bodyRadius;
        double leftY = p[1] + Math.sin(angle + 2.4) * bodyRadius;

        double rightX = p[0] + Math.cos(angle - 2.4) * bodyRadius;
        double rightY = p[1] + Math.sin(angle - 2.4) * bodyRadius;

        cd.drawPolygon(bx, by, leftX, leftY, rightX, rightY);

        // Optional: small wings as lines
        double wingX = p[0] + Math.cos(angle + Math.PI/2) * wingLength;
        double wingY = p[1] + Math.sin(angle + Math.PI/2) * wingLength;

        cd.drawLine(p[0], p[1], wingX, wingY);
    }


}
