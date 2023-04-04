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

    //Declaring drawing objects...
    ImageView gameView;
    Bitmap blankBitmap;
    Canvas canvas;
    Paint paint;

    /**** One-off setup ****/
    /*
    * Android runs this code just before the player sees the
    * app. This makes it a good place to add the code for its
    * one-time setup. Thankfully, it is auto-generated
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

        //Initializing Objects...
        blankBitmap = Bitmap.createBitmap
                (numberHorizontalPixels, numberVerticalPixels, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(blankBitmap);
        gameView = new ImageView(this);
        paint = new Paint();
        setContentView(gameView);

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
        gameView.setImageBitmap(blankBitmap);
        canvas.drawColor(Color.argb(255, 255, 255, 255));

        //change the paint color to black
        paint.setColor(Color.argb(255, 0, 0, 0));
        /*
         * Draw the vertical lines of the grid
         * canvas.drawLine(blockSize * 1, 0,
         *              blockSize * 1, numberVerticalPixels -1, paint);
         * Horizontal lines.
         * canvas.drawLine(0, blockSize,
         *      numberHorizontalPixels -1, blockSize, paint);
         */

        //Drawing the vertical lines of the grid...
        for(int i = 0; i < gridWidth; i++)
        {
            canvas.drawLine(blockSize * i, 0,
                    blockSize * i , numberVerticalPixels, paint);
        }

        //Drawing the horizontal lines of the grid...
        for(int i = 0; i < gridHeight; i++)
        {
            canvas.drawLine(0, blockSize * i,
                    numberHorizontalPixels, blockSize * i, paint);
        }

        //Setting the size of the text appropriate for the
        //score and distance display:
        paint.setTextSize(blockSize * 2);
        paint.setColor(Color.argb(255, 0, 0, 255));
        canvas.drawText("Shots Taken: " + shotsTaken +
                " Distance: " + distanceFromSub, blockSize * 1,
                blockSize * 1.75f, paint);

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
         paint.setTextSize(blockSize);
         canvas.drawText("number of horizontal pixels: " +
                 numberHorizontalPixels, 50, blockSize * 3, paint);
         canvas.drawText("Number of vertical pixels: " +
                 numberVerticalPixels, 50, blockSize * 4, paint);
         canvas.drawText("Block size: " +
                 blockSize, 50, blockSize * 5, paint);
         canvas.drawText("Grid width: " +
                 gridWidth, 50, blockSize * 6, paint);
         canvas.drawText("Grid Height: " +
                 gridHeight, 50, blockSize * 7, paint);
         canvas.drawText("Horizontal coordinate touched: " +
                 horizontalTouched, 50, blockSize * 8, paint);
         canvas.drawText("Vertical coordinates touched: " +
                 verticalTouched, 50, blockSize * 9, paint);
         canvas.drawText("Sub' horizontal position: " +
                 subHorizontalPosition, 50, blockSize * 10, paint);
         canvas.drawText("Sub' vertical position: " +
                 subVerticalPosition, 50, blockSize * 11, paint);
         canvas.drawText("Hit? " +
                 hit, 50, blockSize * 12, paint);
         canvas.drawText("Shots taken: " +
             shotsTaken, 50, blockSize * 13, paint);
         canvas.drawText("Debugging: " +
                 debugging, 50, blockSize * 14, paint);

    }

}