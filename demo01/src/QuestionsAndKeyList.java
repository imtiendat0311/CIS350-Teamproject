import java.util.ArrayList;
import java.util.List;

class QuestionsAndKeyList {
	public List<String> question;
	public List<String> answerA;
	public List<String> answerB;
	public List<String> answerC;
	public List<String> answerD;
	public List<Character> correctAnswer;
	public QuestionsAndKeyList() {

		question = new ArrayList<>();
		answerA = new ArrayList<>();
		answerB = new ArrayList<>();
		answerC = new ArrayList<>();
		answerD = new ArrayList<>();
		correctAnswer = new ArrayList<>();

		// question 1
		question.add(0, "Where is the capital of Germany ?");
		answerA.add(0, "Berlin");
		answerB.add(0, "Ha Noi");
		answerC.add(0, "Soc Trang");
		answerD.add(0, "Washington, D.C.");
		correctAnswer.add(0, 'A');

		// question 2
		question.add(1, "What does the fox say ?");
		answerA.add(1, "meow");
		answerB.add(1, "woof");
		answerC.add(1, "bonjour");
		answerD.add(1, "...");
		correctAnswer.add(1, 'D');

		// question 3
		question.add(2,"First president of the United State of America");
		answerA.add(2, "Abraham Lincoln");
		answerB.add(2, "George Washington");
		answerC.add(2, "Sky Walker");
		answerD.add(2, "Jackie Chan");
		correctAnswer.add(2, 'B');

		// question 4
		question.add(3,"What year did the television show \"Who Wants to Be a Millionaire?\" first air in the United States?");
		answerA.add(3, "1999");
		answerB.add(3, "2000");
		answerC.add(3, "2001");
		answerD.add(3, "2002");
		correctAnswer.add(3, 'A');

		// question 5
		question.add(4,"Who is the host of the US version of \"Who Wants to Be a Millionaire?\"");
		answerA.add(4, "Regis PhilbinI");
		answerB.add(4, "Meredith Vieira");
		answerC.add(4, "Regis Philbin");
		answerD.add(4, "Cedric the Entertainer");
		correctAnswer.add(4, 'C');

		// question 6
		question.add(5,"What is the highest amount ever won on the UK version of \"Who Wants to Be a Millionaire?\"");
		answerA.add(5, "1 million");
		answerB.add(5, "2 million");
		answerC.add(5, "3 million");
		answerD.add(5, "4 million");
		correctAnswer.add(5, 'A');

		// question 7
		question.add(6,"In what country did the game show \"Who Wants to Be a Millionaire?\" originate?");
		answerA.add(6, "France");
		answerB.add(6, "United State of America");
		answerC.add(6, "The United Kingdom");
		answerD.add(6, "Sweden");
		correctAnswer.add(6, 'C');

		// question 8
		question.add(7, "What type of device is used to measure temperature?");
		answerA.add(7, "Oscilloscope");
		answerB.add(7, "Voltmeter");
		answerC.add(7, "Thermometer");
		answerD.add(7, "Ammeter");
		correctAnswer.add(7, 'C');

		// question 9
		question.add(8, "What is the capital city of Australia?");
		answerA.add(8, "Sydney");
		answerB.add(8, "Melbourne");
		answerC.add(8, "Brisbane");
		answerD.add(8, "Canberra");
		correctAnswer.add(8, 'D');

		// question 10
		question.add(9, "What is the smallest country in the world by land area?");
		answerA.add(9, "Monaco");
		answerB.add(9, "Nauru");
		answerC.add(9, "Tuvalu");
		answerD.add(9, "San Marino");
		correctAnswer.add(9, 'A');

		// question 11
		question.add(10, "Which planet is known as the \"Red Planet\"?");
		answerA.add(10, "Jupiter");
		answerB.add(10, "Saturn");
		answerC.add(10, "Mars");
		answerD.add(10, "Venus");
		correctAnswer.add(10, 'C');

		// question 12
		question.add(11, "What is the largest ocean in the world?");
		answerA.add(11, "Indian Ocean");
		answerB.add(11, "Atlantic Ocean");
		answerC.add(11, "Arctic Ocean");
		answerD.add(11, "Pacific Ocean");
		correctAnswer.add(11, 'D');

		// question 13
		question.add(12, "Which famous scientist discovered gravity?");
		answerA.add(12, "Isaac Newton");
		answerB.add(12, "Albert Einstein");
		answerC.add(12, "Galileo Galilei");
		answerD.add(12, "Nikola Tesla");
		correctAnswer.add(12, 'A');

		// question 14
		question.add(13, "Which of the following is a programming language?");
		answerA.add(13, "Java");
		answerB.add(13, "Python");
		answerC.add(13, "HTML");
		answerD.add(13, "All of the above");
		correctAnswer.add(13, 'D');

		// question 15
		question.add(14, "Which country hosted the Summer Olympics in 2016?");
		answerA.add(14, "London");
		answerB.add(14, "Beijing");
		answerC.add(14, "Rio de Janeiro");
		answerD.add(14, "Tokyo");
		correctAnswer.add(14, 'C');

		// question 16
		question.add(15, "What is the chemical symbol for gold?");
		answerA.add(15, "Ag");
		answerB.add(15, "Au");
		answerC.add(15, "Al");
		answerD.add(15, "Fe");
		correctAnswer.add(15, 'B');

		// question 17
		question.add(16, "What is the capital of Spain?");
		answerA.add(16, "Madrid");
		answerB.add(16, "Barcelona");
		answerC.add(16, "Valencia");
		answerD.add(16, "Seville");
		correctAnswer.add(16, 'A');

		// question 18
		question.add(17, "What is the currency of Japan?");
		answerA.add(17, "Yen");
		answerB.add(17, "Dollar");
		answerC.add(17, "Euro");
		answerD.add(17, "Won");
		correctAnswer.add(17, 'A');

		// question 19
		question.add(18, "What is the most abundant gas in Earth's atmosphere?");
		answerA.add(18, "Oxygen");
		answerB.add(18, "Nitrogen");
		answerC.add(18, "Carbon dioxide");
		answerD.add(18, "Argon");
		correctAnswer.add(18, 'B');

		// question 20
		question.add(19, "What is the smallest planet in our solar system?");
		answerA.add(19, "Mars");
		answerB.add(19, "Mercury");
		answerC.add(19, "Venus");
		answerD.add(19, "Pluto");
		correctAnswer.add(19, 'B');
		
	
	}
}