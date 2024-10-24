public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Ева", "Ульянова", "Дмитриевна", (byte) 3, 29000);
        employees[1] = new Employee("Кира", "Иванова", "Сергеевна", (byte) 2, 65000);
        employees[2] = new Employee("Андрей", "Смирнов", "Михайлович", (byte) 1, 78000);
        employees[3] = new Employee("Александр", "Васильев", "Юрьевич", (byte) 5, 135000);
        employees[4] = new Employee("Яковлев", "Марк", "Максимович", (byte) 2, 76000);
        employees[5] = new Employee("Яковлев", "Сергей", "Максимович", (byte) 2, 54000);
        //6ой для проверки на сравнение
        employees[6] = new Employee("Александр", "Васильев", "Юрьевич", (byte) 5, 135000);

        System.out.println(employees[0].toString());
        System.out.println(employees[1].toString());

        //Повысили зарплату первому сотруднику
//        System.out.println();
//        System.out.println("Проверка смены зарплаты:");
//        employees[0].setSalary(40000);
//        System.out.println("Изменил зарплату:" + employees[0].getSalary());

        System.out.println();
        System.out.println("Метод equals:");
        System.out.println(employees[3].equals(employees[6]));

        System.out.println();
        System.out.println("Метод hashcode:");
        System.out.println(employees[3].hashCode());
        System.out.println(employees[6].hashCode());

        System.out.println();
        System.out.println("Суммарная зарплата = " + getSalarySum());
        System.out.println("Минимальная зарплата = " + getSalaryMin());
        System.out.println("Максимальная зарплата = " + getSalaryMax());
        System.out.println("Средняя зарплата = " + getAverageSalary());

        System.out.println();
        System.out.println("Список сотрудников:");
        getAllemployees();

//        System.out.println();
//        System.out.println("Индексация всем сотрудникам:");
//        calculateAllIndexSalary(1.0742);
//        System.out.println(employees[0].getSalary());
//        System.out.println(employees[1].getSalary());
//        System.out.println(employees[2].getSalary());
//        System.out.println(employees[3].getSalary());

        System.out.println();
        System.out.println("Средняя зарплата по выбранному отделу: " + getAverageDepartmentSalary((byte) 2));

        System.out.println();
        System.out.println("Максимальная зарплата по выбранному отделу: " + getSalaryDepartmentMax((byte) 2));

        System.out.println();
        System.out.println("Минимальная зарплата по выбранному отделу: " + getSalaryDepartmentMin((byte) 2));

        System.out.println();
        System.out.println("Трата на зарплату отделу: " + getSalaryDepartmentSum((byte) 2));

        System.out.println();
        System.out.println("Сотрудники выбранного отдела:");
        getAllemployeesDepartment((byte) 2);

        System.out.println();
        System.out.println("Сотрудники с зп меньше числа:");
        getAllemployeesSalaryMin(45000);

        System.out.println();
        System.out.println("Сотрудники с зп больше (или равно) числа:");
        getAllemployeesSalaryMax(76000);


    }

    //Сумма зарплат
    public static double getSalarySum() {
        double salarySum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                salarySum += employees[i].getSalary();
            }
        }
        return salarySum;
    }

    //Минимальная зарплата
    public static double getSalaryMin() {
        Employee min = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && (min == null || employees[i].getSalary() < min.getSalary())) {
                min = employees[i];
            }
        }
        return min.getSalary();
    }

    //Максимальная зарплата
    public static double getSalaryMax() {
        double salaryMax = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && salaryMax < employees[i].getSalary()) {
                salaryMax = employees[i].getSalary();
            }
        }
        return salaryMax;
    }

    //Средняя зарплата
    public static double getAverageSalary() {
        int employeeNumCheck = 0; //Проверка количества сотрудников (На случай если в массиве есть пустые поля)
        double averageSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                averageSalary += employees[i].getSalary();
                employeeNumCheck++;
            }
        }
        return averageSalary / employeeNumCheck;
    }

    //Таблица сотрудников
    public static void getAllemployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    //Индексация всем сотрудникам всех отделов (Индексация indexPercent измерятеся в долях)
    public static void calculateAllIndexSalary(double indexPercent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * indexPercent);
            }
        }
    }

    //Средняя зарплата по отделу
    public static double getAverageDepartmentSalary(byte department) {
        int employeeNumCheck = 0;//Проверка количества сотрудников (На случай если в массиве есть пустые поля)
        double averageSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                averageSalary += employees[i].getSalary();
                employeeNumCheck++;
            }
        }
        averageSalary = averageSalary / employeeNumCheck;
        return averageSalary;
    }

    //Максимальная зарплата по отделу
    public static double getSalaryDepartmentMax(byte department) {
        double salaryMax = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && salaryMax < employees[i].getSalary() && employees[i].getDepartment() == department) {
                salaryMax = employees[i].getSalary();
            }
        }
        return salaryMax;
    }

    //Минимальная зарплата по отделу
    public static double getSalaryDepartmentMin(byte department) {
        double salaryMin = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && salaryMin > employees[i].getSalary() && employees[i].getDepartment() == department) {
                salaryMin = employees[i].getSalary();
            }
        }
        return salaryMin;
    }

    //Трата на зарплату отделу
    public static double getSalaryDepartmentSum(byte department) {
        double salarySum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                salarySum += employees[i].getSalary();
            }
        }
        return salarySum;
    }

    //Таблица сотрудников по отделу
    public static void getAllemployeesDepartment(byte department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.print("id: " + employees[i].getId() + ". ");
                System.out.print("ФИО: " + employees[i].getName() + " ");
                System.out.print(employees[i].getSurName() + " ");
                System.out.print(employees[i].getMiddlename() + ". ");
                System.out.println("Зарплата: " + employees[i].getSalary() + ". ");
            }
        }
    }

    //Сотрудники с зп меньше числа
    public static void getAllemployeesSalaryMin(double salaryMinCheck) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salaryMinCheck) {
                System.out.print("id: " + employees[i].getId() + ". ");
                System.out.print("ФИО: " + employees[i].getName() + " ");
                System.out.print(employees[i].getSurName() + " ");
                System.out.print(employees[i].getMiddlename() + ". ");
                System.out.println("Зарплата: " + employees[i].getSalary() + ". ");
            }
        }
    }

    //Сотрудники с зп меньше числа
    public static void getAllemployeesSalaryMax(double salaryMaxCheck) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salaryMaxCheck) {
                System.out.print("id: " + employees[i].getId() + ". ");
                System.out.print("ФИО: " + employees[i].getName() + " ");
                System.out.print(employees[i].getSurName() + " ");
                System.out.print(employees[i].getMiddlename() + ". ");
                System.out.println("Зарплата: " + employees[i].getSalary() + ". ");
            }
        }
    }
}