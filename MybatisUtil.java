package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
 maven依赖
 ----------------------------------
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>VERSION</version>
 </dependency>
 ----------------------------------
 */
public final class MybatisUtil {

    private static InputStream in;
    private static SqlSession session;

    static {
        //1.读取主配置文件，返回文件流
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.创建SqlSessionFactory工厂
            SqlSessionFactory factory = builder.build(in);
            //4.使用工厂生产SqlSession对象
            session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return session;
    }

    public static void close() {
        try {
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
