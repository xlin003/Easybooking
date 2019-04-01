package es.deusto.ingenieria.sd.eb.server.data.assembler;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.eb.server.data.Reserva;
import es.deusto.ingenieria.sd.eb.server.data.Usuario;
import es.deusto.ingenieria.sd.eb.server.data.Vuelo;
import es.deusto.ingenieria.sd.eb.server.data.dto.ReservaDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public class EBAssembler {

	public EBAssembler() {

	}

	public List<UsuarioDTO> usersAssemblerDTO(List<Usuario> users) {
		List<UsuarioDTO> userDTOList = new ArrayList<>();

		for (Usuario u : users) {
			userDTOList.add(new UsuarioDTO(u.getSurname(), u.getName(), u.getEmail(),
					u.getPassword(), u.getAutorizationKind()));
		}

		System.out.println("* Assembling Users ...");

		return userDTOList;
	}

	public List<Usuario> usersAssembler(List<UsuarioDTO> userDTOs) {
		List<Usuario> userList = new ArrayList<>();

		for (UsuarioDTO u : userDTOs) {
			userList.add(new Usuario(u.getSurname(), u.getName(), u.getEmail(), u.getPassword(),
					u.getAutorizationKind()));
		}

		System.out.println("* Assembling Users ...");

		return userList;
	}

	public Usuario userAssembler(UsuarioDTO udto) {

		Usuario user = new Usuario(udto.getSurname(), udto.getName(), udto.getEmail(),
				udto.getPassword(), udto.getAutorizationKind());

		return user;
	}

	public UsuarioDTO userAssemblerDTO(Usuario u) {

		UsuarioDTO user = new UsuarioDTO(u.getSurname(), u.getName(), u.getEmail(), u.getPassword(),
				u.getAutorizationKind());

		return user;
	}

	public Reserva bookingAssembler(ReservaDTO bdto) {

		Reserva booking = new Reserva(bdto.getId(), userAssembler(bdto.getUser()),
				flightAssembler(bdto.getFlight()), bdto.getSeats());
		return booking;
	}

	public Vuelo flightAssembler(VueloDTO fdto) {

		Vuelo flight = new Vuelo(fdto.getOriCity(), fdto.getDestCity(), fdto.getDate(),
				fdto.getNumSeatsLeft(), fdto.getAirline());

		return flight;
	}

	public VueloDTO flightAssemblerDTO(Vuelo f) {

		VueloDTO fdto = new VueloDTO(f.getOriCity(), f.getDestCity(), f.getDate(),
				f.getNumSeatsLeft(), f.getAirline());

		return fdto;
	}

	public List<VueloDTO> flightsAssemblerDTO(List<Vuelo> flights) {
		List<VueloDTO> flightDTOList = new ArrayList<>();

		for (Vuelo f : flights) {
			flightDTOList.add(new VueloDTO(f.getOriCity(), f.getDestCity(), f.getDate(),
					f.getNumSeatsLeft(), f.getAirline()));
		}
		System.out.println("* Assembling Flights ...");

		return flightDTOList;
	}

	public List<Vuelo> flightsAssembler(List<VueloDTO> flightDTOs) {
		List<Vuelo> flightList = new ArrayList<>();

		for (VueloDTO fdto : flightDTOs) {
			flightList.add(new Vuelo(fdto.getOriCity(), fdto.getDestCity(), fdto.getDate(),
					fdto.getNumSeatsLeft(), fdto.getAirline()));
		}

		System.out.println("* Assembling Flights ...");

		return flightList;
	}

	public List<ReservaDTO> bookingsAssemblerDTO(List<Reserva> bookingList) {
		List<ReservaDTO> bookingDTOList = new ArrayList<>();
		for (Reserva b : bookingList) {
			bookingDTOList.add(new ReservaDTO(b.getId(), userAssemblerDTO(b.getUser()),
					flightAssemblerDTO(b.getFlight()), b.getSeats()));
		}
		System.out.println("* Assembling BookingList ...");

		return bookingDTOList;
	}

	public List<Reserva> bookingsAssembler(List<ReservaDTO> bookingDTOs) {
		List<Reserva> bookingList = new ArrayList<>();

		for (ReservaDTO bdto : bookingDTOs) {
			bookingList.add(new Reserva(bdto.getId(), userAssembler(bdto.getUser()),
					flightAssembler(bdto.getFlight()), bdto.getSeats()));
		}

		System.out.println("* Assembling BookingList ...");

		return bookingList;
	}
}
