package Assignment2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by Dylan Cross on 27/08/16.
 * Used IntelliJ (latest) & JDK 1.8.040
 * Assignment 2 for 159.235 Graphical Programming
 */
public class Animation extends JPanel implements KeyListener, Runnable {

    private Thread thread = null; // Thread
    private Skeleton state = Skeleton.Underground; // Keep track of the state of the skeleton
    private BufferedImage sprite = null; // Sprite
    private BufferedImage spritePart = null; // Used for taking snippets of the sprite and printing it to the canvas
    private int stateTracker = 0; // Keeps track of where the animation is up to.

    /**
     * Up = Appear
     * Down = Die
     * Left = WalkLeft
     * Right = WalkRight
     * Space = Attack
     * No input after appearing = Idle
     * No Input before appearing/after dieing = Underground
     */
    private enum Skeleton {
        Underground, Appear, WalkLeft, WalkRight, Die, Attack, Idle
    }

    Animation() {

        this.addKeyListener(this); // Listen to key presses on this JPanel

        try {
            sprite = ImageIO.read(new File("./src/Assignment2/skeleton-sprite.png")); // this will need to be changed to possibly just the skeleton-sprite if it is not running in IntelliJ
        } catch (IOException e) {
            e.printStackTrace();
        }

        thread = new Thread(this); // create separate thread to run our Timer
        thread.start(); // and start it
    }

    private void update () {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (sprite != null) {
            Graphics2D g2 = (Graphics2D) g;
            // Underground, Appear, WalkLeft, WalkRight, Die, Attack, Idle
            if (state == Skeleton.Underground) {
                underground(g2);
            } else if (state == Skeleton.Appear) {
                appear(g2);
            } else if (state == Skeleton.WalkLeft) {
                walkLeft(g2);
            } else if (state == Skeleton.WalkRight) {
                walkRight(g2);
            } else if (state == Skeleton.Die) {
                die(g2);
            } else if (state == Skeleton.Attack) {
                attack(g2);
            } else {
                idle(g2);
            }
        }
    }

    // Draws the skeleton in the underground state
    private void underground(Graphics2D g) {
        spritePart = sprite.getSubimage(0, 0, 256, 256);
        g.drawImage(spritePart, 0, 0, null);
    }

