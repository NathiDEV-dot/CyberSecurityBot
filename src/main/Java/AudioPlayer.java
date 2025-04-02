import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class AudioPlayer {
    public static void playWelcomeSound() {
        try {
            // Method 1: Load from compiled JAR
            URL jarUrl = AudioPlayer.class.getResource("/welcome.wav");
            if (jarUrl != null) {
                playAudio(jarUrl);
                return;
            }

            // Method 2: Load from filesystem (for development)
            File devFile = new File("src/main/resources/welcome.wav");
            if (devFile.exists()) {
                playAudio(devFile.toURI().toURL());
                return;
            }

            System.out.println("Audio file not found in JAR or filesystem");
        } catch (Exception e) {
            System.out.println("Audio error: " + e.getMessage());
        }
    }

    private static void playAudio(URL audioUrl) throws Exception {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioUrl);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
        Thread.sleep(clip.getMicrosecondLength() / 1000);
        clip.close();
    }
}