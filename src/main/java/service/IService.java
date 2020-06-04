package service;

import java.util.List;

public interface IService<T> {
    List<T> showAll();
    T getOne(Long id);
    void save(T model);
    void delete(Long id);
    void upLike(Long id);
}
