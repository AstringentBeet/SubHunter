# Learning Java By Building Android Games (Third Edition) – Sub Hunter

## Table of contents

- [Overview](#overview)
  - [The challenge](#the-challenge)
  - [Screenshot](#screenshot)
  - [Links](#links)
- [My process](#my-process)
  - [Progress log](#progress-log)
  - [Built with](#built-with)
  - [What I learned](#what-i-learned)
  - [Continued development](#continued-development)
  - [Useful resources](#useful-resources)
- [Author](#author)
- [Acknowledgments](#acknowledgments)


## Overview
The objective of this game is to find and destroy the enemy sub' in as few moves as possible. The player takes the shot and each time guesses the location of the sub' by taking into account the distance feedback (or sonar ping) from all of the previous shots. 

The game starts with the player facing an empty grid with a randomly placed (hidden) submarine lurking somewhere within it.                

The gird represents the sea, and each place on the gird is a possible hiding place for the submarine that the player is hunting. The player takes shots at the sub' by guessing where it might be hiding and tapping one of the squares on the grid.                                             
                                                                            
As the player takes more shots, they can build up a better mental picture of the likely location of the sub until, eventually, they guess the exact square and the game is won.                                                 
                                                                            
Once the player has destroyed the sub', the next tap on the screen will spawn a new sub' in a random location and the game starts again.            
                                                                            
In addition to the game itself, the game will display debugging information in order to perform tests and check whether everything is working as it should be.                                                                                                                                             

### The challenge

Users should be:

- Able to click on any one of the grids within the screen
- Able to utilize the full screen of the application on their respective android device
- Given hints as to where the submarine is located.
- Able to win the game once the character manages to find the correct location of the hidden sub'.

### Screenshot

![](./screenshot.jpg)


### Links

- Solution URL: [Add solution URL here](https://your-solution-url.com)
- Live Site URL: [Add live site URL here](https://your-live-site-url.com)

## My process
Utilize the android api to create a blank screen. This will allow me to create a grid display.

  ![Flowchart of Sub Hunter](/Users/alex/Pictures/misc/csProjects/SubHunter-flowchart.jpg)
As the flowchart shows:

1. The game is launched by tapping on its icon in the app drawer (or by running it through Android Studio)
2. The sub' is placed in a random location by generating random horizontal and vertical numbers. The score is set to zero if this is not the first play of the game.
3. Next, everything is drawn to the screen: The gird-lines and text (heads-up display or HUD), including the debugging text (if enabled).
4. At this point, the game does nothing. It is waiting for the player to tap on the screen.
5. When the player taps on the screen, the pixel has been tapped is converted into a location on a grid, and that location is compared to the location of the sub'. The <b>hit?</b> diamond illustrates this comparison. Here, the program could branch back to the drawing phase to redraw everything, including the grid location.
6. Alternatively, if there was a hit, then the <b>BOOM!</b> screen is shown.
7. In fact, the <b>BOOM!</b> part isn't exactly as we see it there. <b>Wait for input</b> phase also handles waiting for a screen tap at this point. When the screen is tapped again, it is considered the first shot of the next game; the flow of the code moves back to the <b>Spawn Reset Score</b> code, and the whole process starts again. This will become clearer as the project progresses.


### Progress Log

#### 03/22/23; 3:34am
Created the first half of the main main layout. Using Android API, all it is right now is a blank screen, which is a start. The next step is to create the grids, followed along with the score/hint board that updates the user with every tap/touch, giving hints as to where the hidden sub' is.

#### 03/24/23; 2:21pm
Slowly connecting the pieces together. The app utilizes the `onCreate()` method to call on both the `newGame()` and `draw()` method to initiate the <b>Wait for Input</b> phase. Once the user taps the screen, the `onTouchEvent()` method will be realized calling the `takeShot()` method. If the user managed to land a hit and sink an enemy sub, the game is reset using the `draw()` method called by `takeShot()`. 


### Built with

- Java
- Android Studio
- Android API

### What I learned


### Useful resources


## Author

- Website - [Alex](https://astringentbeet.github.io/ratingPage/)
- Frontend Mentor - [@AstringentBeet](https://www.frontendmentor.io/profile/AstringentBeet)

