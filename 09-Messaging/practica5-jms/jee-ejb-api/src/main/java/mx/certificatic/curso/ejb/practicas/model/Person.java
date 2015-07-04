package mx.certificatic.curso.ejb.practicas.model;
import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
    private int id;
    private String name;
    private Date bdate;
    private Character gender;
    
    

    public Person() {
		super();
	}

	public Person(int id, String name, Date bdate, Character gender) {
        super();
        this.id = id;
        this.name = name;
        this.bdate = bdate;
        this.gender = gender;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

    //Getters and Setters
}