package pro.tremblay.app;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting app");
        JFrame frame = new JFrame("Test") {
            @Override
            public void dispose() {
                System.out.println("Dispose");
                super.dispose();
            }
        };
        frame.setName("Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
