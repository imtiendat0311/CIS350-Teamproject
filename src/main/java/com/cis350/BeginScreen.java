package com.cis350;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.*;

/**Project name: The Way To Olympus
 * Types: Quiz competition
 */

/**Note:
 *Save your project
 */

/******************************************Begin here********************************************************/

public class BeginScreen {

  //Frame

  JFrame frame;

  //3 button for the player to choose when start the program
  JButton startGameButton, helpButton, aboutButton;

  //Background image

  ImageIcon backGroundImage;

  //Label

  JLabel gameLabel;
  BackgroundSound backgroundSound = new BackgroundSound();

  public BeginScreen() {
    backgroundSound.playSound();
    //Create the game frame with name "The Way To Olympus"

    frame = new JFrame("The Way To Olympus");

    //Background image for main screen

    backGroundImage =
      new ImageIcon(
        Objects.requireNonNull(
          getClass()
            .getClassLoader()
            .getResource("images/volcanic-cone-Japan-Mount-Fuji.png")
        )
      );

    JLabel backGround = new JLabel(backGroundImage);

    frame.setContentPane(backGround);
    frame.setLayout(null);

    //Game label

    gameLabel = new JLabel("The Way To Olympus");
    gameLabel.setHorizontalAlignment(JLabel.CENTER);
    gameLabel.setBounds(460, 100, 550, 100);
    gameLabel.setFont(new Font("Millionaire", Font.BOLD, 50));
    gameLabel.setBorder(new LineBorder(Color.white, 3));
    gameLabel.setForeground(Color.white);
    gameLabel.setBackground(new Color(0, 114, 250));
    gameLabel.setOpaque(true);

    //Add start game button and its animation which start game button is dropping from the screen

    startGameButton = new JButton("Start");
    startGameButton.setBounds(620, 380, 200, 50);
    startGameButton.setFont(new Font("Millionaire", Font.BOLD, 18));
    startGameButton.setForeground(Color.white);
    startGameButton.setBorder(new LineBorder(Color.WHITE, 3));
    startGameButton.setBackground(new Color(0, 114, 240));
    startGameButton.addActionListener(new Mylistener());

    //Add help game button and its animation which start game button is dropping from the screen

    helpButton = new JButton("Help");
    helpButton.setBounds(620, 470, 200, 50);
    helpButton.setFont(new Font("Millionaire", Font.BOLD, 18));
    helpButton.setForeground(Color.white);
    helpButton.setBorder(new LineBorder(Color.WHITE, 3));
    helpButton.setBackground(new Color(0, 114, 240));
    helpButton.addActionListener(new Mylistener());

    //Add about game button and its animation which start game button is dropping from the screen

    aboutButton = new JButton("About");
    aboutButton.setBounds(620, 560, 200, 50);
    aboutButton.setFont(new Font("Millionaire", Font.BOLD, 18));
    aboutButton.setForeground(Color.white);
    aboutButton.setBorder(new LineBorder(Color.WHITE, 3));
    aboutButton.setBackground(new Color(0, 114, 240));
    aboutButton.addActionListener(new Mylistener());

    frame.add(gameLabel);
    frame.add(aboutButton);
    frame.add(helpButton);
    frame.add(startGameButton);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1400, 967);
    frame.setResizable(false);
    frame.setVisible(true);
  }

  //getter use for JUnit test
  public JButton getStartGameButton() {
    return startGameButton;
  }

  public JButton getHelpButton() {
    return helpButton;
  }

  public JButton getAboutButton() {
    return aboutButton;
  }

  public JFrame getFrame() {
    return frame;
  }

  public static void main(String[] args) {
    new BeginScreen();
  }

  private class Mylistener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == aboutButton) {
        AboutScreen aboutScreen = new AboutScreen(frame);
        aboutScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        aboutScreen.addWindowListener(
          new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
              System.out.println("CloseButton is working");
              frame.setVisible(true);
            }
          }
        );
        frame.setVisible(false);
      }
      if (e.getSource() == helpButton) {
        HelpScreen help = new HelpScreen(frame);
        help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // simple test
        help.addWindowListener(
          new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
              System.out.println("CloseButton is working");
              frame.setVisible(true);
            }
          }
        );

        frame.setVisible(false);
        System.out.println("HelpButton is working"); // test
      }
      if (e.getSource() == startGameButton) {
        StartScreen startScreen = new StartScreen(frame, backgroundSound);
        startScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        startScreen.addWindowListener(
          new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
              System.out.println("CloseButton is working");
              frame.setVisible(true);
            }
          }
        );
        frame.setVisible(false);
      }
    }
  }
}
