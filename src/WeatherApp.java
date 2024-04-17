import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {

    public static JSONObject getWeatherData(String locationName) {
        // obtendo as coordenadas de localização usando API
        JSONArray locationData = getLocationData(locationName);

        return null;
    }

    public static JSONArray getLocationData(String locationName) {
        // Substituindo qualquer espaço entre o nome dos lugares por + para aderir ao formato da request
        locationName = locationName.replaceAll(" ", "+");

        // construindo a url
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" + locationName + "&count=10&language=en&format=json";

        try {
            // obtendo a resposta da api
            HttpURLConnection conn = fetchApiResponse(urlString);

            // checando o status de resposta
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro: Sem conexão com a API");
                return null;
            } else {
                // registrar os resultados da API
                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());
                while (scanner.hasNext()) {
                    resultJson.append(scanner.nextLine());
                }
                scanner.close();
                conn.disconnect();

                JSONParser parser = new JSONParser();
                JSONObject resultsJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                // obtendo  lista de dados das localizações geradas pela API a partir do nome do local
                JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
                return locationData;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpURLConnection fetchApiResponse(String urlString) {
        try {
            // criando conexão
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // definindo metodo get
            conn.setRequestMethod("GET");

            //conectando na API
            conn.connect();
            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
