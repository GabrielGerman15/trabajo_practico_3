package org.example;

public class Employee {
	 // Atributos privados
    private String name;
    private String apellido;
    private String employeeNumber;
    private String phone;
    private String photo;
    private String emailAddress;
    private String address;
    private String locality;
    private String province;
    private String postalCode;

    // Constructor
    public Employee (String name, String apellido, String employeeNumber, String phone, String photo, 
                    String emailAddress, String address, String locality, 
                    String province, String postalCode) {
        this.name = name;
        this.apellido = apellido;
        this.employeeNumber = employeeNumber;
        this.phone = phone;
        this.photo = photo;
        this.emailAddress = emailAddress;
        this.address = address;
        this.locality = locality;
        this.province = province;
        this.postalCode = postalCode;
    }
    // Métodos getter
    public String getName() {
        return name;
    }
    
    public String getApellido() {
    	return apellido;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoto() {
        return photo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getLocality() {
        return locality;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", apellido'" + apellido + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                ", emailAdress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                 ", locality='" + locality + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}