    // Draws the skeleton in the appear state
    private void appear(Graphics2D g) {
        // 10 images
        switch(stateTracker) {
            case 0:
                spritePart = sprite.getSubimage(0, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 5:
                spritePart = sprite.getSubimage(256 * 5, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 6:
                spritePart = sprite.getSubimage(256 * 6, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 7:
                spritePart = sprite.getSubimage(256 * 7, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 8:
                spritePart = sprite.getSubimage(256 * 8, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 9:
                // Last image in set so set the tracker to 0 and put the state to idle
                spritePart = sprite.getSubimage(256 * 8, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                state = Skeleton.Idle;
                stateTracker = 0;
                break;
            default:
                spritePart = sprite.getSubimage(0, 0, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
        }
    }

    // Draws the skeleton in the walkLeft state
    private void walkLeft(Graphics2D g) {
        // 8 Images
        switch(stateTracker) {
            case 0:
                spritePart = sprite.getSubimage(0, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 5:
                // Last image in set, reset to 0
                spritePart = sprite.getSubimage(256 * 5, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 6:
                spritePart = sprite.getSubimage(256 * 6, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 7:
                // Last image in set, reset tracker to 0;
                spritePart = sprite.getSubimage(256 * 7, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
            default:
                spritePart = sprite.getSubimage(0, 256, 512, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
        }
    }

    // Draws the skeleton in the walkRight state
    private void walkRight(Graphics2D g) {
        // 8 Images
        switch(stateTracker) {
            case 0:
                spritePart = sprite.getSubimage(0, 512, 256, 256);
                g.rotate(180, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                g.rotate(180, 256, 256);
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 5:
                // Last image in set, reset to 0
                spritePart = sprite.getSubimage(256 * 5, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 6:
                spritePart = sprite.getSubimage(256 * 6, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 7:
                // Last image in set, reset tracker to 0;
                spritePart = sprite.getSubimage(256 * 7, 512, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
            default:
                spritePart = sprite.getSubimage(0, 256, 512, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
        }
    }

    // Draws the skeleton in the die state
    private void die(Graphics2D g) {
        // 8 Images
        switch(stateTracker) {
            case 0:
                spritePart = sprite.getSubimage(0, 768, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 768, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 768, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 768, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 768, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 5:
                // Last image in set, reset to 0
                spritePart = sprite.getSubimage(256 * 5, 768, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 6:
                spritePart = sprite.getSubimage(256 * 6, 768, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 7:
                // Last image in set, reset tracker to 0;
                spritePart = sprite.getSubimage(256 * 7, 768, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                state = Skeleton.Underground;
                break;
            default:
                spritePart = sprite.getSubimage(0, 256, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
        }
    }

    // Draws the skeleton in the attack state
    private void attack(Graphics2D g) {
        // 8 Images
        switch(stateTracker) {
            case 0:
                spritePart = sprite.getSubimage(0, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 5:
                spritePart = sprite.getSubimage(256 * 5, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 6:
                spritePart = sprite.getSubimage(256 * 6, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 7:
                // Last image in set, reset tracker to 0;
                spritePart = sprite.getSubimage(256 * 7, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
            default:
                spritePart = sprite.getSubimage(0, 1024, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 1;
                break;
        }
    }

    // Draws the skeleton in the idle state
    private void idle(Graphics2D g) {
        // 6 Images
        switch(stateTracker) {
            case 0:
                spritePart = sprite.getSubimage(0, 256, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 256, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 256, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 256, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 256, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker++;
                break;
            case 5:
                // Last image in set, reset to 0
                spritePart = sprite.getSubimage(256 * 5, 256, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
            default:
                spritePart = sprite.getSubimage(0, 256, 256, 256);
                g.drawImage(spritePart, 0, 0, null);
                stateTracker = 0;
                break;
        }
    }

    @Override
    public void run() {
        long delayTime = 1000 / 5; // ms / FPS
        long startTime, waitTime, elapsedTime;

        Thread th = Thread.currentThread();

        while (thread == th) {
            startTime = System.currentTimeMillis();

            update();

            elapsedTime = System.currentTimeMillis() - startTime;
            waitTime = Math.max(delayTime - elapsedTime, 5);
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                thread.interrupt();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (state != Skeleton.Underground) {
            if (event.getKeyChar() == 'a' || event.getKeyChar() == 'A' || event.getKeyCode() == 37) {
                state = Skeleton.WalkLeft;
                stateTracker = 0;
            } else if (event.getKeyChar() == 'd' || event.getKeyChar() == 'D' || event.getKeyCode() == 39) {
                state = Skeleton.WalkRight;
                stateTracker = 0;
            } else if (event.getKeyChar() == ' ' || event.getKeyChar() == 'k') {
                state = Skeleton.Attack;
                stateTracker = 0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (state != Skeleton.Underground) {
            if (event.getKeyChar() == 'a' || event.getKeyChar() == 'A' || event.getKeyCode() == 37) {
                state = Skeleton.Idle;
                stateTracker = 0;
            } else if (event.getKeyChar() == 'd' || event.getKeyChar() == 'D' || event.getKeyCode() == 39) {
                state = Skeleton.Idle;
                stateTracker = 0;
            } else if (event.getKeyChar() == ' ' || event.getKeyChar() == 'k' || event.getKeyCode() == 32) {
                state = Skeleton.Idle;
                stateTracker = 0;
            } else if (event.getKeyCode() == 40) {
                state = Skeleton.Die;
                stateTracker = 0;
            }
        } else if (state == Skeleton.Underground && event.getKeyCode() == 38) {
            state = Skeleton.Appear;
            stateTracker = 0;
        }
        System.out.println(event.getKeyChar());
        System.out.println(event.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent event) {
        if (event.getKeyChar() == 'q' || event.getKeyChar() == 'Q') {
            System.exit(0);
        } else if ((event.getKeyChar() == 'w' || event.getKeyChar() == 'W') && state == Skeleton.Underground) {
            state = Skeleton.Appear;
            stateTracker = 0;
        }  else if ((event.getKeyChar() == 's' || event.getKeyChar() == 'S') && state != Skeleton.Underground) {
            state = Skeleton.Die;
            stateTracker = 0;
        }
        System.out.println(event.getKeyChar());
        System.out.println(event.getKeyCode());

    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("* 159.235 Assignment 1, Semester 2 2016 *");
        System.out.println("* Submitted by:  Cross, Dylan, 15219491 *");
        System.out.println("*****************************************");
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Assignment 2 - 159.235");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);
            Animation panel = new Animation();
            frame.addKeyListener(panel);
            frame.setContentPane(panel);
            frame.setSize(256, 256);
            frame.setVisible(true);
        });
    }
}
