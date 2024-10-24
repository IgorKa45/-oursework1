import java.util.Objects;

public class Employee {
    // Константы
    public static final byte minDepartment = 1;
    public static final byte maxDepartment = 5;
    //Счётчик
    private int id;

    private String name; //Имя сотрудника
    private String surname; //Фамилия сотрудника
    private String middlename; //Отчество сотрудника
    private byte department; //Отдел
    private double salary; //Зарплата

    private static int idGrow;

    public Employee(String name, String surname, String middlename, byte department, double salary) {
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.department = department;
        this.salary = salary;
        id = ++idGrow;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public byte getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(byte department) {
        if (department >= minDepartment && department <= maxDepartment) {
            this.department = department;
        } else {
            System.out.println("Ошибка. Данного отдела не существует.");
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "id: " + id + " Имя: " + name + " Фамилия: " + surname + " Отчество: " + middlename + " Отдел: " + department + " Зарплата: " + salary;
    }

    public String toStringNoDepartment() {
        return "id: " + id + " Имя: " + name + " Фамилия: " + surname + " Отчество: " + middlename + " Зарплата: " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return this.name.equals(employee.name) && this.surname.equals(employee.surname) && this.middlename.equals(employee.middlename) && department == employee.department && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id + name + surname + middlename + department + salary);
    }

}
