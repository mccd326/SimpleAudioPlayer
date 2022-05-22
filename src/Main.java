import javax.swing.*;

public class Main {
    public static void main(String[] args){
        musicPlayerForm musicPlayerForm = new musicPlayerForm();
        musicPlayerForm.setVisible(true);
        musicPlayerForm.setTitle("Music Player");
        musicPlayerForm.setBounds(300,300,700,600);
        musicPlayerForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        musicPlayer Player = musicPlayer.getInstance();
    }
}
