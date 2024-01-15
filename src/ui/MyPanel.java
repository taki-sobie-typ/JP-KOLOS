package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    Canva canva;
    JLabel jLabel = new JLabel("Klikjin aby dodać");
    JButton dwojnikButton = new JButton("Dwójnik");

    MyPanel(Canva canva){
        this.setLayout(new FlowLayout());
        this.add(jLabel);

        this.canva = canva;

        this.add(dwojnikButton);
        dwojnikButton.setFocusable(false);
        dwojnikButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canva.addDwojnik();
    }
}
