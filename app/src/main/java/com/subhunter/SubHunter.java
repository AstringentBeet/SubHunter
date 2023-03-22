package com.subhunter;

import android.app.Activity;
import android.view.Window;
import android.os.Bundle;
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
* In addition to the game itself, the game will display debugging
* information in order to perform tests and check whether everything is
* working as it should be.
 */
public class SubHunter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}