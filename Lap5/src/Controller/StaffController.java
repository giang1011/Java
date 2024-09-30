package Controller;

import Entity.Staff;

import java.util.List;
import java.util.stream.Collectors;

public class StaffController {
    public static List<Staff> employees;

    public StaffController(List<Staff> employees) {
        this.employees = employees;
    }


    public static List<Staff> getByName(String keyword) {
        return employees.stream()
                .filter(s -> s.getName().contains(keyword))
                .collect(Collectors.toList());
    }


    public static Staff getById(String id) {
        List<Staff> result = employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .collect(Collectors.toList());


        return result.isEmpty() ? null : result.get(0);
    }


    public static void updateEmployeeName(String id, String newName) {
        employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .forEach(employee -> employee.setName(newName));
    }
}
