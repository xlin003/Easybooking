package es.deusto.ingenieria.sd.eb.server.dao;

import java.util.List;
import es.deusto.ingenieria.sd.eb.server.data.Vuelo;
import es.deusto.ingenieria.sd.eb.server.data.dto.ReservaDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.eb.server.data.Reserva;
import es.deusto.ingenieria.sd.eb.server.data.Usuario;

public interface IEasybookingDAO {

	public void storeFlight(Vuelo vuelo);

	public void storeReserva(Reserva reserva);

	// public List<Reserva> getReservas();

	// public List<VueloDTO> getFlightList(Usuario user);

	public List<Reserva> getBookingList(Usuario user);

	public Reserva getBooking(Usuario usuario);

	public void updateBooking(Usuario usuario);

	public void deleteAllBookings();

	public void deleteBooking(long id);

	public void storeUser(UsuarioDTO u);

	public void storeBooking(Reserva booking);

}
