/**
 * The class {@code Vector2D} represents a two-dimensional mathematical vector.
 * This class replaces the former array-based representation of vectors.
 *
 * A vector consists of an x- and a y-coordinate and is used to model
 * positions and directions in a two-dimensional space.
 *
 * This class is intended to encapsulate both, data (coordinates)
 * and the operations that can be performed on vectors, such as
 * addition, distance computation and normalization.
 *
 * A {@code Vector2D} object provides all operations for vector manipulation
 * via instance methods (no direct manipulation of the coordinates from outside
 * the class).
 *
 * Objects of this class are mutable, i.e., they can change their
 * state (coordinates) upon a method call.
 */
public class Vector2D {

    private double x;
    private double y;

    //Constructor
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //inkl. leeren Constructor
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }
    //toString zum Anzeigen der Vektoren in folgender Form:
    @Override
    public String toString(){
        return "[" + this.x + "," + this.y + "]";
    }

    //set new Coordinates vor Vector
    public void newCoordinates(double inputX, double inputY){
        this.x = inputX;
        this.y = inputY;
    }

    //sum vectors
    public Vector2D sum(Vector2D v2){
        return new Vector2D(this.x + v2.x, this.y + v2.y);
    }

    //diff vectors
    public Vector2D diff(Vector2D v2){
        return new Vector2D(this.x - v2.x, this.y - v2.y);
    }

    //length
    //Formel = Wurzel(x²+y²)
    public double length(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    //Distanz zwischen zwei Vektoren
    //Formel = Wurzel((x.v2-x.v1)²+(y.v2-y.v1)²)
    public double distanceTo(Vector2D v2){
        double dx = this.x - v2.x;
        double dy = this.y - v2.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    //Skalierung durch einen Faktor
    public void scale(double factor){
        this.x = this.x * factor;
        this.y = this.y * factor;
    }

    //Normalize
    //Vektor hat die gleiche Richtung wie original Vektor
    //Länge 1
    public void normalize(){
        //DRY Prinzip, andere Methode verwenden um nicht wieder die Länge auszurechnen
        double length = length();
        //Notfalls um den kompletten Bereich abzudecken > 1e-12 (Toleranz für Gleitkomma)
        if(length != 0){
            this.x /= length;
            this.y /= length;
        }
    }

    public boolean isZero(){
        if(this.x == 0 && this.y == 0){
            return true;
        }else{
            return false;
        }
    }

    public double[] toArray(){
        return new double[] {this.x, this.y};
    }

}