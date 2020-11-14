import com.coolway.entity.Subject;
import com.coolway.entity.Teacher;
import com.coolway.service.SubjectService;
import com.coolway.service.TeacherService;
import com.coolway.service.impl.SubjectServiceImpl;
import com.coolway.service.impl.TeacherServiceImpl;
import com.coolway.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateOne2Many {

    private TeacherService teacherService = new TeacherServiceImpl();
    private SubjectService subjectService = new SubjectServiceImpl();
    @Test
    public void test() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        //创建或者查询到一个teacher
        Teacher teacher = new Teacher();
        teacher.setIdNum("20200003");
        teacher.setName("ls");
        teacher.setAge(20);

        //创建多个subject
        Subject subject1 = new Subject();
        Subject subject2 = new Subject();

        subject1.setSub_name("语文");
        subject2.setSub_name("数学");

        //建立联系
        teacher.getSetSub().add(subject1);
        teacher.getSetSub().add(subject2);
        subject1.setTeacher(teacher);
        subject2.setTeacher(teacher);

        //在同一事务中保存所有对象
        session.save(teacher);
        session.save(subject1);
        session.save(subject2);

        transaction.commit();
//        teacherService.saveTeacher(teacher);
//        subjectService.saveSubject(subject1);
//        subjectService.saveSubject(subject2);

    }
}
