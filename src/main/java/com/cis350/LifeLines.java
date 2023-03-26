package com.cis350;

import java.io.IOException;
import java.util.*;
import javax.swing.*;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONObject;

public class LifeLines {

  final String apiKey = "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";
  final String model = "gpt-3.5-turbo-0301";

  //all lifeline's options
  //JButton fiftyFiftyBtn, callRelativeBtn, askAudienceBtn;
  //ImageIcon fifty50Icon, callRelIcon, askAuIcon;
  //create object
  Question currentQuestion;
  int correctIdx;
  JButton[] listButton;
  String responde = "";

  public LifeLines(JButton[] listButton, Question currentQuestion) {
    this.listButton = listButton;
    this.currentQuestion = currentQuestion;
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
    // int[] choose = new int[4];
    // Random rand = new Random();
    // int randomNum = rand.nextInt(4);
    // for (int i = 0; i < 4; ++i) {
    //   listButton[i].setText((i != randomNum) ? "" : "Your mom wants you to choose this!");
    //   listButton[i].setEnabled(i == randomNum);
    // }
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpPost = new HttpPost("https://api.openai.com/v1/chat/completions");

    httpPost.setHeader("Content-Type", "application/json");
    httpPost.setHeader("Authorization", "Bearer " + this.apiKey);
    String prompt =
      "Which is the correct answer for question : " +
      this.currentQuestion.ques +
      "\n answerA : " +
      this.currentQuestion.answerA +
      "\n answerB : " +
      this.currentQuestion.answerB +
      "\n answerC : " +
      this.currentQuestion.answerC +
      "\n answerD : " +
      this.currentQuestion.answerD;
    JSONObject body = new JSONObject();
    body.put("model", model);

    JSONArray a = new JSONArray();
    JSONObject b = new JSONObject();
    b.put("role", "user");
    b.put("content", prompt);
    a.put(b);
    body.put("messages", a);
    StringEntity entity = new StringEntity(body.toString());
    httpPost.setEntity(entity);
    try {
      HttpClientResponseHandler<String> responseHandler = new HttpClientResponseHandler<String>() {
        @Override
        public String handleResponse(ClassicHttpResponse response)
          throws HttpException, IOException {
          String responseBody = EntityUtils.toString(response.getEntity());
          JSONObject jsonResponse = new JSONObject(responseBody);
          String completions = jsonResponse
            .getJSONArray("choices")
            .getJSONObject(0)
            .getJSONObject("message")
            .getString("content");
          setResponse(completions);
          return completions;
        }
      };
      httpClient.execute(httpPost, responseHandler);
      System.out.println(this.responde);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        httpClient.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void setResponse(String response) {
    this.responde = response;
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
