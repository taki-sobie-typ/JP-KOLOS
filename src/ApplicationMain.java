import javax.swing.*;
import ui.MyFrame;

public class ApplicationMain {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->{
            MyFrame myFrame = new MyFrame(700,700);
            myFrame.setVisible(true);
        });
    }
}