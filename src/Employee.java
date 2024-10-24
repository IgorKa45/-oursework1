import java.util.Objects;

public class Employee {
    private String name; //Имя сотрудника
    private String surname; //Фамилия сотрудника
    private String middlename; //Отчество сотрудника
    byte department; //Отдел
    private double salary; //Зарплата

    //Счётчик
    private int id;
    private static int idGrow = 0;

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
        if (department >= 1 && department <= 5) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ;
        Employee employee = (Employee) o;
        return this.name.equals(employee.name) && this.surname.equals(employee.surname) && this.middlename.equals(employee.middlename) && department == employee.department && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name + surname + middlename + department + salary);
    }

}