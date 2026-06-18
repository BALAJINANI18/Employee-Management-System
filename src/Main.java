import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;
    private int attendanceDays;
    private int points;

    public Employee(int id, String name, double salary, int attendanceDays, int points) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.attendanceDays = attendanceDays;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAttendanceDays() {
        return attendanceDays;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAttendanceDays(int attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nSalary: ₹" + salary +
                "\nAttendance Days: " + attendanceDays +
                "\nPoints: " + points +
                "\n-------------------------";
    }
}

public class Main {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, salary, 0, 0);
        employees.add(emp);

        System.out.println("Employee Added Successfully!");
    }

    public static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Found!");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp);
                return;
            }
        }

        System.out.println("Employee Not Found!");
    }

    public static void updateEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee emp : employees) {
            if (emp.getId() == id) {

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Salary: ");
                double salary = sc.nextDouble();

                emp.setName(name);
                emp.setSalary(salary);

                System.out.println("Employee Updated Successfully!");
                return;
            }
        }

        System.out.println("Employee Not Found!");
    }

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee Deleted Successfully!");
                return;
            }
        }

        System.out.println("Employee Not Found!");
    }

    public static void markAttendance() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {

                emp.setAttendanceDays(emp.getAttendanceDays() + 1);

                System.out.println("Attendance Marked!");
                return;
            }
        }

        System.out.println("Employee Not Found!");
    }

    public static void addPoints() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {

                System.out.print("Enter Points to Add: ");
                int p = sc.nextInt();

                emp.setPoints(emp.getPoints() + p);

                System.out.println("Points Added Successfully!");
                return;
            }
        }

        System.out.println("Employee Not Found!");
    }

    public static void calculateBonus() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {

                double bonus = 0;

                if (emp.getAttendanceDays() >= 25 && emp.getPoints() >= 100) {
                    bonus = emp.getSalary() * 0.10;
                } else if (emp.getPoints() >= 50) {
                    bonus = emp.getSalary() * 0.05;
                }

                System.out.println("Bonus Amount: ₹" + bonus);
                return;
            }
        }

        System.out.println("Employee Not Found!");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Mark Attendance");
            System.out.println("7. Add Performance Points");
            System.out.println("8. Calculate Bonus");
            System.out.println("9. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    markAttendance();
                    break;

                case 7:
                    addPoints();
                    break;

                case 8:
                    calculateBonus();
                    break;

                case 9:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}