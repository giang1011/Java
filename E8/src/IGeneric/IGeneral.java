package IGeneric;

import java.util.List;

public interface IGeneral<T> {
    public T getById(int id);
    public T getByCode(String code);
    public List<T> getByName(String keyword);
}
