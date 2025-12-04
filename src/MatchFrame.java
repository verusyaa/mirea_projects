import javax.swing.*;
import java.awt.*;

public class MatchFrame extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;

    private JLabel lblScore;
    private JLabel lblLast;
    private JLabel lblWinner;

    public MatchFrame() {
        super("Match Result");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        JButton btnMilan = new JButton("AC Milan");
        JButton btnMadrid = new JButton("Real Madrid");
        buttonsPanel.add(btnMilan);
        buttonsPanel.add(btnMadrid);

        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        lblScore = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        lblLast = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        lblWinner = new JLabel("Winner: DRAW", SwingConstants.CENTER);

        infoPanel.add(lblScore);
        infoPanel.add(lblLast);
        infoPanel.add(lblWinner);

        add(buttonsPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);

        btnMilan.addActionListener(e -> updateScore(true));
        btnMadrid.addActionListener(e -> updateScore(false));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateScore(boolean milan) {
        if (milan) {
            milanScore++;
            lblLast.setText("Last Scorer: AC Milan");
        } else {
            madridScore++;
            lblLast.setText("Last Scorer: Real Madrid");
        }

        lblScore.setText("Result: " + milanScore + " X " + madridScore);

        if (milanScore > madridScore) lblWinner.setText("Winner: AC Milan");
        else if (madridScore > milanScore) lblWinner.setText("Winner: Real Madrid");
        else lblWinner.setText("Winner: DRAW");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MatchFrame());
    }
}
