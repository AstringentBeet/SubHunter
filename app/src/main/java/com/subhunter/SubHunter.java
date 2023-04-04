package com.subhunter;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.Window;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.util.Log;
import android.widget.ImageView;
import java.util.Random;

/*
* The objective of this game is to find and destroy the enemy sub' in
* as few moves as possible. The player takes the shot and each time
* guesses the location of the sub' by taking into account the distance
* feedback (or sonar ping) from all of the previous shots.
*
* The game starts with the player facing an empty grid with a  randomly
* placed (hidden) submarine lurking somewhere within it.
*
* The gird represents the sea, and each place on the gird is a possible
* hiding place for the submarine that the player is hunting. The player
* takes shots at the sub' by guessing where it might be hiding and tapping
* one of the squares on the grid.
*
* As the player takes more shots, they can build up a better mental picture
* of the likely location of the sub until, eventually, they guess the exact
* square and the game is won.
*
* Once the player has destroyed the sub', the next tap on the screen will
* spawn a new sub' in a random location and the game starts again.
*
* In addition to the game itself, the app will display debugging
* information in order to perform tests and check whether everything is
* working as it should be.
*/

/**** Android API ****/
public class SubHunter extends Activity {

    int numberHorizontalPixels;
    int numberVerticalPixels;
    int blockSize;
    int gridWidth = 40;
    int gridHeight;
    float horizontalTouched = -100;
    float verticalTouched = -100;
    int subHorizontalPosition;
    int subVerticalPosition;
    boolean hit = false;
    int shotsTaken;
    int distanceFromSub;
    boolean debugging = true;

    /**** One-off setup ****/
    /*
    * Android runs this code just before the player sees the
    * app. This makes it a good place to add the code for the
    * one-time setup phase. Thankfully, it is auto-generated
    * by Android Studio.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //getting device's current screen resolution.
        Display display =
                getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        /*
         * Initialize the size-based variables
         * based on the screen resolution
         */
        numberHorizontalPixels = size.x;
        numberVerticalPixels = size.y;
        blockSize = numberHorizontalPixels / gridWidth;
        gridHeight = numberVerticalPixels / blockSize;
        Log.d("Debugging", "In onCreate");
        newGame();
        draw();
    }

    /**** Spawn Sub Reset Score (aka New Game) ****/
    /*
    * This code will execute when a new games is
    * initiated. It will happen when the app is first
    * started and the player wins the game.
    */
    public void newGame()
    {
        Random random = new Random();
        subHorizontalPosition = random.nextInt(gridWidth);
        subVerticalPosition = random.nextInt(gridHeight);
        shotsTaken = 0;

        Log.d("Debugging", "In newGame");
    }

    /**** Draw Grid; Draw Heads-up-display (HUD) ****/
    /*
    * Here, we will do all the drawing. The grid lines, the
    * HUD and the touch indicator.
    */
    void draw()
    {
        //handle all drawings here.
        //waiting for the onTouchEvent() and takeShot() method.
        Log.d("Debuging", "In draw()");
        printDebuggingText();
    }

    /**** Wait for Input, Player takes Shot; Was Target Hit? (If not, carry on) ****/
    /*
    * This part of the code will handle detecting that the
    * player taps the screen. It will calculate the distance
    * from the sub' and decide a hit or miss.
     */
    @Override
    public boolean onTouchEvent (MotionEvent motionEvent)
    {
        Log.d("Debugging", "In onTouchEvent");
        takeShot();
        return true;
    }

    void takeShot()
    {
        Log.d("Debugging", "In takeShot");
        draw();
    }

    //This code says "BOOM!"
    void boom()
    {

    }

    //This code prints the debugging test.
    void printDebuggingText()
    {
        Log.d("number of horizontal pixels: ", "" + numberHorizontalPixels);
        Log.d("Number of vertical pixels: ", "" + numberVerticalPixels);
        Log.d("Block size: ", "" + blockSize);
        Log.d("Grid width: ", "" + gridWidth);
        Log.d("Grid Height: ", "" + gridHeight);
        Log.d("Touched, horizontal location: ", "" + horizontalTouched);
        Log.d("Touched, vertical location: ", "" + verticalTouched);
        Log.d("Sub-horizontal position: ", "" + subHorizontalPosition);
        Log.d("Sub-vertical position: ", "" + subVerticalPosition);
        Log.d("User's hit coordinates: ", "" + hit);
        Log.d("Number of shots player has made: ", "" + shotsTaken);
        Log.d("Currently debugging? ", "" + debugging);
        Log.d("Distance from sub: ", "" + distanceFromSub);
    }

}