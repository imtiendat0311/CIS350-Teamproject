public class Question {

  public String ques;
  public String[] choice;
  public String answerA;
  public String answerB;
  public String answerC;
  public String answerD;
  public String answer;
  public int correctIdx;

  public Question(String ques, String[] choice, String ans) {
    this.ques = ques;
    this.choice = choice;
    this.answerA = choice[0];
    this.answerB = choice[1];
    this.answerC = choice[2];
    this.answerD = choice[3];
    this.answer = ans;
    this.correctIdx =
      this.answerA.equals(ans)
        ? 0
        : this.answerB.equals(ans) ? 1 : this.answerC.equals(ans) ? 2 : 3;
  }

  public boolean isCorrect(String select) {
    return select.equals(answer);
  }
}
