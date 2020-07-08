package pl.orlowski.sebastian;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBConfig implements ServletContextListener {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf = Persistence.createEntityManagerFactory("JavaEELearning");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (emf != null)
            emf.close();
    }
}
