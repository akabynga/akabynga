package com.akabynga.swing;

import javax.swing.*;
import java.awt.*;

public class DrawRectangle extends JPanel {
    private Rectangle rect;

    private Color background;
    private Color color;

    public DrawRectangle() {
        rect = new Rectangle(10, 20, 30, 40);
    }

    public DrawRectangle(int x, int y, int w, int h) {
        rect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (color == null) {
            color = new Color(37, 215, 150);
        }
        if (background == null) {
            background = new Color(37, 215, 150);
        }
        g2.setBackground(background);
        g2.setColor(color);
        g2.fillRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
        g2.draw(rect);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBackground(Color background) {
        this.background = background;
    }
}