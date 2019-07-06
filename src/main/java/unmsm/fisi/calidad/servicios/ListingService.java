package unmsm.fisi.calidad.servicios;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unmsm.fisi.calidad.entidades.Categoria;
import unmsm.fisi.calidad.entidades.Curso;
import unmsm.fisi.calidad.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import unmsm.fisi.calidad.entidades.Categoria;

public class ListingService {

    Logger LOGGER = LoggerFactory.getLogger(ListingService.class);

    public ArrayList listarCategorias() throws SQLException {
        List<Categoria> lista = new ArrayList();

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

             lista = session.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("categorias", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return (ArrayList) lista;
    }

    public ArrayList listarCursos() throws SQLException {
        ArrayList lista = new ArrayList();


        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            lista = (ArrayList) session.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("cursos", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }


}
