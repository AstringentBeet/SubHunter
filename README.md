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

**Note: Delete this note and update the table of contents based on what sections you keep.**

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

### Progress Log

#### 03/22/23
Created the first half of the main main layout. Using Android API, all it is right now is a blank screen, which is a start. The next step is to create the grids, followed along with the score/hint board that updates the user with every tap/touch, giving hints as to where the hidden sub' is.


### Built with

- Java
- Android Studio

### What I learned


### Useful resources


## Author

- Website - [Alex](https://astringentbeet.github.io/ratingPage/)
- Frontend Mentor - [@AstringentBeet](https://www.frontendmentor.io/profile/AstringentBeet)

