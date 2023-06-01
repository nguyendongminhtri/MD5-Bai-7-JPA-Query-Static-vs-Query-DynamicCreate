package rikkei.academy.repository;

import rikkei.academy.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    List<Student> findByName(String name);
    List<Student> findByNameStatic(String name);
    void save(Student student);
    Student findById(Long id);
    void deleteById(Long id);
}
