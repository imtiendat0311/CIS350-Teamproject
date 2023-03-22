package com.cis350;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class HelpScreen extends JFrame {

  JLabel helpLabel; // Create label
  static JFrame beginScreen; // Recall begin screen
  JFrame helpFrame; // Create frame
  ImageIcon background;
  JButton backButton = new JButton();

  public HelpScreen(JFrame beginScreen) {
    HelpScreen.beginScreen = beginScreen;
    helpFrame = new JFrame();
    helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // create a button to go back
    backButton = new JButton("Back");
    backButton.setBounds(1050, 90, 100, 60);
    backButton.setFont(new Font("Millionaire", Font.BOLD, 16));
    backButton.setForeground(Color.white);
    backButton.setBorder(new LineBorder(Color.WHITE, 3));
    backButton.setBackground(new Color(0, 114, 240));

    backButton.addActionListener(actionEvent -> {
      helpFrame.setVisible(false);
      HelpScreen.beginScreen.setVisible(true);
    });
    background =
      new ImageIcon(
        Objects.requireNonNull(
          getClass()
            .getClassLoader()
            .getResource("images/volcanic-cone-Japan-Mount-Fuji.png")
        )
      );
    JLabel bgIcon = new JLabel(background);
    helpFrame.setContentPane(bgIcon);
    helpLabel = new JLabel();
    helpLabel =
      new JLabel(
        "<html> A trivia game is a fun and engaging way to test your knowledge on " +
        "a variety of topics. This type of game typically involves a question bar, where the player is presented with a " +
        "question, and four answer choices to choose from. The guidelines for playing the game are usually " +
        "straightforward and easy to follow. The player must select the correct answer from the choices provided within a certain time limit." +
        "Whether you're playing alone or with friends, a trivia game is a great way to " +
        "challenge your brain and have fun at the same time. </html>",
        SwingConstants.CENTER
      );
    helpLabel.setFont(new Font("Millionaire", Font.BOLD, 26));
    helpLabel.setForeground(Color.white);
    helpLabel.setBounds(180, 50, 1000, 800);
    helpLabel.setBackground(new Color(0, 0, 255, 127));
    helpLabel.setOpaque(true);
    helpLabel.setBorder(BorderFactory.createLineBorder(Color.white, 3));
    helpFrame.add(helpLabel);
    helpFrame.add(backButton);

    helpFrame.setSize(1400, 967);
    helpFrame.setResizable(false);
    helpFrame.setVisible(true);
  }
}
