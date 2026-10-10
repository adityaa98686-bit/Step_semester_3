package Session_6.assignment_problems;

class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyInformationManagement {
    public static void main(String[] args) {
        Employee e1 = new Employee("Amit", 30000);
        Employee e2 = new Employee("Priya", 40000);
        Employee e3 = new Employee("Rahul", 35000);

        Employee.printCompanyInfo();
    }
}
