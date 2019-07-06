package unmsm.fisi.calidad.servicios;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unmsm.fisi.calidad.entidades.Asignacion;
import unmsm.fisi.calidad.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;


public class AsignacionService {
    Logger LOGGER = LoggerFactory.getLogger(AsignacionService.class);


    public void asignacion(int curso_id, int usuario_id, int anio, String ciclo) throws SQLException {

        Asignacion asignacion =  new Asignacion();
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();


            asignacion.setCursoId(curso_id);
            asignacion.setUsuarioId(usuario_id);
            asignacion.setAnio(anio);
            asignacion.setCiclo(ciclo);
            session.persist(asignacion);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("asignacion cursos", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public ArrayList cursosAsignados(int usuarioId) throws SQLException {
        ArrayList lista = new ArrayList();

        String query = "select c.* from asignacion a " +
                "inner join curso c on c.id = a.curso_id " +
                "where a.usuario_id = ?";

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            NativeQuery nativeQuery = session.createNativeQuery(query)
                                        .setParameter(1, usuarioId);
            lista = (ArrayList) nativeQuery.getResultList();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("cursos asignados", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return lista;
    }
}
