package unmsm.fisi.calidad.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unmsm.fisi.calidad.entidades.*;


public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);


    private HibernateUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry)
                        .addAnnotatedClass(Usuario.class)
                        .addAnnotatedClass(Asignacion.class)
                        .addAnnotatedClass(Categoria.class)
                        .addAnnotatedClass(Curso.class)
                        .addAnnotatedClass(Disponibilidad.class)
                        .addAnnotatedClass(Escuela.class)
                        .addAnnotatedClass(Rol.class)
                        .addAnnotatedClass(Trabajador.class)
                            ;
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                LOGGER.error("context", e);
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}