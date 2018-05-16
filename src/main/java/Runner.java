import db.DBCourse;
import db.DBHelper;
import db.DBLesson;
import db.DBStudent;
import models.Course;
import models.Instructor;
import models.Lesson;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Applied Mathematics", "BSc");
        DBHelper.save(course1);

        Lesson lesson1 = new Lesson("Maths", 101);
        DBHelper.save(lesson1);

        Student student1 = new Student("Fraser", 22, 1000);
        DBHelper.save(student1);
        Student student2 = new Student("Ruaridh", 27, 1001);
        DBHelper.save(student2);

        Instructor instructor1 = new Instructor("Ally");
        DBHelper.save(instructor1);

        DBHelper.addStudentToCourse(course1, lesson1, student1);
        DBHelper.addStudentToCourse(course1, lesson1, student2);
        DBHelper.addInstructorToLesson(instructor1, lesson1);

        List<Student> studentList = DBHelper.getAll(Student.class);

        List<Lesson> lessonList = DBCourse.getLessonsForCourse(course1);
        List<Student> studentList1 = DBLesson.getStudentsForLesson(lesson1);
        List<Lesson> lessonList1 = DBStudent.getStudentsLessons(student1);




    }
}
