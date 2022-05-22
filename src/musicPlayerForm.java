import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class musicPlayerForm extends JFrame {
    static musicPlayer player = musicPlayer.getInstance();
    static String filepath = "PSI-Missing.wav";
    static long clipTimePosition;
    static boolean isPlaying = true;
    static boolean isLooping = false;
    private JPanel PlayerPanel;
    private JTextField filepathTextField;
    private JButton loadButton;
    private JButton playButton;
    private JButton pauseButton;
    private JButton loopButton;
    //private JButton testButton;
    private JLabel Looping;
    private JLabel IsPlaying;
    private JLabel PlayState;
    private JLabel LoopState;
    private JLabel LoadState;
    private JLabel Info;
    private JLabel LoadInfo;
    private JButton setToFalseButton;
    private boolean loaded;


    public musicPlayerForm() {
        loaded = false;
        setContentPane(PlayerPanel);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    clipTimePosition = player.clip.getMicrosecondPosition();
                    player.clip.stop();
                    pauseButton.setText("Resume");
                } else {
                    player.clip.setMicrosecondPosition(clipTimePosition);
                    player.clip.start();
                    pauseButton.setText("Pause");
                }
                isPlaying = !isPlaying;
                IsPlaying.setText(String.valueOf(isPlaying));
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.clip.setMicrosecondPosition(0);
                clipTimePosition = 0;
                player.clip.start();
                IsPlaying.setText(String.valueOf(isPlaying));
            }
        });
        loopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isLooping) {
                    player.clip.loop(Clip.LOOP_CONTINUOUSLY);
                } else {
                    player.clip.loop(0);
                }
                isLooping = !isLooping;
                Looping.setText(String.valueOf(isLooping));
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filepath = String.valueOf(filepathTextField.getText());
                if (loaded == true){
                    player.clip.stop();
                    player.clip.setMicrosecondPosition(0);
                    clipTimePosition = 0;
                }
                LoadState.setText("Loaded");
                player.loadMusic(filepath);
                LoadState.setText("Loaded");
                loaded = true;
            }
        });

        setToFalseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loaded = false;
            }
        });
    }

}