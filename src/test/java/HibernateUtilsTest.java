import com.coolway.entity.Teacher;
import com.coolway.service.TeacherService;
import com.coolway.service.impl.TeacherServiceImpl;
import org.junit.Test;

public class HibernateUtilsTest {
private TeacherService teacherService = new TeacherServiceImpl();
    @Test
    public void test() {
        Teacher teacher = new Teacher();
        teacher.setName("zs");
        teacher.setAge(22);
        teacher.setIdNum("20200002");

        //执行service
        teacherService.saveTeacher(teacher);
    }
}
