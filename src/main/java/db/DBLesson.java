package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLesson {

    private static Transaction transaction;
    private static Session session;

    public static List<Student> getStudentsForLesson(Lesson lesson){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> results = null;
        try {
            Criteria cr = session.createCriteria(Student.class);
            cr.add(Restrictions.eq("lesson", lesson));
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}
