import javax.sound.sampled.*;
import java.io.InputStream;

public class AudioPlayer {
    public static void playWelcomeSound() {
        try {
            InputStream audioStream = AudioPlayer.class.getResourceAsStream("/welcome.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioStream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            
            // Let the audio play completely
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            System.out.println("Audio error: " + e.getMessage());
        }
    }
}