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
    private boolean right = false; // Keep track of which way the skeleton is facing (false = left, true = right).
    private BufferedImage sprite = null; // Sprite
    private BufferedImage spritePart = null; // Used for taking snippets of the sprite and printing it to the canvas
    private int stateTracker = 0; // Keeps track of where the animation is up to.

    /**
     * Added WASD controls to the skeleton as well as the arrow keys.
     * Up/W = Appear
     * Down/S = Die
     * Left/A = WalkLeft
     * Right/D = WalkRight
     * Space/K = Attack
     * No input after appearing = Idle
     * No Input before appearing/after dieing = Underground
     */
    private enum Skeleton {
        Underground, Appear, Walk, Die, Attack, Idle
    }

    private Animation() {
        this.addKeyListener(this);
        try {
            sprite = ImageIO.read(new File("./src/Assignment2/skeleton-sprite.png")); // this will need to be changed to possibly just the skeleton-sprite if it is not running in IntelliJ
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread = new Thread(this);
        thread.start();
    }

    // Repaint the canvas (will move the skeleton to the current stage of the animation)
    private void update () {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (sprite != null) {
            Graphics2D g2 = (Graphics2D) g;
            // Clear back ground (windows doesn't by default)
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            // Checks the current state, and then sends to the correct function to draw the right skeleton
            if (state == Skeleton.Underground) {
                underground(g2);
            } else if (state == Skeleton.Appear) {
                appear(g2);
            } else if (state == Skeleton.Walk) {
                walk(g2);
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
    private void walk(Graphics2D g) {
        // 8 Images
        switch(stateTracker) {
            case 0:
                spritePart = sprite.getSubimage(0, 512, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 512, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 512, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 512, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 512, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 5:
                spritePart = sprite.getSubimage(256 * 5, 512, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 6:
                spritePart = sprite.getSubimage(256 * 6, 512, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 7:
                // Last image in set, reset tracker to 0;
                spritePart = sprite.getSubimage(256 * 7, 512, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker = 0;
                break;
            default:
                spritePart = sprite.getSubimage(0, 256, 512, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
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
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 1024, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 1024, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 1024, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 1024, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 5:
                spritePart = sprite.getSubimage(256 * 5, 1024, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 6:
                spritePart = sprite.getSubimage(256 * 6, 1024, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 7:
                // Last image in set, reset tracker to 0;
                spritePart = sprite.getSubimage(256 * 7, 1024, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker = 0;
                break;
            default:
                spritePart = sprite.getSubimage(0, 1024, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker = 0;
                break;
        }
    }

    // Draws the skeleton in the idle state
    private void idle(Graphics2D g) {
        // 6 Images
        switch(stateTracker) {
            case 0:
                spritePart = sprite.getSubimage(0, 256, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 1:
                spritePart = sprite.getSubimage(256, 256, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 2:
                spritePart = sprite.getSubimage(256 * 2, 256, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 3:
                spritePart = sprite.getSubimage(256 * 3, 256, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 4:
                spritePart = sprite.getSubimage(256 * 4, 256, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker++;
                break;
            case 5:
                // Last image in set, reset to 0
                spritePart = sprite.getSubimage(256 * 5, 256, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker = 0;
                break;
            default:
                spritePart = sprite.getSubimage(0, 256, 256, 256);
                if (!right) {
                    g.drawImage(spritePart, 0, 0, null);
                } else {
                    g.drawImage(spritePart, 0, 0, 256, 256, 256, 0, 0, 256, null);
                }
                stateTracker = 0;
                break;
        }
    }

    // Thread
    @Override
    public void run() {
        long delayTime = 1000 / 7; // ms / FPS
        long startTime, waitTime, elapsedTime;
        Thread th = Thread.currentThread();
        while (thread == th) {
            startTime = System.currentTimeMillis();
            // Call update which repaints the canvas
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

    // Changes the state of the animation if the key pressed is the attack/walk buttons
    // The program has to check that it is not it's current state or it will be overwhelmed with button presses on windows (works on Mac though)
    @Override
    public void keyPressed(KeyEvent event) {
        if (state != Skeleton.Underground) {
            if (event.getKeyChar() == 'a' || event.getKeyChar() == 'A' || event.getKeyCode() == 37) {
               if (state != Skeleton.Walk) {
                    right = false;
                    stateTracker = 0;
                    state = Skeleton.Walk;
               }
            } else if (event.getKeyChar() == 'd' || event.getKeyChar() == 'D' || event.getKeyCode() == 39) {
                if (state != Skeleton.Walk) {
                    right = true;
                    stateTracker = 0;
                    state = Skeleton.Walk;
                }
            } else if (event.getKeyCode() == 32 || event.getKeyChar() == 'k' || event.getKeyChar() == 'K') {
                if (state != Skeleton.Attack) {
                    stateTracker = 0;
                    state = Skeleton.Attack;
                }
            }
        }
    }

    // Changes the state of the animation if the key released was changing the state, or allows the skeleton to appear/die
    @Override
    public void keyReleased(KeyEvent event) {
        if (state != Skeleton.Underground) {
            if (event.getKeyChar() == 'a' || event.getKeyChar() == 'A' || event.getKeyCode() == 37) {
                state = Skeleton.Idle;
                stateTracker = 0;
            } else if (event.getKeyChar() == 'd' || event.getKeyChar() == 'D' || event.getKeyCode() == 39) {
                state = Skeleton.Idle;
                stateTracker = 0;
            } else if (event.getKeyChar() == 'k' || event.getKeyCode() == 32) {
                state = Skeleton.Idle;
                stateTracker = 0;
            } else if (event.getKeyCode() == 40) {
                if (state != Skeleton.Die) {
                    stateTracker = 0;
                    state = Skeleton.Die;
                }
            }
        } else if (event.getKeyCode() == 38) {
            if (state != Skeleton.Appear) {
                stateTracker = 0;
                state = Skeleton.Appear;
            }
        }
    }

    // If the key typed corresponds to any of these keys, it will change the state (or quit the game if it was a 'Q')
    // Arrow keys won't work here for some reason due to it not being "typed" (Maybe?) Kept it so that Q/W/S will work using this method.
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
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("* 159.235 Assignment 2, Semester 2 2016 *");
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