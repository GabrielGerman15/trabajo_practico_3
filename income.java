package org.example;// Java
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

class income {
    public record invalidAttributeValueException() {

	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        user currentUser = new user("admin", "Admin", "Admin"); // Ejemplo de inicio de sesión

        if (!currentUser.hasPermissions()) {
            System.out.println("Permisos insuficientes para realizar esta tarea.");
            scanner.close();
            return;
        }

        int choice;
        do {
            showMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (choice) {
                case 1:
				try {
					registerUser(scanner);
				} catch (InvalidAttributeValueException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
                case 2:
                    registerIndustry(scanner);
                    break;
                case 3:
                    registerDepartment(scanner);
                    break;
                case 4:
                    registerEmployee(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n--- Sistema de Gestión Income ---");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Registrar Industria");
        System.out.println("3. Registrar Departamento");
        System.out.println("4. Registrar Empleado");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void registerUser(Scanner scanner) throws InvalidAttributeValueException {
        user user = null;
        boolean isDataValid = false;

        do {
            System.out.println("\n--- Registrar Nuevo Usuario ---");
            System.out.print("Nombre: ");
            String firstName = scanner.nextLine();
            System.out.print("Apellido: ");
            String lastName = scanner.nextLine();
            System.out.print("DNI/CUIT/CUIL: ");
            String identifier = scanner.nextLine();
            System.out.print("Teléfono: ");
            String phone = scanner.nextLine();
            System.out.print("E-mail: ");
            String email = scanner.nextLine();

            System.out.print("Dirección: ");
            String address = scanner.nextLine();
            System.out.print("Código Postal: ");
            String postalCode = scanner.nextLine();

            user = new user(firstName, lastName, identifier, phone, email, emailAddress, address, postalCode);

            validateUserData(user);
			isDataValid = true;
			System.out.println("\nUsuario cargado con éxito.");
        } while (!isDataValid);
    }

    private static void registerIndustry(Scanner scanner) {
        industry industry = null;
        boolean isDataValid = false;

        do {
            System.out.println("\n--- Registrar Nueva Industria ---");
            System.out.print("Nombre de la compañía: ");
            String companyName = scanner.nextLine();
            System.out.print("CUIT: ");
            String cuit = scanner.nextLine();
            System.out.print("Dirección: ");
            String address = scanner.nextLine();
            System.out.print("Dirección de e-mail: ");
            String email = scanner.nextLine();
            System.out.print("Teléfono: ");
            String phone = scanner.nextLine();
            System.out.print("Página web: ");
            String website = scanner.nextLine();

            industry = new industry(companyName, cuit, address, email, phone, website);

            try {
                validateIndustryData(industry);
                isDataValid = true;
                System.out.println("\nIndustria cargada con éxito.");
            } catch (invalidIndustryDataException e) {
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Por favor, vuelve a ingresar los datos.\n");
            }
        } while (!isDataValid);
    }

    private static void registerDepartment(Scanner scanner) {
        department department = null;
        boolean isDataValid = false;

        do {
            System.out.println("\n--- Registrar Nuevo Departamento ---");
            System.out.print("Nombre del Departamento: ");
            String name = scanner.nextLine();
            System.out.print("Número del Departamento: ");
            String number = scanner.nextLine();

            department = new department(name, number);

            try {
                validateDepartmentData(department);
                isDataValid = true;
                System.out.println("\nDepartamento cargado con éxito.");
            } catch (invalidDepartmentDataException e) {
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Por favor, vuelve a ingresar los datos.\n");
            }
        } while (!isDataValid);
    }

    private static void registerEmployee(Scanner scanner) {
        Employee employee = null;
        boolean isDataValid = false;

        do {
            System.out.println("\n--- Registrar Nuevo Empleado ---");
            System.out.print("Nombre del Empleado: ");
            String name = scanner.nextLine();
            System.out.print("Cuil/Cuit: ");
            String cuil = scanner.nextLine();
            System.out.print("Número de Empleado: ");
            String employeeNumber = scanner.nextLine();
            System.out.print("Número de Teléfono: ");
            String phone = scanner.nextLine();
            System.out.print("Fotografía: "); // Aquí se podría manejar la foto como un string de path o URL.
            String photo = scanner.nextLine();
            System.out.print("Dirección de E-mail: ");
            String emailAddress = scanner.nextLine();
            System.out.print("Dirección: ");
            String address = scanner.nextLine();
            System.out.print("Localidad: ");
            String locality = scanner.nextLine();
            System.out.print("Provincia: ");
            String province = scanner.nextLine();
            System.out.print("Código Postal: ");
            String postalCode = scanner.nextLine();

            employee = ((EmployeeBuilder) ((EmployeeBuilder) ((EmployeeBuilder) ((EmployeeBuilder) ((EmployeeBuilder) ((EmployeeBuilder) ((EmployeeBuilder) ((EmployeeBuilder) ((EmployeeBuilder) ((EmployeeBuilder) new EmployeeBuilder().setName(name)).setCuil(cuil)).setEmployeeNumber(employeeNumber)).setPhone(phone)).setPhoto(photo)).setEmailAdress(emailAddress)).setAdress(address)).setLocality(locality)).setProvince(province)).setPostalCode(postalCode)).createEmployee();

            try {
                validateEmployeeData(employee);
                isDataValid = true;
                System.out.println("\nEmpleado cargado con éxito.");
            } catch (invalidEmployeeDataException e) {
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Por favor, vuelve a ingresar los datos.\n");
            }
        } while (!isDataValid);
    }

    private static void validateUserData(user user) throws InvalidAttributeValueException {
        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getIdentifier().isEmpty() ||
                user.getPhone().isEmpty() || user.getEmail().isEmpty() || user.getEmailAddress().isEmpty() ||
                user.getAddress().isEmpty() || user.getPostalCode().isEmpty()) {
            throw new InvalidAttributeValueException("Todos los campos deben ser completados.");
        }
        if (!user.getEmail().equals(user.getEmailAddress())) {
            throw new InvalidAttributeValueException("El e-mail y la dirección de e-mail deben coincidir.");
        }
    }

    private static void validateIndustryData(industry industry) throws invalidIndustryDataException {
        if (industry.getCompanyName().isEmpty() || industry.getCuit().isEmpty() || industry.getAddress().isEmpty() ||
                industry.getEmail().isEmpty() || industry.getPhone().isEmpty() || industry.getWebsite().isEmpty()) {
            throw new invalidIndustryDataException("Todos los campos deben ser completados.");
        }
    }

    private static void validateDepartmentData(department department) throws invalidDepartmentDataException {
        if (department.getName().isEmpty() || department.getNumber().isEmpty()) {
            throw new invalidDepartmentDataException("Todos los campos deben ser completados.");
        }
    }

    private static void validateEmployeeData(Employee employee) throws invalidEmployeeDataException {
        if (employee.getName().isEmpty() || employee.getEmployeeNumber().isEmpty() ||
                employee.getPhone().isEmpty() || employee.getPhoto().isEmpty() || employee.getEmailAddress().isEmpty() ||
                employee.getAddress().isEmpty() || employee.getLocality().isEmpty() || employee.getProvince().isEmpty() ||
                employee.getPostalCode().isEmpty()) {
            throw new invalidEmployeeDataException("Todos los campos deben ser completados.");
        }
    }
}
// Java
class user {
    private String firstName;
    private String lastName;
    private String identifier;
    private String phone;
    private String email;
    private String emailAddress;
    private String address;
    private String postalCode;

    public user(String firstName, String lastName, String identifier, String phone, String email,
                String emailAddress, String address, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
        this.phone = phone;
        this.email = email;
        this.emailAddress = emailAddress;
        this.address = address;
        this.postalCode = postalCode;
    }

    public user(String firstName, String lastName, String identifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifier = identifier;
        this.phone = "";
        this.email = "";
        this.emailAddress = "";
        this.address = "";
        this.postalCode = "";
    }

    public boolean hasPermissions() {
        // Aquí se validan los permisos del usuario para alguna tarea.
        return true; // En un caso real, se debería validar contra un sistema de permisos.
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identifier='" + identifier + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
// Java
class industry {
    private String companyName;
    private String cuit;
    private String address;
    private String email;
    private String phone;
    private String website;

    public industry(String companyName, String cuit, String address, String email, String phone, String website) {
        this.companyName = companyName;
        this.cuit = cuit;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCuit() {
        return cuit;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "companyName='" + companyName + '\'' +
                ", cuit='" + cuit + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
// Java
class department {
    private String name;
    private String number;

    public department(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

// Java
class invalidIndustryDataException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public invalidIndustryDataException(String message) {
        super(message);
    }
}
// Java
class invalidDepartmentDataException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public invalidDepartmentDataException(String message) {
        super(message);
    }
}
// Java
class invalidEmployeeDataException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public invalidEmployeeDataException(String message) {
        super(message);
    }
}
