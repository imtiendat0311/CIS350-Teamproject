package com.cis350;

import javax.swing.*;
import java.util.ArrayList;
import java.util.*;

public class LifeLines extends JFrame  {

    // create object
    QuestionsAndKeyList quesAndKey;
    StartScreen startScr;

    public LifeLines(){
        fiftyFifty(startScr.listButton); // 50:50
    }

    public void fiftyFifty(JButton listButton[]){
        List<JButton> incorrectAnswers = new ArrayList<>();
        for(JButton button: listButton){
            /*
                check if current button's text is not equal to the correct answer
                push or add that current button into incorrectAnswers
                -------------------------
                if (button.getText().equals(correctAnswer)){
                    incorrectAnswers.add(button);
                }
            */
        }

        Collections.shuffle(incorrectAnswers); // shuffle wrong answer
        // eliminate first two wrong answer after shuffle
        incorrectAnswers.get(0).setEnabled(false);
        incorrectAnswers.get(1).setEnabled(false);

    }


}
