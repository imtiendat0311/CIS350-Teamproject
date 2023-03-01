import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JUnitTest {

	private BeginScreen beginScreen;
	private StartScreen startScreen;

	@Before
	public void setUp() {
		beginScreen = new BeginScreen();
		JFrame beginScreen = new JFrame();
        startScreen = new StartScreen(beginScreen);
	}

	@Test
	public void testStartGameButton() {
		JButton startGameButton = beginScreen.getStartGameButton();
		assertNotNull("Start game button is null", startGameButton);
		assertTrue("Start game button is not enabled", startGameButton.isEnabled());
		ActionEvent actionEvent = new ActionEvent(startGameButton, ActionEvent.ACTION_PERFORMED, "");
		startGameButton.getActionListeners()[0].actionPerformed(actionEvent);
		assertFalse("Frame is not invisible after clicking start game button", beginScreen.getFrame().isVisible());
	}

	@Test
	public void testHelpButton() {
		JButton helpButton = beginScreen.getHelpButton();
		assertNotNull("Help button is null", helpButton);
		assertTrue("Help button is not enabled", helpButton.isEnabled());
		ActionEvent actionEvent = new ActionEvent(helpButton, ActionEvent.ACTION_PERFORMED, "");
		helpButton.getActionListeners()[0].actionPerformed(actionEvent);
		assertFalse("Frame is not invisible after clicking help button", beginScreen.getFrame().isVisible());
	}

	@Test
	public void testAboutButton() {
		JButton aboutButton = beginScreen.getAboutButton();
		assertNotNull("About button is null", aboutButton);
		assertTrue("About button is not enabled", aboutButton.isEnabled());
		ActionEvent actionEvent = new ActionEvent(aboutButton, ActionEvent.ACTION_PERFORMED, "");
		aboutButton.getActionListeners()[0].actionPerformed(actionEvent);
		assertFalse("Frame is not invisible after clicking about button", beginScreen.getFrame().isVisible());
	}
	
	@Test
	public void testCompareAnswerCorrect() {
        startScreen.questionsAndKeyLists = new QuestionsAndKeyList();
        startScreen.questionsAndKeyLists.question.get(0);
        startScreen.userAnswer = 'A';
        startScreen.compareAnswer('A');
        assertTrue("This fuction Is working well", startScreen.getIsCorrect());
        assertFalse("Some issue happened, please check this function again", startScreen.getIsCorrect());
    }

    @Test
    public void testCompareAnswerIncorrect() {
        startScreen.questionsAndKeyLists = new QuestionsAndKeyList();
        startScreen.questionsAndKeyLists.question.get(0);
        startScreen.userAnswer = 'A';
        startScreen.compareAnswer('B');
        assertTrue("Some issue happened, please check this function again", startScreen.getIsCorrect());
        assertFalse("This fuction Is working well", startScreen.getIsCorrect());
    }
}