import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //tela de interface do app
                new WeatherAppGUI().setVisible(true);
                //System.out.println(WeatherAppGUI.getLocationData("Rio de Janeiro"));
            }
        });
    }
}
