package com.cis350;

import java.awt.Color;
import java.awt.Font;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AboutScreen extends JFrame {


  static JFrame beginScreen; //Recall begin screan
  JFrame aboutFrame; //Create frame
  JLabel aboutLabel; //Create label
  ImageIcon backGroundIcon; //Image
  JButton backButton = new JButton("Back");

  public AboutScreen(JFrame beginScreen) {
    AboutScreen.beginScreen = beginScreen;
    aboutFrame = new JFrame();
    aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    aboutFrame.addWindowListener(
      new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
          System.out.println("CloseButton is working");
          AboutScreen.beginScreen.setVisible(true);
        }
      }
    );

    // create a button to go back
    backButton = new JButton("Back");
    backButton.setBounds(920, 180, 100, 60);
    backButton.setFont(new Font("Millionaire", Font.BOLD, 16));
    backButton.setForeground(Color.white);
    backButton.setBorder(new LineBorder(Color.WHITE, 3));
    backButton.setBackground(new Color(0, 114, 240));

    backButton.addActionListener(actionEvent -> {
      aboutFrame.dispose();
      beginScreen.setVisible(true);
    });

    backGroundIcon =
      new ImageIcon(
        Objects.requireNonNull(
          getClass()
            .getClassLoader()
            .getResource("images/volcanic-cone-Japan-Mount-Fuji.png")
        )
      );

    JLabel backGround = new JLabel(backGroundIcon);

    aboutFrame.setContentPane(backGround);

    aboutLabel = new JLabel();

    //set panel

    aboutLabel =
      new JLabel(
        "<html><p>This program is made by:<br/> Duc Pham <br/> Harrison VanderZee <br/> Leo Ho <br/> CIS 350 PROJECT WINTER 2023</p></html>",
        SwingConstants.CENTER
      );

    aboutLabel.setFont(new Font("Millionaire", Font.BOLD, 26));
    aboutLabel.setForeground(Color.white);
    aboutLabel.setBounds(270, 150, 800, 600);
    aboutLabel.setBackground(new Color(0, 0, 255, 127));
    aboutLabel.setOpaque(true);
    aboutLabel.setBorder(BorderFactory.createLineBorder(Color.white, 3));


    aboutFrame.add(aboutLabel);
    aboutFrame.add(backButton);
    aboutFrame.setSize(1400, 967);
    aboutFrame.setResizable(false);
    aboutFrame.setVisible(true);
  }
}
