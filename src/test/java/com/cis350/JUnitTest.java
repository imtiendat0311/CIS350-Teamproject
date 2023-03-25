package com.cis350;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {

  private BeginScreen beginScreen;
  private StartScreen startScreen;

  @Before
  public void setUp() {
    beginScreen = new BeginScreen();
    JFrame beginScreen = new JFrame();
    BackgroundSound backgroundSound = new BackgroundSound();
    startScreen = new StartScreen(beginScreen, backgroundSound, "Admin");
  }

  @Test
  public void testStartGameButton() {
    JButton startGameButton = beginScreen.getStartGameButton();
    assertNotNull("Start game button is null", startGameButton);
    assertTrue("Start game button is not enabled", startGameButton.isEnabled());
    ActionEvent actionEvent = new ActionEvent(
      startGameButton,
      ActionEvent.ACTION_PERFORMED,
      ""
    );
    startGameButton.getActionListeners()[0].actionPerformed(actionEvent);
    assertFalse(
      "Frame is not invisible after clicking start game button",
      beginScreen.getFrame().isVisible()
    );
  }

  @Test
  public void testHelpButton() {
    JButton helpButton = beginScreen.getHelpButton();
    assertNotNull("Help button is null", helpButton);
    assertTrue("Help button is not enabled", helpButton.isEnabled());
    ActionEvent actionEvent = new ActionEvent(
      helpButton,
      ActionEvent.ACTION_PERFORMED,
      ""
    );
    helpButton.getActionListeners()[0].actionPerformed(actionEvent);
    assertFalse(
      "Frame is not invisible after clicking help button",
      beginScreen.getFrame().isVisible()
    );
  }

  @Test
  public void testAboutButton() {
    JButton aboutButton = beginScreen.getAboutButton();
    assertNotNull("About button is null", aboutButton);
    assertTrue("About button is not enabled", aboutButton.isEnabled());
    ActionEvent actionEvent = new ActionEvent(
      aboutButton,
      ActionEvent.ACTION_PERFORMED,
      ""
    );
    aboutButton.getActionListeners()[0].actionPerformed(actionEvent);
    assertFalse(
      "Frame is not invisible after clicking about button",
      beginScreen.getFrame().isVisible()
    );
  }

  @Test
  public void testCompareAnswerCorrect() {
    startScreen.questionsAndKeyLists = new QuestionsAndKeyList();
    Question currQuestion = startScreen.questionsAndKeyLists.listQuestion[0];
    startScreen.userAnswer = currQuestion.choice[currQuestion.correctIdx];
    startScreen.compareAnswer(startScreen.userAnswer);
    assertTrue("This fuction Is working well", startScreen.getIsCorrect());
    assertFalse(
      "Some issue happened, please check this function again",
      startScreen.getIsCorrect()
    );
  }

  @Test
  public void testCompareAnswerIncorrect() {
    startScreen.questionsAndKeyLists = new QuestionsAndKeyList();
    Question currQuestion = startScreen.questionsAndKeyLists.listQuestion[0];
    int a = currQuestion.correctIdx;
    Random rand = new Random();
    while (a == currQuestion.correctIdx) {
      a = rand.nextInt(currQuestion.choice.length);
    }
    startScreen.userAnswer = currQuestion.choice[a];
    startScreen.compareAnswer(startScreen.userAnswer);
    assertTrue(
      "Some issue happened, please check this function again",
      startScreen.getIsCorrect()
    );
    assertFalse("This fuction Is working well", startScreen.getIsCorrect());
  }
}
