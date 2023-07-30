import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Omar Badawi", 21, "Trainee", 0));
        employees.add(new Employee("samer", 32, "Developer", 2000));
        employees.add(new Employee("Diyaa", 30, "Data Scientist", 3000));
        employees.add(new Employee("Ahmad", 40, "Manager", 4000));
        employees.add(new Employee("kareem", 50, "Manager", 4000));


        Stream<Employee> stream = employees.stream();
        int numberOfInterns =
                (int) stream.filter(employee -> employee.getSalary() == 0)
                        .count();

        System.out.println("Number of interns: " + numberOfInterns);

        Stream<Employee> stream2 = employees.stream();

        int numberOfEmployees  = (int)
        stream2.filter(employee -> employee.getSalary() > 0)
                .count();
        System.out.println("Number of Paid employees: " + numberOfEmployees);


        Stream<Employee> stream3 = employees.stream();
        int numberOfManagers = (int) stream3.filter(employee -> employee.getJobTitle().equals("Manager"))
                                            .count();

        System.out.println("Number of Managers: " + numberOfManagers);




        Stream<Employee> stream4 = employees.stream();
        Double SalaryAvg = stream4.filter(employee -> employee.getSalary() > 0)
                .mapToInt(Employee::getSalary)
                .average()
                .getAsDouble();

        System.out.println("Average Salary: " + SalaryAvg);



        Stream<Employee> stream5 = employees.stream();
        int MaxSalary = stream5.filter(employee -> employee.getSalary() > 0)
                .mapToInt(Employee::getSalary)
                .max()
                .getAsInt();
        System.out.println("Max Salary: " + MaxSalary);

        Stream<Employee> stream6 = employees.stream();
        int MinSalary = stream6.filter(employee -> employee.getSalary() > 0)
                .mapToInt(Employee::getSalary)
                .min()
                .getAsInt();

        System.out.println("Min Salary: " + MinSalary);


        Stream<Employee> stream7 = employees.stream();
        List<String> EmpNames= stream7.map(employee -> employee.getName().split(" ")[0])
                .collect(Collectors.toList());

        System.out.print("Employees First Names: ");
        for (String name : EmpNames) {
            System.out.print("[" + name + "] ");
        }

        Stream<Employee> stream8 = employees.stream();
        List<String> JobTitles= stream8.map(employee -> employee.getJobTitle())
                .distinct()
                .collect(Collectors.toList());

        System.out.print("\nJob Titles: ");
        for (String title : JobTitles) {
            System.out.print("[" + title + "] ");
        }







    }
}