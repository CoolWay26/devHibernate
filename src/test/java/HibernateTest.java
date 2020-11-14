import com.coolway.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest {

    @Test
    public void saveTeacher() {
        //创建对象
        Teacher teacher = new Teacher();
        teacher.setIdNum("20200001");
        teacher.setName("王老师");
        teacher.setAge(20);

        //获取加载配置管理类
        Configuration configuration = new Configuration().configure();

        //加载Teacher的映射文件！这一步可以不做，即可以在配置文件加载
//        configuration.addClass(Teacher.class);

        //创建Session工厂对象
        SessionFactory factory = configuration.buildSessionFactory();

        //得到Session对象
        Session session = factory.openSession();


        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();

        //开启事务
        transaction.begin();

        //添加User2对象到数据库
        session.save(teacher);


        //提交事务
        transaction.commit();

        //关闭Session
        session.close();
        factory.close();
    }
}
