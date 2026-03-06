/**
 * A simulation of flying birds.
 *
 * TODO: change this class according to 'angabe.md'.
 */
import codedraw.*;

import java.util.Arrays;


public class ApplicationBird {

    /**
     * The method {@code ApplicationBird} serves as an entry point for the simulation of flying birds.
     *
     * It demonstrates basic usage of the class {@link Bird}.
     */
    static void main() {

        //Runtime
        boolean noEnding = true;
        boolean running = true;
        int ending = 2147483646;
        int runTime = 0;


        //Canvas
        int width = 600;
        int height = 400;
        CodeDraw cd = new CodeDraw(width,height);

        //Birds Settings (Anzahl usw)
        int numBirds = 50; // Anzahl der Vögel
        Bird[] birds = new Bird[numBirds];

        for(int i = 0; i < numBirds; i++){
            //Zufällige Startposition innerhalb des Canvas
            double x = Math.random() * width;
            double y = Math.random() * height;

            //Zufällige Geschwindigkeit zwischen -2 und 2
            double vx = Math.random() * 4 - 2;
            double vy = Math.random() * 4 - 2;

            birds[i] = new Bird(new Vector2D(x,y), new Vector2D(vx,vy));
        }
        while(running && (noEnding || runTime < ending)){

            // alle Vögel aufeinander reagieren lassen
            for(int j = 0; j < birds.length; j++){
                for(int k = 0; k < birds.length; k++){
                    if(j != k){
                        birds[j].avoid(birds[k]);
                    }
                }
            }

            // alle bewegen und zeichnen
            cd.clear();
            for(int j = 0; j < birds.length; j++){
                birds[j].update(width,height);
                birds[j].draw(cd);
            }

            cd.show(20);
            runTime++;
        }
    }
}
