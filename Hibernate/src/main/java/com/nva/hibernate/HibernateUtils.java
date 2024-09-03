/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.hibernate;

import com.nva.pojo.AddScore;
import com.nva.pojo.Category;
import com.nva.pojo.Comment;
import com.nva.pojo.Course;
import com.nva.pojo.Enrollment;
import com.nva.pojo.Forum;
import com.nva.pojo.Score;
import com.nva.pojo.Subject;
import com.nva.pojo.User;
import com.nva.pojo.Volume;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author nguye
 */
public class HibernateUtils {

    private static final SessionFactory factory;

    static {
        Configuration conf = new Configuration();

        Properties props = new Properties();

        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/gradedb");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "Admin@123");
        props.put(Environment.SHOW_SQL, true);

        conf.setProperties(props);

        conf.addAnnotatedClass(AddScore.class);
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(Course.class);
        conf.addAnnotatedClass(Enrollment.class);
        conf.addAnnotatedClass(Forum.class);
        conf.addAnnotatedClass(Score.class);
        conf.addAnnotatedClass(Subject.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Volume.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();

        factory = conf.buildSessionFactory(serviceRegistry);
    }

    /**
     * @return the factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }
}
