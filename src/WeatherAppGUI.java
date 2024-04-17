import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGUI extends JFrame {
    public WeatherAppGUI() {
        // ajustar a interface e adicionar um titulo
        super("Weather App"); // Definindo o título diretamente aqui

        // configurar a interface para encerrar o processo do app assim que ele fechar
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //definir o tamanho da interface em pixels
        setSize(450, 650); // Removi os parâmetros width e height

        // carregar a interface
        setLocationRelativeTo(null);

        // definindo como nulo o gerenciamento do layout para posicionar manualmente os componentes
        setLayout(null);

        // evitar redimensionamento da interface
        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents(){
        // campo de pesquisa
        JTextField searchTextField = new JTextField();

        // definir localização e o tamanho do componente
        searchTextField.setBounds(15, 15, 351, 45);

        // mudar o estilo de fonte e tamanho
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTextField);

        //botão de procurar
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));

        // alterando o cursor ao passar o mouse sobre o botão
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        add(searchButton);

        // texto de temperatura
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));

        // Imagem do app
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0, 125,450,217);
        add(weatherConditionImage);

        // centralizando texto
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        // descrição das condições do tempo
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0,405,450,36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        // imagem da umidade
        JLabel humidityImage = new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15,500,74,66);
        add(humidityImage);

        // texto da umidade
        JLabel humidityText = new JLabel("<html><b>Umidade</b> 100%</html>");
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        // imagem da velocidade do ar
        JLabel windspeedImage = new JLabel(loadImage("src/assets/windspeed.png"));
        windspeedImage.setBounds(220,500,74,66);
        add(windspeedImage);

        // texto da velocidade do ar
        JLabel windspeedText = new JLabel("<html><b>Vel. do ar</b> 15km</html>");
        windspeedText.setBounds(310,500,85,55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);
    }

    private ImageIcon loadImage(String resourcePath){
        try{
            //Ler o arquivo de imagem
            BufferedImage image = ImageIO.read(new File(resourcePath));

            //retornar um icone da imagem
            return new ImageIcon(image);
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Could not find resource");
        return null;
    }
}
