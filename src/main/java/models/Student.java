package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {

    private String name;
    private int age;
    private int enrolmentNo;
    private int id;
    private Set<Lesson> lessons;


    public Student() {
    }

    public Student(String name, int age, int enrolmentNo) {
        this.name = name;
        this.age = age;
        this.enrolmentNo = enrolmentNo;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Column(name="enrolment_number")
    public int getEnrolmentNo() {
        return enrolmentNo;
    }

    public void setEnrolmentNo(int enrolmentNo) {
        this.enrolmentNo = enrolmentNo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="lesson_course",
            inverseJoinColumns = {@JoinColumn(name="course_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name="lesson_id", nullable = false, updatable = false)})
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
