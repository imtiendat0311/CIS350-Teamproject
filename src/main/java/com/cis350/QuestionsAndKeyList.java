package com.cis350;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.text.*;
import org.json.*;

class QuestionsAndKeyList {

  public Question[] listQuestion;

  public QuestionsAndKeyList() {
    listQuestion = new Question[20];
    fetchQuestion();
  }

  public void fetchQuestion() {
    try {
      String inline = "";
      URL url = new URL("https://opentdb.com/api.php?amount=20&type=multiple&");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      con.connect();
      Scanner scan = new Scanner(url.openStream());
      while (scan.hasNext()) {
        inline += scan.nextLine();
      }
      scan.close();
      JSONObject obj = new JSONObject(inline);
      JSONArray arr = obj.getJSONArray("results");
      for (int i = 0; i < arr.length(); i++) {
        String question = StringEscapeUtils.unescapeHtml4(
          arr.getJSONObject(i).getString("question")
        );
        String correctAns = StringEscapeUtils.unescapeHtml4(
          arr.getJSONObject(i).getString("correct_answer")
        );
        JSONArray choice = arr.getJSONObject(i).getJSONArray("incorrect_answers");
        String[] listChoice = new String[4];
        for (int j = 0; j < choice.length(); j++) {
          listChoice[j] = StringEscapeUtils.unescapeHtml4(choice.getString(j));
        }
        listChoice[3] = correctAns;
        Question temp = new Question(question, shuffle(listChoice), correctAns);
        listQuestion[i] = temp;
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String[] shuffle(String[] arr) {
    Random rand = new Random();
    for (int i = 0; i < arr.length; i++) {
      int randomIndexToSwap = rand.nextInt(arr.length);
      String temp = arr[randomIndexToSwap];
      arr[randomIndexToSwap] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }
}
