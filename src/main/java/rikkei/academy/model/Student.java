package rikkei.academy.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Student.FIND_BY_NAME", query = "SELECT st FROM Student as st WHERE st.name LIKE :name")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Student() {
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
