import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import Entity.BasicStaff;
import Entity.Staff;
import Entity.Technician;
import Entity.Manager;

public class Main {
    public static void main(String[] args) {
        // Tạo danh sách các nhân viên
        List<Staff> staffList = new ArrayList<>();
        staffList.add(new Manager("Domic", 5000, 1000));
        staffList.add(new Technician("Galio", 3000, 500));
        staffList.add(new BasicStaff("Bob", 2000));


        String name = "Galio";


        Stream<Staff> staffStream = staffList.stream();
        staffStream.filter(staff -> staff.name.equalsIgnoreCase(name))
                .forEach(staff -> {
                    System.out.println(staff.toString());
                    System.out.println("Được trả: " + staff.getPaid());
                });
    }
}
