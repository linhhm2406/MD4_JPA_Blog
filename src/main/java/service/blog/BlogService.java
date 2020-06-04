package service.blog;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.blog.IBlogRepository;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> showAll() {
        return repository.showAll();
    }

    @Override
    public Blog getOne(Long id) {
        return repository.getOneById(id);
    }

    @Override
    public void save(Blog model) {
        repository.save(model);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void upLike(Long id) {
        repository.upLike(id);
    }
}
