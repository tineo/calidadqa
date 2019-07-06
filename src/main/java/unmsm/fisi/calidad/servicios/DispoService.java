package unmsm.fisi.calidad.servicios;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unmsm.fisi.calidad.entidades.Disponibilidad;
import unmsm.fisi.calidad.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;

public class DispoService {
    Logger LOGGER = LoggerFactory.getLogger(DispoService.class);

    public int disponibilidad(int usuario_id, int categoria_id, int horas, String intervalo) throws SQLException {
        int rs = -1;

        Disponibilidad disponibilidad = new Disponibilidad();

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();



            disponibilidad.setUsuarioId(usuario_id);
            disponibilidad.setCategoriaId(categoria_id);
            disponibilidad.setHorasDisponibbles(horas);
            disponibilidad.setIntervaloDisponibles(intervalo);
            session.persist(disponibilidad);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("disponibilidad", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return rs;
    }

    public String obtenerInvervalo(int usuarioId) throws SQLException{

        String intervalo = "";
        String query = "select d.intervalo_disponibles from disponibilidad d where usuario_id = ?";

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();


            NativeQuery nativeQuery = session.createNativeQuery(query)
                    .setParameter(1, usuarioId);

            intervalo = String.valueOf(nativeQuery.getFirstResult());

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("intervalos", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return intervalo;
    }

    public Integer obtenerHorarioDispo(int usuarioId) throws SQLException{

        ArrayList lista = new ArrayList();
        Integer horasDispo = 0;
        String query = "select d.horas_disponibles from disponibilidad d where usuario_id = ?";


        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();


            NativeQuery nativeQuery = session.createNativeQuery(query)
                    .setParameter(1, usuarioId);

            horasDispo = nativeQuery.getFirstResult();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error("dispohoras", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return horasDispo;

    }

}
