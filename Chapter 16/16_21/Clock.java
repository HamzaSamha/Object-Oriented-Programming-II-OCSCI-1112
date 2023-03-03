//package Chapter_16;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView; 
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;


public class Clock extends Application {

   final String MP3 = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";

    @Override
	
    public void start(Stage primaryStage) throws Exception {
		

        TextField countDown = new TextField("0");
        countDown.setFont(Font.font(50));
        countDown.setPrefColumnCount(3);
        countDown.setAlignment(Pos.CENTER);
        countDown.setFocusTraversable(false);
        Pane pane = new Pane(countDown);
        StackPane stackPane = new StackPane(pane);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1000), e-> {
                    countDown.setText((Integer.parseInt(countDown.getText()) - 1) + "");
        }));

        countDown.setOnAction(e-> {
            if (timeline.getStatus() == Animation.Status.RUNNING) {
                timeline.stop();
            }
            timeline.setCycleCount(Integer.parseInt(countDown.getText()));
            countDown.setEditable(false);
            timeline.play();
        });

        File file = new File(MP3);
		Media media = new Media(MP3);
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
		MediaView mediaView =new MediaView(mediaPlayer);

        timeline.setOnFinished(event -> {
         mediaPlayer.play();
        });
        primaryStage.setScene(new Scene(stackPane));
        primaryStage.setTitle("Countdown");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}