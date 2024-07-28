/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package YahooFinance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.SwingUtilities;

public class GetStocks {

    public void getStockQuotes(String symbol, String region, String language, StockQuoteCallback callback) {
        // Use a separate thread for network operations to avoid blocking the UI
        new Thread(() -> {
            HttpURLConnection connection = null;
            try {
                URL url = new URL("https://yh-finance.p.rapidapi.com/stock/get-company-outlook?symbol=" + symbol + "&region=" + region + "&lang=" + language);
                connection = (HttpURLConnection) url.openConnection();
                  connection.setRequestMethod("GET");
                connection.setRequestProperty("apply header here", "WHAT ARE YOU LOOKING FOR?");
                connection.setRequestProperty("x-rapidapi-host", "yh-finance.p.rapidapi.com");
                
                

                int statusCode = connection.getResponseCode();
                System.out.println("Response Code: " + statusCode);

                if (statusCode == HttpURLConnection.HTTP_OK) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        String inputLine;
                        StringBuilder response = new StringBuilder();

                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }

                        // Notify the callback on the Event Dispatch Thread
                        String responseData = response.toString();
                        SwingUtilities.invokeLater(() -> callback.onSuccess(responseData));
                    }
                } else {
                    String errorMessage = connection.getResponseMessage();
                    SwingUtilities.invokeLater(() -> callback.onError(new IOException("HTTP error code: " + statusCode + ", Message: " + errorMessage)));
                }
            } catch (IOException ex) {
                SwingUtilities.invokeLater(() -> callback.onError(ex));
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }).start();
    }

    // Callback interface for asynchronous handling of the result
    public interface StockQuoteCallback {
        void onSuccess(String data);
        void onError(Exception e);
    }
}
