package com.cis350;

import java.awt.Color;
import java.awt.Font;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AboutScreen extends JFrame {

  //Recall begin screan
  static JFrame beginScreen;
  //Create frame
  JFrame aboutFrame;
  //Create label
  JLabel aboutLabel;
  //Image
  ImageIcon backGroundIcon;

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

    backGroundIcon =
      new ImageIcon(
              Objects.requireNonNull(getClass().getClassLoader().getResource("images/volcanic-cone-Japan-Mount-Fuji.png"))
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
    aboutFrame.setSize(1400, 967);
    aboutFrame.setResizable(false);
    aboutFrame.setVisible(true);
  }
}
