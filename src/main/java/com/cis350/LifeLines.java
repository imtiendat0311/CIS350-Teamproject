

package com.cis350;

import java.util.*;
import javax.swing.*;

public class LifeLines {

  //all lifeline's options
  //JButton fiftyFiftyBtn, callRelativeBtn, askAudienceBtn;
  //ImageIcon fifty50Icon, callRelIcon, askAuIcon;
  //create object
  String[] currentQuestion;
  int correctIdx;
  JButton[] listButton;

  public LifeLines(JButton[] listButton, String[] currentQuestion, int correctIdx){
        this.listButton = listButton;
        this.currentQuestion = currentQuestion;
        this.correctIdx = correctIdx;
        // 50:50
//fifty50Icon=
  //      new ImageIcon(
       /*Objects.requireNonNull(
        getClass().getClassLoader().getResource("images/fiftyFifty-icon.jpg")
        )
        );
        Image img5050=fifty50Icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scale5050=new ImageIcon(img5050);
        fiftyFiftyBtn=new JButton();
        fiftyFiftyBtn.setIcon(scale5050);
        fiftyFiftyBtn.setBounds(500,180,50,50);
        fiftyFiftyBtn.addActionListener(new Mylistener());
        // call relative
        callRelIcon=
        new ImageIcon(
        Objects.requireNonNull(
        getClass().getClassLoader().getResource("images/callRelative-icon.png")
        )
        );
        Image imgcall=fifty50Icon.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon scalecallRel=new ImageIcon(imgcall);
        callRelativeBtn=new JButton();
        callRelativeBtn.setIcon(scalecallRel);

        // ask audience
        askAuIcon=
        new ImageIcon(
        Objects.requireNonNull(
        getClass().getClassLoader().getResource("images/askAudience-icon.png")
        )
        );
        */
}
  // 50 50
  public void fiftyFifty() {
    int current = correctIdx;
    int[] choose = new int[2];
    Random rand = new Random();
    while (choose[0] == current || choose[1] == current || choose[1] == choose[0]) {
      choose[0] = rand.nextInt(4);
      choose[1] = rand.nextInt(4);
    }
    listButton[choose[0]].setText("");
    listButton[choose[1]].setText("");
    listButton[choose[0]].setEnabled(false);
    listButton[choose[1]].setEnabled(false);
  }

  public void askAudience() {
    int current = correctIdx;
    Random rand = new Random();
    int propCorrect = rand.nextInt(51); // min 50
    int[] prop = new int[4];
    int maxPropleft = 100 - propCorrect;
    prop[current] = propCorrect;
    for (int i = 0; i < 4; i++) {
      if (i != current) {
        prop[i] = rand.nextInt(maxPropleft);
        maxPropleft -= prop[i];
        listButton[i].setText(" " + (maxPropleft) + "%");
      } else {
        listButton[i].setText(" " + (maxPropleft + 3) + "%");
      }
    }
  }
  public void callRelative() {
    int[] choose = new int[4];
    Random rand = new Random();
    int randomNum = rand.nextInt(4);
    for(int i =0; i < 4; ++i) {
      listButton[i].setText((i != randomNum) ? "" : "Your mom wants you to choose this!");
      listButton[i].setEnabled(i == randomNum);
    }
  }
  /*
  public void setQuestion(Question question) {
    this.currentQuestion = question;
  }
  */
  /*
  private class Mylistener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() ==   fiftyFiftyBtn){
        fiftyFifty();
      }
    }
  }
   */
}
