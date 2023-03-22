import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.LineBorder;

import static java.awt.event.KeyEvent.VK_ENTER;
import static javax.swing.UIManager.getString;

public class StartScreen extends JFrame {

	// List of questions and answers
	QuestionsAndKeyList questionsAndKeyLists;
	Question currentQuestion;
	JButton[] listButton;
	// BeginScree
	JFrame beginScreen;

	// Frame
	JFrame startFrame;

	// Panel
	JPanel startPanel;

	// Image
	ImageIcon backGroundImage;

	// Game option icons

	// Buttons for answers
	JButton answerAButton, answerBButton, answerCButton, answerDButton;

	// Buttons for sound options
	JButton soundButton;

	// Question label
	JTextArea questionLabel;

	// total point
	int totalPoint = 0;

	// save userAnswer
	char userAnswer;

	// current question
	int questionIndex = 0;

	// frame
	JTextArea chatFrame;

	boolean isCorrect = false;

	public StartScreen(JFrame beginScreen) {
		listButton = new JButton[4];

		this.beginScreen = beginScreen;

		startFrame = new JFrame();

		startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		startFrame.addWindowListener(new java.awt.event.WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

				System.out.println("CloseButton is working");

				beginScreen.setVisible(true);

			}

		});

		startFrame.setSize(1400, 967);

		// Image for the screen

		backGroundImage = new ImageIcon(getClass().getResource("/Images/volcanic-cone-Japan-Mount-Fuji.png"));

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
		answerBButton.setBackground(new Color(14, 34, 159));
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

		chatFrame = new JTextArea();
		chatFrame.setLineWrap(true);
		chatFrame.setWrapStyleWord(true);
		chatFrame.setBounds(880, 150, 450, 600);
		chatFrame.setFont(new Font("Millionaire", Font.BOLD, 18));
		chatFrame.setForeground(Color.white);
		chatFrame.setBorder(new LineBorder(Color.white, 2));
		chatFrame.setBackground(new Color(14, 34, 159));
		chatFrame.setOpaque(true);
		chatFrame.addKeyListener(new Mylistener());

		disPlay(questionIndex);
		startFrame.add(chatFrame);
		startFrame.add(questionLabel);
		startFrame.add(answerAButton);
		startFrame.add(answerBButton);
		startFrame.add(answerCButton);
		startFrame.add(answerDButton);
		startFrame.add(startPanel);
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
	 * @param correctAnswer
	 */

	public void compareAnswer(String choosen) {

		if (currentQuestion.isCorrect(choosen)) {
			listButton[currentQuestion.correctIdx].setBackground(new Color(51, 255, 51));
			int correct = JOptionPane.showConfirmDialog(null, "Correct answer, hit ok to continue", "Correct Answer",
					JOptionPane.DEFAULT_OPTION);
			if (correct == JOptionPane.YES_OPTION) {
				++questionIndex;
				totalPoint += 100;
				for (JButton jButton : listButton) {
					jButton.setBackground(new Color(14, 34, 159));
				}
				if (questionIndex >= 20) {
					questionIndex = 0;
					questionsAndKeyLists.fetchQuestion();
				}
				disPlay(questionIndex);
			}
			isCorrect = true;
		} else {
			isCorrect = false;
			listButton[currentQuestion.correctIdx].setBackground(new Color(255, 51, 51));
			int playAgain = JOptionPane.showConfirmDialog(null, "You lose, hit yes to play again, no to exist",
					"You Lose", JOptionPane.YES_NO_OPTION);
			if (playAgain == JOptionPane.YES_OPTION) {
				questionIndex = 0;
				totalPoint = 0;
				questionsAndKeyLists.fetchQuestion();
				for (JButton jButton : listButton) {
					jButton.setBackground(new Color(14, 34, 159));
				}
				disPlay(questionIndex);
			} else {
				System.exit(0);
			}
		}
	}

	/**
	 * This function take the question index as its parameter and display the
	 * current
	 * question and answers on the screen
	 * 
	 * @param questionIndex
	 */

	private void disPlay(int questionIndex) {
		currentQuestion = questionsAndKeyLists.listQuestion[questionIndex];
		System.out.println(questionIndex + ": " + currentQuestion.answer);
		questionLabel.setText("\n" + " " + currentQuestion.ques);
		for (int i = 0; i < 4; i++) {
			listButton[i].setText(currentQuestion.choice[i]);
		}
	}

	// setter and getter use for junit test

	public boolean getIsCorrect() {
		return isCorrect;
	}

	private class Mylistener implements ActionListener, KeyListener {
		@Override
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
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == VK_ENTER) {

			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

}
