package repository.blog;

import model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Blog> showAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog getOneById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b where b.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            entityManager.persist(blog);
        } else {
            entityManager.merge(blog);
        }
    }

    @Override
    public void delete(Long id) {
        Blog blog = getOneById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }

    @Override
    public void upLike(Long id) {
        Blog blog = getOneById(id);
        long newLikeNumber;
        if (blog.getLikeNumber() != null) {
            newLikeNumber = blog.getLikeNumber() + 1;
        } else{
            newLikeNumber = 1;
        }
            blog.setLikeNumber(newLikeNumber);
        entityManager.merge(blog);
    }
}
