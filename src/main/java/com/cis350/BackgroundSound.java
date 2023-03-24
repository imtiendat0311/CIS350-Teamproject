package com.cis350;

import java.io.File;
import java.nio.file.FileSystemNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BackgroundSound {

  private Clip clip;

  public void playSound() {
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
        new File("src/main/" + "resources/sound/silent-wood.wav").getAbsoluteFile()
      );
      clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      throw new FileSystemNotFoundException("Could not find file");
    }
  }

  public void stopSound() {
    if (clip != null) {
      clip.stop();
    }
  }

  public static void main(String[] arg) {
    new BackgroundSound().playSound();
  }
}
