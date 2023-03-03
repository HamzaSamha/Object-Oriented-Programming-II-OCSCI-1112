import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class coloringPhrase extends Application {
	protected Text text = new Text(50, 50, "Programming is fun");

	@Override // Override the stage method in the Application class
	public void start(Stage primaryStage) {
		HBox buttonPane = new HBox(20);
		Button leftButton = new Button("<=");
		Button rightButton = new Button("=>");
		buttonPane.getChildren().addAll(leftButton, rightButton);
		buttonPane.setAlignment(Pos.CENTER);
		BorderPane pane = new BorderPane();
		pane.setBottom(buttonPane);

		HBox paneForRadioButtons = new HBox(20);
		RadioButton redButton = new RadioButton("Red");
		RadioButton yellowButton = new RadioButton("Yellow");
		RadioButton blackButton = new RadioButton("Black");
		RadioButton orangeButton = new RadioButton("Orange");
		RadioButton greenButton = new RadioButton("Green");
		paneForRadioButtons.getChildren().addAll(redButton, yellowButton, 
			blackButton, orangeButton, greenButton);

		ToggleGroup group = new ToggleGroup();
		redButton.setToggleGroup(group);
		yellowButton.setToggleGroup(group);
		blackButton.setToggleGroup(group);
		orangeButton.setToggleGroup(group);
		greenButton.setToggleGroup(group);

		Pane paneForText = new Pane();
		paneForText.setStyle("-fx-border-color: black");
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
		pane.setTop(paneForRadioButtons);

		leftButton.setOnAction(e -> text.setX(text.getX() - 10));
		rightButton.setOnAction(e -> text.setX(text.getX() + 10));

		redButton.setOnAction(e -> {
			if (redButton.isSelected()) {
				text.setFill(Color.RED);
			}
		});

		yellowButton.setOnAction(e -> {
			if (yellowButton.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});

		blackButton.setOnAction(e -> {
			if (blackButton.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});

		orangeButton.setOnAction(e -> {
			if (orangeButton.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});

		greenButton.setOnAction(e -> {
			if (greenButton.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 450, 150);
		primaryStage.setTitle("coloringPhrase"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}