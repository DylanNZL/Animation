/**
 * Created by Dylan Cross on 27/08/16.
 * Used IntelliJ (latest) & JDK 1.8.040
 * Assignment 2 for 159.235 Graphical Programming
 *
 * Write a program called Animation that provides the following features:
 *  • Can load the provided sprite sheet and is able to draw the individual sprites contained on it. Note that each of the sprites is 256x256 pixels with no padding between them and there is one animation sequence per row.
 *  • The program initially displays the sprite in the top left (state underground), centred at the bottom of the frame.
 *  • The user can use the arrow and space keys to perform the following actions:
 *      ◦ Up arrow: play the appear animation (row 1).
 *      ◦ Left arrow: play the walk animation (row 3) and keep moving the sprite to the left until the key is released.
 *      ◦ Right arrow: play the walk animation (row 3), but horizontally reflect the sprite around its centre such that it faces to the right. Keep moving the sprite to the right until the key is released.
 *      ◦ Down arrow: play the die animation (row 4).
 *      ◦ Space: play the attack animation (row 5).
 *  • When no action is active and the skeleton is not in state underground or dead, play the idle animation (row 2).
 *  • While the skeleton is underground or dead, the only possible action is to appear.
 */