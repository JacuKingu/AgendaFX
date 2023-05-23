package Modelo;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

	private final StringProperty nombre;
	private final StringProperty apellido;
	private final StringProperty calle;
	private final IntegerProperty codpost;
	private final StringProperty ciudad;
	private final ObjectProperty<LocalDate> cump;

	/**
	 * Default constructor.
	 */
	public Person() {
		this(null,null);
	}
	
	/**
	 * Constructor with some initial data.
	 * 
	 * @param nombre
	 * @param apellido
	 */
	public Person(String nombre, String apellido) {
		this.nombre = new SimpleStringProperty(nombre);
		this.apellido = new SimpleStringProperty(apellido);
		
		// Some initial dummy data, just for convenient testing.
		this.calle = new SimpleStringProperty("Alguna calle");
		this.codpost = new SimpleIntegerProperty(1234);
		this.ciudad = new SimpleStringProperty("Alguna ciudad");
		this.cump = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
	}
	
	public String getnombre() {
		return nombre.get();
	}

	public void setnombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public StringProperty nombreProperty() {
		return nombre;
	}

	public String getapellido() {
		return apellido.get();
	}

	public void setapellido(String apellido) {
		this.apellido.set(apellido);
	}
	
	public StringProperty apellidoProperty() {
		return apellido;
	}

	public String getcalle() {
		return calle.get();
	}

	public void setcalle(String calle) {
		this.calle.set(calle);
	}
	
	public StringProperty calleProperty() {
		return calle;
	}

	public int getcodpost() {
		return codpost.get();
	}

	public void setcodpost(int codpost) {
		this.codpost.set(codpost);
	}
	
	public IntegerProperty codpostProperty() {
		return codpost;
	}

	public String getciudad() {
		return ciudad.get();
	}

	public void setciudad(String ciudad) {
		this.ciudad.set(ciudad);
	}
	
	public StringProperty ciudadProperty() {
		return ciudad;
	}

	public LocalDate getcump() {
		return cump.get();
	}

	public void setcump(LocalDate cump) {
		this.cump.set(cump);
	}
	
	public ObjectProperty<LocalDate> cumpProperty() {
		return cump;
	}
}