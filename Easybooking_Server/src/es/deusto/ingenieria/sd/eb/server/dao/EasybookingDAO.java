package es.deusto.ingenieria.sd.eb.server.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.eb.server.data.Reserva;
import es.deusto.ingenieria.sd.eb.server.data.Usuario;
import es.deusto.ingenieria.sd.eb.server.data.Vuelo;
import es.deusto.ingenieria.sd.eb.server.data.assembler.EBAssembler;
import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public class EasybookingDAO implements IEasybookingDAO {

	private PersistenceManagerFactory pmf;
	private EBAssembler eba;

	public EasybookingDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Storing an object: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public void storeFlight(Vuelo f) {
		this.storeObject(f);
	}

	public void storeBooking(Reserva b) {
		this.storeObject(b);
	}

	public void storeUser(UsuarioDTO u) {
		Usuario user = new EBAssembler().userAssembler(u);
		this.storeObject(user);
	}

	@Override
	public List<Reserva> getBookingList(Usuario user) {
		List<VueloDTO> flist = new ArrayList<>();
		VueloDTO f;

		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Reserva> bookingList = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent booking list.");

			tx.begin();
			Extent<Reserva> extent = pm.getExtent(Reserva.class, true);

			for (Reserva booking : extent) {
				if (booking.getUser().getEmail().equals(user.getEmail())) {
					bookingList.add(new Reserva(booking.getId(), booking.getUser(), new Vuelo(
							booking.getFlight().getOriCity(), booking.getFlight().getDestCity(),
							booking.getFlight().getDate(), booking.getFlight().getNumSeatsLeft(),
							booking.getFlight().getAirline()), booking.getSeats()));

					flist.add(new VueloDTO(booking.getFlight().getOriCity(),
							booking.getFlight().getDestCity(), booking.getFlight().getDate(),
							booking.getFlight().getNumSeatsLeft(),
							booking.getFlight().getAirline()));
				}

			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving booking list: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		System.out.println(bookingList.size() + "<bookinglist size>");
		return bookingList;
	}

	@Override
	public Reserva getBooking(Usuario usuario) {
		return null;
	}

	@Override
	public void updateBooking(Usuario usuario) {

	}

	@Override
	public void deleteAllBookings() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query<Reserva> q = pm.newQuery(Reserva.class);
			q.deletePersistentAll();

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}


	@Override
	public void storeReserva(Reserva reserva) {

	}

	@Override
	public void deleteBooking(long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Deleting an object: " + id);
			Object obj = pm.getObjectById(Reserva.class, id);
			pm.deletePersistent(obj);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}
