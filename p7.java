import javax.swing.*;
import java.awt.*;

public class OlympicRings extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set background color to gray
        setBackground(Color.LIGHT_GRAY);

        drawCircle(g, Color.BLUE, 100, 100, 50, 5);
        drawCircle(g, Color.BLACK, 210, 100, 50, 5);
        drawCircle(g, Color.RED, 320, 100, 50, 5);
        drawCircle(g, Color.YELLOW, 155, 150, 50, 5);
        drawCircle(g, Color.GREEN, 265, 150, 50, 5);
    }

    // Bresenham's circle drawing algorithm
    private void drawCircle(Graphics g, Color color, int centerX, int centerY, int radius, int thickness) {
        g.setColor(color);

        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;

        while (x <= y) {
            for (int i = 0; i < thickness; i++) {
                drawPixel(g, centerX, centerY, x + i, y);
                drawPixel(g, centerX, centerY, x - i, y);
                drawPixel(g, centerX, centerY, x, y + i);
                drawPixel(g, centerX, centerY, x, y - i);
                drawPixel(g, centerX, centerY, y + i, x);
                drawPixel(g, centerX, centerY, y - i, x);
                drawPixel(g, centerX, centerY, y + i, -x);
                drawPixel(g, centerX, centerY, y - i, -x);
            }

            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    private void drawPixel(Graphics g, int centerX, int centerY, int x, int y) {
        g.drawLine(centerX + x, centerY + y, centerX + x, centerY + y);
        g.drawLine(centerX - x, centerY + y, centerX - x, centerY + y);
        g.drawLine(centerX + x, centerY - y, centerX + x, centerY - y);
        g.drawLine(centerX - x, centerY - y, centerX - x, centerY - y);
        g.drawLine(centerX + y, centerY + x, centerX + y, centerY + x);
        g.drawLine(centerX - y, centerY + x, centerX - y, centerY + x);
        g.drawLine(centerX + y, centerY - x, centerX + y, centerY - x);
        g.drawLine(centerX - y, centerY - x, centerX - y, centerY - x);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Olympic Rings");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new OlympicRings());
            frame.setSize(480, 270);
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
    }
}
