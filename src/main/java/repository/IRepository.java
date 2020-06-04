package repository;

import java.util.List;

public interface IRepository<T> {
    List<T> showAll();
    T getOneById(Long id);
    void save(T model);
    void delete(Long id);
    void upLike(Long id);
}
