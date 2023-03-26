package com.cis350;

import static java.awt.event.KeyEvent.VK_ENTER;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class StartScreen extends JFrame {

  LifeLines life;
  SaveScore saveScore;
  // List of questions and answers
  QuestionsAndKeyList questionsAndKeyLists;
  Question currentQuestion;
  JButton[] listButton;
  // BeginScree
  static JFrame beginScreen;
  JFrame startFrame; // Frame
  JPanel startPanel; // Panel
  ImageIcon backGroundImage, soundImg; // Image
  // Buttons for answers
  JButton answerAButton, answerBButton, answerCButton, answerDButton;
  JButton fiftyFiftyBtn, callRelativeBtn, askAudienceBtn;
  JButton backButton = new JButton("Back"); // create a back button
  JButton soundButton;
  JTextArea questionLabel; // Question label
  int totalPoint = 0; // total point
  String userAnswer; // save userAnswer
  int questionIndex = 0; // current question
  boolean isCorrect = false;
  boolean isSoundOn = true;
  BackgroundSound backgroundSound;
  Timer timer; // create a timer
  int seconds;
  JLabel counterLable;
  ImageIcon fifty50Icon, askAuIcon, callRelIcon;
  String playerName;
  JLabel scoreBoard;

  public StartScreen(
    JFrame beginScreen,
    BackgroundSound backgroundSound,
    String playerName
  ) {
    this.playerName = playerName;
    this.backgroundSound = backgroundSound;
    listButton = new JButton[4];

    saveScore = new SaveScore();

    StartScreen.beginScreen = beginScreen;
    startFrame = new JFrame();
    startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    startFrame.addWindowListener(
      new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
          System.out.println("CloseButton is working");
          StartScreen.beginScreen.setVisible(true);
        }
      }
    );

    // create a button to go back
    backButton = new JButton("Back");
    backButton.setBounds(1270, 60, 80, 40);
    backButton.setFont(new Font("Millionaire", Font.BOLD, 16));
    backButton.setForeground(Color.white);
    backButton.setBorder(new LineBorder(Color.WHITE, 3));
    backButton.setBackground(new Color(0, 114, 240));

    backButton.addActionListener(actionEvent -> {
      startFrame.dispose();
      StartScreen.beginScreen.setVisible(true);
    });

    startFrame.setSize(1400, 967);
    // Image for the screen
    backGroundImage =
      new ImageIcon(
        Objects.requireNonNull(
          getClass()
            .getClassLoader()
            .getResource("images/volcanic-cone-Japan-Mount-Fuji.png")
        )
      );

    // muteIcon = new ImageIcon(getClass().getResource());

    // unmuteIcon = new ImageIcon(getClass().getResource());

    JLabel backGround = new JLabel(backGroundImage);

    startFrame.setContentPane(backGround);

    // Add panel
    startPanel = new JPanel();
    startPanel.setBounds(50, 150, 800, 600);
    startPanel.setBackground(new Color(0, 0, 255, 127));
    startPanel.setBorder(BorderFactory.createLineBorder(Color.white, 3));

    // Create buttons

    answerAButton = new JButton(" A: ");
    answerAButton.setBounds(70, 550, 350, 60);
    answerAButton.setFont(new Font("Millionaire", Font.BOLD, 16));
    answerAButton.setForeground(Color.white);
    answerAButton.setBorder(new LineBorder(Color.white, 2));
    answerAButton.setBackground(new Color(14, 34, 159));
    answerAButton.setHorizontalAlignment(SwingConstants.LEFT);
    answerAButton.addActionListener(new Mylistener());
    listButton[0] = answerAButton;

    answerBButton = new JButton(" B: ");
    answerBButton.setBounds(480, 550, 350, 60);
    answerBButton.setFont(new Font("Millionaire", Font.BOLD, 16));
    answerBButton.setForeground(Color.white);
    answerBButton.setBorder(new LineBorder(Color.white, 2));
    answerBButton.setBackground(new Color(8, 38, 71));
    answerBButton.setHorizontalAlignment(SwingConstants.LEFT);
    answerBButton.addActionListener(new Mylistener());
    listButton[1] = answerBButton;

    answerCButton = new JButton(" C: ");
    answerCButton.setBounds(70, 650, 350, 60);
    answerCButton.setFont(new Font("Millionaire", Font.BOLD, 16));
    answerCButton.setForeground(Color.white);
    answerCButton.setBorder(new LineBorder(Color.white, 2));
    answerCButton.setBackground(new Color(14, 34, 159));
    answerCButton.setHorizontalAlignment(SwingConstants.LEFT);
    answerCButton.addActionListener(new Mylistener());
    listButton[2] = answerCButton;

    answerDButton = new JButton(" D: ");
    answerDButton.setBounds(480, 650, 350, 60);
    answerDButton.setFont(new Font("Millionaire", Font.BOLD, 16));
    answerDButton.setForeground(Color.white);
    answerDButton.setBorder(new LineBorder(Color.white, 2));
    answerDButton.setBackground(new Color(14, 34, 159));
    answerDButton.setHorizontalAlignment(SwingConstants.LEFT);
    answerDButton.addActionListener(new Mylistener());
    listButton[3] = answerDButton;

    questionLabel = new JTextArea("\n");
    questionLabel.setLineWrap(true);
    questionLabel.setWrapStyleWord(true);
    questionLabel.setBounds(150, 250, 600, 200);
    questionLabel.setFont(new Font("Millionaire", Font.BOLD, 18));
    questionLabel.setForeground(Color.white);
    questionLabel.setBorder(new LineBorder(Color.white, 2));
    questionLabel.setBackground(new Color(14, 34, 159));
    questionLabel.setOpaque(true);
    questionsAndKeyLists = new QuestionsAndKeyList();

    // sound button set up
    soundImg =
      new ImageIcon(
        Objects.requireNonNull(
          getClass().getClassLoader().getResource("images/music-icon.png")
        )
      );
    // scale the img
    Image img = soundImg.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    ImageIcon scaledSoundImg = new ImageIcon(img); // create new image with the scale image

    // Sound button
    soundButton = new JButton();
    soundButton.setIcon(scaledSoundImg);
    soundButton.setBounds(500, 20, 40, 40);
    soundButton.setFont(new Font("Millionaire", Font.BOLD, 16));
    // soundButton.setForeground(Color.white);
    // soundButton.setBorder(new LineBorder(Color.white, 2));
    //soundButton.setBackground(new Color(14, 34, 159));
    //soundButton.setHorizontalAlignment(SwingConstants.CENTER);
    soundButton.addActionListener(new Mylistener());

    // Timer counter
    counterLable = new JLabel("");
    counterLable.setBounds(85, 180, 50, 50);
    counterLable.setForeground(Color.white);
    counterLable.setHorizontalAlignment(JLabel.CENTER);
    counterLable.setFont(new Font("Arial", Font.BOLD, 24));
    counterLable.setBackground(new Color(14, 34, 159));
    counterLable.setOpaque(true);

    // 50:50
    fifty50Icon =
      new ImageIcon(
        Objects.requireNonNull(
          getClass().getClassLoader().getResource("images/fiftyFifty-icon.png")
        )
      );
    Image img5050 = fifty50Icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    ImageIcon scale5050 = new ImageIcon(img5050);
    fiftyFiftyBtn = new JButton();
    fiftyFiftyBtn.setIcon(scale5050);
    fiftyFiftyBtn.setBounds(550, 20, 40, 40);
    fiftyFiftyBtn.addActionListener(new Mylistener());

    // call relative
    callRelIcon =
      new ImageIcon(
        Objects.requireNonNull(
          getClass().getClassLoader().getResource("images/callRelative-icon.png")
        )
      );
    Image imgcall = callRelIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    ImageIcon scalecallRel = new ImageIcon(imgcall);
    callRelativeBtn = new JButton();
    callRelativeBtn.setIcon(scalecallRel);
    callRelativeBtn.setBounds(600, 20, 40, 40);
    callRelativeBtn.addActionListener(new Mylistener());

    // ask audience
    askAuIcon =
      new ImageIcon(
        Objects.requireNonNull(
          getClass().getClassLoader().getResource("images/askAudience-icon.png")
        )
      );
    Image imgAskAu = askAuIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    ImageIcon scaleAskAu = new ImageIcon(imgAskAu);
    askAudienceBtn = new JButton();
    askAudienceBtn.setIcon(scaleAskAu);
    askAudienceBtn.setBounds(650, 20, 40, 40);
    askAudienceBtn.addActionListener(new Mylistener());
    life = new LifeLines(listButton, currentQuestion);
    disPlay(questionIndex);

    scoreBoard = new JLabel();
    scoreBoard.setText(
      "<html>" +
      "<div style=\"margin-left: 20px;\">" +
      saveScore.getScore().replaceAll("\n", "<br>") +
      "</html>"
    );
    scoreBoard.setVerticalAlignment(JLabel.TOP);
    scoreBoard.setBounds(880, 150, 450, 600);
    scoreBoard.setFont(new Font("Millionaire", Font.BOLD, 18));
    scoreBoard.setForeground(Color.white);
    scoreBoard.setBorder(new LineBorder(Color.white, 2));
    scoreBoard.setBackground(new Color(14, 34, 159));
    scoreBoard.setOpaque(true);

    // add all objects into the frame
    startFrame.add(askAudienceBtn);
    startFrame.add(callRelativeBtn);
    startFrame.add(fiftyFiftyBtn);
    startFrame.add(soundButton);
    startFrame.add(scoreBoard);
    startFrame.add(questionLabel);
    startFrame.add(answerAButton);
    startFrame.add(answerBButton);
    startFrame.add(answerCButton);
    startFrame.add(answerDButton);
    startFrame.add(counterLable);
    startFrame.add(startPanel);
    startFrame.add(backButton);
    startFrame.setResizable(false);
    startFrame.setVisible(true);
  }

  /**
   * This function is using for compare answer between the user answer and the
   * correct answer
   * which take the user choice as a parameter
   * if the answer correct it will move to the next question by adding the index
   * of questionIndex
   * and add 100 points
   *
   * @param choosen String
   */

  public void compareAnswer(String choosen) {
    choosen = choosen.substring(4);
    if (currentQuestion.isCorrect(choosen)) {
      listButton[currentQuestion.correctIdx].setBackground(new Color(51, 255, 51));
      int correct = JOptionPane.showConfirmDialog(
        null,
        "Correct answer, hit ok to continue",
        "Correct Answer",
        JOptionPane.DEFAULT_OPTION
      );
      if (correct == JOptionPane.YES_OPTION) {
        ++questionIndex;
        totalPoint += 100;
        for (JButton jButton : listButton) {
          jButton.setBackground(new Color(14, 34, 159));
        }
        if (questionIndex >= 20) {
          questionIndex = 0;
          questionsAndKeyLists.fetchQuestion();
          saveScore.setScore(playerName, totalPoint);
        }
        disPlay(questionIndex);
      }
      isCorrect = true;
    } else {
      saveScore.setScore(playerName, totalPoint);
      isCorrect = false;
      listButton[currentQuestion.correctIdx].setBackground(new Color(255, 51, 51));
      int play = JOptionPane.showConfirmDialog(
        null,
        "You lose, hit yes to play again, no to exist",
        "You Lose",
        JOptionPane.YES_NO_OPTION
      );
      playAgain(play);
    }
  }

  /**
   * This function take the question index as its parameter and display the
   * current
   * question and answers on the screen
   *
   * @param questionIndex int
   */

  private void disPlay(int questionIndex) {
    getTimer();
    currentQuestion = questionsAndKeyLists.listQuestion[questionIndex];
    life.currentQuestion = currentQuestion;
    System.out.println(
      "Question " + (questionIndex + 1) + "'s answer: " + currentQuestion.answer
    );
    questionLabel.setText("\n  " + (questionIndex + 1) + ". " + currentQuestion.ques);
    for (int i = 0; i < 4; i++) {
      char button = (char) ((char) 65 + i);
      listButton[i].setText(" " + button + ". " + currentQuestion.choice[i]);
      listButton[i].setEnabled(true);
    }
  }

  // get the correct answer
  public String getCorrectAwn() {
    return currentQuestion.answer;
  }

  // setter and getter use for junit test
  public boolean getIsCorrect() {
    return isCorrect;
  }

  public void getTimer() {
    seconds = 21; // set to 20 seconds count down
    if (timer != null) {
      timer.stop();
    }
    timer =
      new Timer(
        1000,
        new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            if (seconds > 0 && startFrame.isVisible()) {
              seconds--;
              counterLable.setText("" + seconds);
            } else {
              if (seconds == 0) {
                int play = JOptionPane.showConfirmDialog(
                  null,
                  "Time out, hit yes to play again, no to xit",
                  "You Lose",
                  JOptionPane.YES_NO_OPTION
                );
                playAgain(play);
                //seconds = 20;
              }
            }
          }
        }
      );
    timer.start();
  }

  /*
    check if user want to play again
    go back to question 1 if user hit yes
    go back to main screen if user press no
  */
  void playAgain(int playAgain) {
    if (playAgain == JOptionPane.YES_OPTION) {
      /*
      questionIndex = 0;
      totalPoint = 0;
      questionsAndKeyLists.fetchQuestion();
      for (JButton jButton : listButton) {
        jButton.setBackground(new Color(14, 34, 159));
      }
      disPlay(questionIndex);
       */
      startFrame.dispose();
      StartScreen startScreen = new StartScreen(beginScreen, backgroundSound, playerName);
    } else {
      startFrame.dispose();
      beginScreen.setVisible(true);
    }
  }

  private class Mylistener implements ActionListener, KeyListener {

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == answerAButton) {
        compareAnswer(answerAButton.getText());
      } else if (e.getSource() == answerBButton) {
        compareAnswer(answerBButton.getText());
      } else if (e.getSource() == answerCButton) {
        compareAnswer(answerCButton.getText());
      } else if (e.getSource() == answerDButton) {
        compareAnswer(answerDButton.getText());
      }
      if (e.getSource() == soundButton) {
        if (isSoundOn) {
          backgroundSound.stopSound();
          isSoundOn = false;
        } else {
          backgroundSound.playSound();
          isSoundOn = true;
        }
      }
      if (e.getSource() == fiftyFiftyBtn) {
        try {
          life.fiftyFifty();
          fiftyFiftyBtn.setEnabled(false);
          startFrame.repaint();
        } catch (Exception exception) {}
      }
      if (e.getSource() == askAudienceBtn) {
        try {
          life.askAudience();
          askAudienceBtn.setEnabled(false);
          startFrame.repaint();
        } catch (Exception exception) {}
      }
      if (e.getSource() == callRelativeBtn) {
        try {
          life.callRelative();
          callRelativeBtn.setEnabled(false);
          startFrame.repaint();
        } catch (Exception exception) {}
      }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
      if (e.getKeyChar() == VK_ENTER) {}
    }

    public void keyReleased(KeyEvent e) {}
  }
}
