package rikkei.academy.repository;

import org.springframework.transaction.annotation.Transactional;
import rikkei.academy.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class StudentRepositoryIMPL implements IStudentRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Student> findAll() {
        String qrFindAll = "SELECT st FROM Student AS st";
        TypedQuery<Student> query = em.createQuery(qrFindAll, Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByName(String name) {
        String qrFindByName = "SELECT st FROM Student AS st WHERE st.name LIKE :name";
        TypedQuery<Student> query = em.createQuery(qrFindByName, Student.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Student> findByNameStatic(String name) {
        TypedQuery<Student> query = em.createNamedQuery("Student.FIND_BY_NAME", Student.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public void save(Student student) {
        if (student.getId() != null) {
            em.merge(student);
        }else {
            em.persist(student);
        }
    }

    @Override
    public Student findById(Long id) {
        String qrFindById = "SELECT st FROM Student AS st WHERE st.id=:id";
        TypedQuery<Student> query = em.createQuery(qrFindById, Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
 em.remove(findById(id));
    }
}
