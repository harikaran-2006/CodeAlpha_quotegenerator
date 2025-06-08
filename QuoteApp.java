import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class QuoteApp {

    private JFrame frame;
    private JLabel quoteLabel;
    private JLabel authorLabel;
    private JButton newQuoteButton;

    private Quote[] quotes = {
        new Quote("The best way to predict the future is to invent it.", "Alan Kay"),
        new Quote("Life is 10% what happens to us and 90% how we react to it.", "Charles R. Swindoll"),
        new Quote("Do not watch the clock. Do what it does. Keep going.", "Sam Levenson"),
        new Quote("Keep your face always toward the sunshine—and shadows will fall behind you.", "Walt Whitman"),
        new Quote("Believe you can and you're halfway there.", "Theodore Roosevelt")
    };

    private Random random = new Random();

    public QuoteApp() {
        frame = new JFrame("Random Quote Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        quoteLabel = new JLabel("", SwingConstants.CENTER);
        quoteLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
        quoteLabel.setForeground(Color.DARK_GRAY);
        quoteLabel.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));
        quoteLabel.setVerticalAlignment(SwingConstants.CENTER);
        quoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quoteLabel.setPreferredSize(new Dimension(480, 100));
        quoteLabel.setOpaque(false);
        quoteLabel.setText("<html><div style='text-align: center;'></div></html>");  // allow multiline & center

        authorLabel = new JLabel("", SwingConstants.CENTER);
        authorLabel.setFont(new Font("Helvetica", Font.ITALIC, 12));
        authorLabel.setForeground(Color.GRAY);
        authorLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        newQuoteButton = new JButton("New Quote");
        newQuoteButton.setBackground(new Color(76, 175, 80));
        newQuoteButton.setForeground(Color.WHITE);
        newQuoteButton.setFocusPainted(false);
        newQuoteButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        newQuoteButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        newQuoteButton.addActionListener(e -> showRandomQuote());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(quoteLabel, BorderLayout.CENTER);
        centerPanel.add(authorLabel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(newQuoteButton);

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        showRandomQuote();

        frame.setLocationRelativeTo(null);  // center window
        frame.setVisible(true);
    }

    private void showRandomQuote() {
        Quote q = quotes[random.nextInt(quotes.length)];
        // Wrap text for multiline and center
        String htmlText = "<html><div style='text-align: center;'>" + q.text + "</div></html>";
        quoteLabel.setText(htmlText);
        authorLabel.setText("- " + q.author);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuoteApp::new);
    }

    static class Quote {
        String text;
        String author;

        public Quote(String text, String author) {
            this.text = text;
            this.author = author;
        }
    }
}
