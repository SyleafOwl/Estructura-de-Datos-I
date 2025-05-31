import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlaylistGUI extends JFrame {
    private CircularListDouble playlist;
    private JLabel songLabel;
    private JButton nextButton;
    private JButton previousButton;

    public PlaylistGUI() {
        setTitle("🎬 Circular Playlist");
        setSize(480, 360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        playlist = new CircularListDouble(); //Create a new CircularList instance
        loadSongs(); // Load some songs into the playlist

        songLabel = new JLabel("Current song: " + playlist.getCurrentSong(), JLabel.CENTER);
        songLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton = new JButton("▶ Next");
        previousButton = new JButton("◁ Previous");

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO
                String name = playlist.nextSong();
                songLabel.setText("Current song: " + name);
            }
        });

        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO
                String name = playlist.previousSong();
                songLabel.setText("Current song: " + name);
            }
        });

        add(songLabel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.NORTH);
        add(previousButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadSongs() {
        playlist.add("🎵 Yesterday");
        playlist.add("🎵 Imagine");
        playlist.add("🎵 Let It Be");
        playlist.add("🎵 Bohemian Rhapsody");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlaylistGUI());
    }
}