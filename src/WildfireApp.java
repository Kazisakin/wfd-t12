import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainWindow;

public class WildfireApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        MainWindow mainWindow = new MainWindow();

        Scene scene = new Scene(mainWindow.getRoot(), 520, 520);

        primaryStage.setTitle("Wildfire Detection App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}