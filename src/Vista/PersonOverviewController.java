package Vista;

import Modelo.Person;
import Controlador.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> NombreColum;
    @FXML
    private TableColumn<Person, String> ApellidoColum;

    @FXML
    private Label txtnombre;
    @FXML
    private Label txtapellido;
    @FXML
    private Label txtcalle;
    @FXML
    private Label txtcodpost;
    @FXML
    private Label txtciudad;
    @FXML
    private Label txtcump;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the person table with the two columns.
        NombreColum.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        ApellidoColum.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
}