package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    private static Session hibernateSession;

    public static Session getHibernateSession(){
        if(hibernateSession == null) {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
            SessionFactory factory = meta.getSessionFactoryBuilder().build();
            hibernateSession = factory.openSession();
            hibernateSession.beginTransaction();
        }
        return hibernateSession;
    }

    public static void saveOrUpdate(Object o){
        hibernateSession.saveOrUpdate(o);
        hibernateSession.getTransaction().commit();
    }


}
