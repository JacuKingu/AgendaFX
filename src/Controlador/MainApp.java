package Controlador;

import java.io.IOException;

import Modelo.Person;
import Vista.PersonOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

     // ... AFTER THE OTHER VARIABLES ...

	/**
	 * The data as an observable list of Persons.
	 */
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	/**
	 * Constructor
	 */
	public MainApp() {
		// Add some sample data
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}
  
	/**
	 * Returns the data as an observable list of Persons. 
	 * @return
	 */
	public ObservableList<Person> getPersonData() {
		return personData;
	}
  
    // ... THE REST OF THE CLASS ...

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }
    
    /**
     * Inicializa el root layout.
     */
    public void initRootLayout() {
        try {
            // Carga root layout desde un archivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/Vista/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Muestra la escena que contiene root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra person overview dentro de root layout.
     */
    public void showPersonOverview() {
        try {
            // Carga person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/Vista/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            // Pone person overview dentro en el centro de root layout.
            rootLayout.setCenter(personOverview);

            // Dar el acceso al controlador a main app.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * Devuelve al escenario Principal.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) {
        launch(args);
    }
}