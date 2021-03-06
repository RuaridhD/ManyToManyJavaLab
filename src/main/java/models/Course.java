package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {

    private int id;
    private String title;
    private String level;
    private Set<Lesson> lessons;

    public Course() {
    }

    public Course(String title, String level) {
        this.title = title;
        this.level = level;
        this.lessons = new HashSet<Lesson>();
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @OneToMany(mappedBy="course")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }
}
