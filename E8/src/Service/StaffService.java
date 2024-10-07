package Service;

import Entity.Staff;
import IGeneric.IGeneral;

import java.util.List;

public class StaffService implements IGeneral<Staff> {
    private List<Staff> staffs;

    public StaffService(List<Staff> staffs) {
        this.staffs = staffs;
    }

    @Override
    public Staff getById(int id) {
        return staffs.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Staff getByCode(String code) {
        return staffs.stream()
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Staff> getByName(String keyword) {
        return staffs.stream()
                .filter(s -> s.getName().equalsIgnoreCase(keyword))
                .toList();
    }
}
