import Controller.StudentController;
import Entity.Staff;
import Entity.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Controller.StaffController;

import Entity.Gender;
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("C2309G1111", "Hieu", LocalDate.of(2005, 12, 22), Gender.M, "Hanoi"));
        students.add(new Student("C2309G1233", "Yasuo", LocalDate.of(2023, 3, 21), Gender.F, "Ionia"));
        students.add(new Student("C2309G2321", "Yone", LocalDate.of(1211, 7, 31), Gender.M, "Ionia"));
        students.add(new Student("C2309G2322", "Teemo", LocalDate.of(2021, 9, 11), Gender.O, "Yordle"));


        List<Staff> staffs = new ArrayList<>();

        staffs.add(new Staff("AACN1", "Hieu", "Ionia", Gender.F, 7000, "Hanoi"));
        staffs.add(new Staff("C2309G1111", "Yasuo", "Void", Gender.M, 5000, "Hanoi"));
        staffs.add(new Staff("C2309G2222", "Teemo", "Noxus", Gender.F, 9000, "Hanoi"));
        staffs.add(new Staff("C2309G3333", "Ngao", "Demacia", Gender.M, 6000, "Hanoi"));

        StaffController controller = new StaffController(staffs);


        System.out.println("Danh sách nhân viên:");
        for (Staff staff : controller.employees) {
            System.out.println(staff);
        }


        String keyword = "Hieu";
        List<Staff> foundStaffs = controller.getByName(keyword);
        System.out.println("\nNhân viên tìm thấy với tên chứa \"" + keyword + "\":");
        for (Staff staff : foundStaffs) {
            System.out.println(staff);
        }

        // Cập nhật tên nhân viên
        String idToUpdate = "AACN1";
        String newName = "Hieu Updated";
        controller.updateEmployeeName(idToUpdate, newName);
        System.out.println("\nDanh sách nhân viên sau khi cập nhật tên:");
        for (Staff staff : controller.employees) {
            System.out.println(staff);
        }
//        StudentController sc = new StudentController(students);
//        Optional<Student> studentYoungest = sc.getYoungest();
//        System.out.println(studentYoungest.get());

        //StudentController.getByName("Hieu").forEach(System.out.println());
//
//        Student youngestStudent = students.stream()
//                .min((s1, s2) -> s1.getDoB().compareTo(s2.getDoB()))
//                .orElse(null);
//
//
//        if (youngestStudent != null) {
//            System.out.println("Sinh viên trẻ nhất: " + youngestStudent);
//        } else {
//            System.out.println("Không có sinh viên nào trong danh sách.");
//        }
    }
}


