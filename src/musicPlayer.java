import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class musicPlayer {
    static Clip clip;

    static musicPlayer player = new musicPlayer();

    private musicPlayer(){

    }

    public static musicPlayer getInstance(){
        return player;
    }

    public static void loadMusic(String filepath){
        try
        {
            File musicPath = new File(filepath);
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                System.out.println("Initialized");
            }
        }
        catch(Exception e)
        {
            System.out.println("ERROR" + e);
        }
    }

}
