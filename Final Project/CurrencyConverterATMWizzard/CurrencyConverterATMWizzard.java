import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
//Now, when the user enters a new exchange rate in the `newExchangeRateTextField`, the exchange rate for the selected currency in the `toComboBox` will be updated in the `exchangeRates` map, and the exchange rate text field will display the updated value.


public class CurrencyConverterATMWizzard extends Application {

    private Map<String, Double> exchangeRates = new HashMap<>();

    private ComboBox<String> fromComboBox;
    private ComboBox<String> toComboBox;
    private TextField amountTextField;
    private Label resultLabel;
    private TextField exchangeRateTextField;

    public void start(Stage primaryStage) {

        // Populate the exchange rates map
        exchangeRates.put("United States Dollar USD $", 1.0);
        exchangeRates.put("European Union EUR ₠ ", 0.85);
        exchangeRates.put("Pound Sterling GBP £", 0.73);
        exchangeRates.put("JPY Japanese Yen ¥" , 106.80);
        exchangeRates.put("Canadian Dollar CAD U $", 1.26);
        exchangeRates.put("Australian Dollar AUD $", 1.29);
        exchangeRates.put("New Zealand Dollar NZD $", 1.38);
        exchangeRates.put("Swiss Franc CHF ₣ ", 0.91);
        exchangeRates.put("South African Rand ZAR R", 14.97);
        exchangeRates.put("Indian Rupee INR Rs", 72.91);

        // Create UI elements
        Label fromLabel = new Label("From:");
        fromComboBox = new ComboBox<>(FXCollections.observableArrayList(exchangeRates.keySet()));
        fromComboBox.getSelectionModel().selectFirst();

        Label toLabel = new Label("To:");
        toComboBox = new ComboBox<>(FXCollections.observableArrayList(exchangeRates.keySet()));
        toComboBox.getSelectionModel().select(1);

        Label amountLabel = new Label("Amount:");
        amountTextField = new TextField();
        amountTextField.setText("1.00");

        Label exchangeRateLabel = new Label("Exchange Rate:");
        exchangeRateTextField = new TextField();
        exchangeRateTextField.setText(Double.toString(exchangeRates.get(toComboBox.getValue())));

        Label newExchangeRateLabel = new Label("New Exchange Rate:");
        TextField newExchangeRateTextField = new TextField();

        resultLabel = new Label();

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(event -> convert());

        // Add a listener to the toComboBox to update the exchange rate text field when the user selects a different currency
        toComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                exchangeRateTextField.setText(Double.toString(exchangeRates.get(newValue)));
            }
        });

        // Add a listener to the exchangeRateTextField to update the exchangeRates map when the user enters a new exchange rate
        exchangeRateTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double newExchangeRate = Double.parseDouble(newValue);
                    String selectedCurrency = toComboBox.getValue();
                    exchangeRates.put(selectedCurrency, newExchangeRate);
                } catch (NumberFormatException e) {
                    // Ignore invalid input
                }
            }
        });

        // Add a listener to the newExchangeRateTextField to update the exchangeRates map when the user enters a new exchange rate
        newExchangeRateTextField.setOnAction(event -> {
            try {
                double newExchangeRate = Double.parseDouble(newExchangeRateTextField.getText());
                String selectedCurrency = toComboBox.getValue();             
				exchangeRates.put(selectedCurrency, newExchangeRate);
            exchangeRateTextField.setText(Double.toString(newExchangeRate));
        } catch (NumberFormatException e) {
                    // Ignore invalid input
                }
            });
        

    // Create a grid pane and add the UI elements to it
    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setPadding(new Insets(10));
    gridPane.setAlignment(Pos.CENTER);

    gridPane.add(fromLabel, 0, 0);
    gridPane.add(fromComboBox, 1, 0);
    gridPane.add(toLabel, 2, 0);
    gridPane.add(toComboBox, 3, 0);
    gridPane.add(amountLabel, 0, 1);
    gridPane.add(amountTextField, 1, 1);
    gridPane.add(exchangeRateLabel, 2, 1);
    gridPane.add(exchangeRateTextField, 3, 1);
    gridPane.add(newExchangeRateLabel, 0, 2);
    gridPane.add(newExchangeRateTextField, 1, 2);
    gridPane.add(convertButton, 2, 2);
    gridPane.add(resultLabel, 0, 3, 4, 1);

    // Create a scene and add the grid pane to it
    Scene scene = new Scene(gridPane);

    // Set the stage title and scene, and show the stage
    primaryStage.setTitle("Currency Converter");
    primaryStage.setScene(scene);
    primaryStage.show();
}

private void convert() {
    try {
        String fromCurrency = fromComboBox.getValue();
        String toCurrency = toComboBox.getValue();
        double amount = Double.parseDouble(amountTextField.getText());
        double exchangeRate = exchangeRates.get(toCurrency);
        double result = amount * exchangeRate / exchangeRates.get(fromCurrency);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        resultLabel.setText(decimalFormat.format(amount) + " " + fromCurrency + " = " +
                decimalFormat.format(result) + " " + toCurrency);
    } catch (NumberFormatException e) {
        resultLabel.setText("Invalid input");
    }
}

public static void main(String[] args) {
    launch(args);
}


}