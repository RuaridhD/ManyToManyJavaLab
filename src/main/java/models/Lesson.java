package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lessons")
public class Lesson {

    private String title;
    private int classroomNo;
    private int id;
    private Set<Student> students;
    private Course course;
    Instructor instructor;

    public Lesson() {
    }

    public Lesson(String title, int classroomNo) {
        this.title = title;
        this.classroomNo = classroomNo;
        this.students = new HashSet<Student>();
    }
    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="classroom_number")
    public int getClassroomNo() {
        return classroomNo;
    }

    public void setClassroomNo(int classroomNo) {
        this.classroomNo = classroomNo;
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

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="student_course",
    inverseJoinColumns = {@JoinColumn(name="course_id", nullable = false, updatable = false)},
    joinColumns = {@JoinColumn(name="student_id", nullable = false, updatable = false)})
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
