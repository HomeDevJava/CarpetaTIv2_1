package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**@author Nakura-gui <Jisashi.Nakamura at Nakcom.org> */
class HibernateHelper {

    private static StandardServiceRegistry ssr;
    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {
                ssr = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metadasource = new MetadataSources(ssr);
                Metadata metadata = metadasource.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(ssr!=null)
                StandardServiceRegistryBuilder.destroy(ssr);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}




/*    static {
//        try {
//            // Create the SessionFactory from standard (hibernate.cfg.xml) 
//            // config file.
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (HibernateException ex) {
//            // Log the exception. 
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
    }
 public static void hiber() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

*/