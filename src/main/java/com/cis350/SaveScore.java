package com.cis350;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class SaveScore {

  int score;
  Scanner scanner;
  String playerName;
  File file;
  FileWriter fileWriter;
  PrintWriter printWriter;

  public SaveScore() {
    try {
      file = new File("src/main/resources/save/high-score.txt").getAbsoluteFile();
      fileWriter = new FileWriter(file, true);
      printWriter = new PrintWriter(fileWriter);
    } catch (Exception e) {
      throw new FileSystemNotFoundException("Could not find file");
    }
  }

  public void setScore(String playerName, int score) {
    this.playerName = playerName;
    this.score = score;
    checkScore();
  }

  public String getScore() {
    String score = "";
    try {
      scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        score += scanner.nextLine() + "\n";
      }
      scanner.close();
    } catch (Exception e) {
      return null;
    }
    return score;
  }

  private void checkScore() {
    if (score >= 500) {
      printWriter.println(playerName + " " + score);
      printWriter.close();
    }
  }
}
