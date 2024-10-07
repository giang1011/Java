package IGneric;
import java.util.List;
public interface GenericService<T> {
    void update(T obj);
    List<T> sort(List<T> objList);
    T getById(List<T> objList, int id);
    T getByName(List<T> objList, String name);
}