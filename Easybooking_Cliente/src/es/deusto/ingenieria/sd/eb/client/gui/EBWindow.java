package es.deusto.ingenieria.sd.eb.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import es.deusto.ingenieria.sd.eb.client.controller.EBController;
import es.deusto.ingenieria.sd.eb.server.data.dto.ReservaDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import org.jdesktop.swingx.JXDatePicker;

public class EBWindow extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private EBController controller;
	private javax.swing.JButton jbBuscar;
	private javax.swing.JButton jbAceptarLogin;
	private javax.swing.JButton jbAceptarRegistro;
	private javax.swing.JButton jbCancelar;
	private javax.swing.JButton jbBook;
	private javax.swing.JButton jbExitFlight;
	private javax.swing.JButton jbExitLogin;
	private javax.swing.JButton jbDelete;

	private javax.swing.JButton jbRegistrar;
	private javax.swing.JLabel jlTitle;
	private javax.swing.JLabel jlFlightPanelTitle;
	private javax.swing.JLabel jlLoginPanelTitle;
	private javax.swing.JLabel jlRegisterPanelTitle;
	private javax.swing.JLabel jlOrigen;
	private javax.swing.JLabel jlDestino;
	private javax.swing.JLabel jlMailLogin;
	private javax.swing.JLabel jlMailRegistro;
	private javax.swing.JLabel jlPasswLogin;
	private javax.swing.JLabel jlPasswRegistro;
	private javax.swing.JLabel jlLogin;
	private javax.swing.JLabel jlApellido;
	private javax.swing.JLabel jlNombre;
	private javax.swing.JLabel jlUser;
	private javax.swing.JTextField jtfOriginCity;
	private javax.swing.JTextField jtfDestinationCity;
	private javax.swing.JTextField jtfEmailLogin;
	private javax.swing.JTextField jtfEmailRegistro;
	private javax.swing.JPasswordField jpfPasswordLogin;
	private javax.swing.JPasswordField jpfPasswordRegistro;
	private javax.swing.JTextField jtfNombre;
	private javax.swing.JTextField jtfApellido;
	private javax.swing.JScrollPane jspFlights;
	private javax.swing.JScrollPane jspBooking;
	private javax.swing.JPanel titlePanel;
	private javax.swing.JPanel flightPanel;
	private javax.swing.JPanel loginPanel;
	private javax.swing.JPanel jpBottom;
	private javax.swing.JPanel jpTop;
	private javax.swing.JRadioButton jrbFacebook;
	private javax.swing.JRadioButton jrbGoogle;
	private javax.swing.JSplitPane splitPaneLeft;
	private javax.swing.JSplitPane splitPaneRight;
	JComboBox<Integer> jcNumPassenger;
	private ButtonGroup group;
	private UsuarioDTO user;
	private JXDatePicker picker;
	private int num = 100;
	private String date;
	private String nombre;
	private boolean signin = false;
	private int count = 0;
	private int seats;

	final DefaultListModel<String> userFlights = new DefaultListModel<String>();
	final DefaultListModel<String> flights = new DefaultListModel<String>();
	private List<VueloDTO> flightList = new ArrayList<VueloDTO>();

	public EBWindow(EBController controller) {
		this.controller = controller;
		initComponents();
		this.setSize(1200, 700);
		this.setVisible(true);
		this.centreWindow();
	}

	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" }) ////// ??????
	JList list = new JList(flights);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JList list1 = new JList(userFlights);

	private void initComponents() {

		titlePanel = new javax.swing.JPanel();
		flightPanel = new javax.swing.JPanel();
		jpTop = new javax.swing.JPanel();
		jpBottom = new javax.swing.JPanel();
		loginPanel = new javax.swing.JPanel();
		jbBuscar = new javax.swing.JButton();
		jbAceptarRegistro = new javax.swing.JButton();
		jbAceptarLogin = new javax.swing.JButton();
		jbCancelar = new javax.swing.JButton();
		jbBook = new javax.swing.JButton();
		jbExitFlight = new javax.swing.JButton();
		jbExitLogin = new javax.swing.JButton();
		jbDelete = new javax.swing.JButton();
		jbRegistrar = new javax.swing.JButton();
		jlFlightPanelTitle = new javax.swing.JLabel();
		jlTitle = new javax.swing.JLabel();
		jlLoginPanelTitle = new javax.swing.JLabel();
		jlRegisterPanelTitle = new javax.swing.JLabel();
		jlUser = new javax.swing.JLabel();
		jlOrigen = new javax.swing.JLabel();
		jlDestino = new javax.swing.JLabel();
		jlMailLogin = new javax.swing.JLabel();
		jlPasswLogin = new javax.swing.JLabel();
		jlMailRegistro = new javax.swing.JLabel();
		jlPasswRegistro = new javax.swing.JLabel();
		jlLogin = new javax.swing.JLabel();
		jlNombre = new javax.swing.JLabel();
		jlApellido = new javax.swing.JLabel();
		jtfOriginCity = new javax.swing.JTextField();
		jtfDestinationCity = new javax.swing.JTextField();
		jtfEmailLogin = new javax.swing.JTextField();
		jtfEmailRegistro = new javax.swing.JTextField();
		jpfPasswordLogin = new javax.swing.JPasswordField();
		jpfPasswordRegistro = new javax.swing.JPasswordField();
		jtfApellido = new javax.swing.JTextField();
		jtfNombre = new javax.swing.JTextField();
		jrbFacebook = new javax.swing.JRadioButton();
		jrbGoogle = new javax.swing.JRadioButton();
		jspFlights = new javax.swing.JScrollPane(list);
		jspBooking = new javax.swing.JScrollPane(list1);
		// list1.removeAll();
		// userFlights.clear();
		splitPaneRight = new javax.swing.JSplitPane(JSplitPane.VERTICAL_SPLIT, jpTop, jspBooking);
		splitPaneLeft = new javax.swing.JSplitPane(JSplitPane.VERTICAL_SPLIT, jspFlights, jpBottom);

		// setLayout(new FlowLayout());
		picker = new JXDatePicker();
		picker.setDate(Calendar.getInstance().getTime());
		picker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		Date oDate = picker.getDate();
		DateFormat oDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		date = new String();
		date = oDateFormat.format(oDate);

		setTitle("EasyBooking");
		setName("EasyBooking");
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm(evt);
			}
		});

		jrbGoogle.setText("Google");
		jrbFacebook.setText("Facebook");
		list.setFont(new Font("times new roman", Font.BOLD, 15));

		flightPanel.setLayout(null); // turn the LayoutManager off
		loginPanel.setLayout(null);
		jpBottom.setLayout(null);
		jpTop.setLayout(null);
		getContentPane().add(flightPanel, BorderLayout.WEST);
		jspFlights.setPreferredSize(new Dimension(40, 0));
		jlTitle.setText("EasyBooking - Flight booking system");
		jlTitle.setFont(jlTitle.getFont().deriveFont(25.0f));
		Border jlTitleBorder = jlTitle.getBorder();
		Border jlTitleMargin = new EmptyBorder(10, 10, 10, 10);
		jlTitle.setBorder(new CompoundBorder(jlTitleBorder, jlTitleMargin));

		jlFlightPanelTitle.setText("Flight booking");
		jlFlightPanelTitle.setBounds(263, 20, 300, 50);
		jlFlightPanelTitle.setFont(jlFlightPanelTitle.getFont().deriveFont(25.0f));
		Border jlFlightPanelTitleBorder = jlFlightPanelTitle.getBorder();
		Border jlFlightPanelTitleMargin = new EmptyBorder(10, 10, 10, 10);
		jlFlightPanelTitle
				.setBorder(new CompoundBorder(jlFlightPanelTitleBorder, jlFlightPanelTitleMargin));

		jlLoginPanelTitle.setText("Login");
		jlLoginPanelTitle.setBounds(200, 20, 300, 50);
		jlLoginPanelTitle.setFont(jlLoginPanelTitle.getFont().deriveFont(25.0f));
		Border jlLoginPanelTitleBorder = jlLoginPanelTitle.getBorder();
		Border jlLoginPanelTitleMargin = new EmptyBorder(10, 10, 10, 10);
		jlLogin.setBorder(new CompoundBorder(jlLoginPanelTitleBorder, jlLoginPanelTitleMargin));

		jlRegisterPanelTitle.setText("Registro");
		jlRegisterPanelTitle.setBounds(200, 20, 300, 50);
		jlRegisterPanelTitle.setFont(jlRegisterPanelTitle.getFont().deriveFont(25.0f));
		Border jlRegisterPanelTitleBorder = jlLoginPanelTitle.getBorder();
		Border jlRegisterPanelTitleMargin = new EmptyBorder(10, 10, 10, 10);
		jlLogin.setBorder(
				new CompoundBorder(jlRegisterPanelTitleBorder, jlRegisterPanelTitleMargin));

		jlLogin.setText("Login");
		jlLogin.setFont(jlLogin.getFont().deriveFont(16.0f));
		Border jlLoginBorder = jlLoginPanelTitle.getBorder();
		Border jlLoginMargin = new EmptyBorder(10, 10, 10, 10);
		jlLoginPanelTitle.setBorder(new CompoundBorder(jlLoginBorder, jlLoginMargin));
		jbBuscar = new JButton("Buscar");
		jbAceptarLogin = new JButton("Aceptar");
		jbAceptarRegistro = new JButton("Aceptar");
		jbCancelar = new JButton("Cancelar");
		jbRegistrar = new JButton("Registrar");
		jbBook = new JButton("Book");
		jbExitFlight = new JButton("Exit");
		jbExitLogin = new JButton("Exit");
		jbDelete = new JButton("Del");

		jlOrigen.setText("Origen");
		jlOrigen.setFont(jlOrigen.getFont().deriveFont(18.0f));
		jlDestino.setText("Destino");
		jlDestino.setFont(jlDestino.getFont().deriveFont(18.0f));
		titlePanel.add(jlTitle);
		titlePanel.setPreferredSize(new Dimension(100, 70));
		titlePanel.setBackground(Color.yellow);

		jlMailLogin.setText("Email");
		jlMailRegistro.setText("Email");
		jlMailLogin.setFont(jlMailLogin.getFont().deriveFont(18.0f));
		jlMailRegistro.setFont(jlMailRegistro.getFont().deriveFont(18.0f));
		jlPasswLogin.setText("Password");
		jlPasswRegistro.setText("Password");
		jlPasswLogin.setFont(jlPasswLogin.getFont().deriveFont(18.0f));
		jlPasswRegistro.setFont(jlPasswRegistro.getFont().deriveFont(18.0f));
		jlNombre.setText("Nombre");
		jlNombre.setFont(jlNombre.getFont().deriveFont(18.0f));
		jlApellido.setText("Apellido");
		jlApellido.setFont(jlApellido.getFont().deriveFont(18.0f));
		jlMailRegistro.setText("Email");
		jlMailRegistro.setFont(jlMailRegistro.getFont().deriveFont(18.0f));
		jlPasswRegistro.setText("Password");
		jlPasswRegistro.setFont(jlPasswRegistro.getFont().deriveFont(18.0f));
		jlUser.setFont(jlUser.getFont().deriveFont(18.0f));

		jlMailLogin.setBounds(50, 150, 90, 20);
		jlPasswLogin.setBounds(50, 230, 120, 20);
		jlNombre.setBounds(50, 180, 120, 20);
		jlApellido.setBounds(50, 100, 120, 20);
		jlMailRegistro.setBounds(50, 260, 120, 20);
		jlPasswRegistro.setBounds(50, 340, 120, 20);

		jtfEmailLogin.setBounds(200, 145, 200, 30);
		jpfPasswordLogin.setBounds(200, 225, 200, 30);
		jtfApellido.setBounds(200, 95, 200, 30);
		jtfNombre.setBounds(200, 175, 200, 30);
		jtfEmailRegistro.setBounds(200, 255, 200, 30);
		jpfPasswordRegistro.setBounds(200, 335, 200, 30);

		flightPanel.add(jbBuscar);
		flightPanel.add(jtfOriginCity);
		flightPanel.add(jtfDestinationCity);
		loginPanel.add(jlLoginPanelTitle);
		loginPanel.add(jlMailLogin);
		loginPanel.add(jlPasswLogin);
		loginPanel.add(jlLogin);
		loginPanel.add(jtfEmailLogin);
		loginPanel.add(jpfPasswordLogin);
		loginPanel.add(jtfEmailRegistro);
		loginPanel.add(jpfPasswordRegistro);
		loginPanel.add(jtfNombre);
		loginPanel.add(jtfApellido);
		loginPanel.add(jrbFacebook);
		loginPanel.add(jrbGoogle);
		loginPanel.add(jbAceptarLogin);
		loginPanel.add(jbAceptarRegistro);
		loginPanel.add(jbCancelar);
		loginPanel.add(jbRegistrar);
		loginPanel.add(jlNombre);
		loginPanel.add(jlApellido);
		loginPanel.add(jlMailRegistro);
		loginPanel.add(jlPasswRegistro);
		loginPanel.add(jlRegisterPanelTitle);

		jbBuscar.setBounds(360, 380, 90, 30);
		jbAceptarRegistro.setBounds(320, 400, 100, 30);
		jbAceptarLogin.setBounds(320, 350, 100, 30);
		jbRegistrar.setBounds(160, 350, 100, 30);
		jbCancelar.setBounds(160, 400, 100, 30);
		jbBook.setBounds(560, 20, 80, 30);
		jbExitFlight.setBounds(400, 20, 80, 30);
		flightPanel.add(jlFlightPanelTitle, BorderLayout.CENTER);
		flightPanel.add(jlOrigen);
		jlOrigen.setBounds(100, 150, 90, 20);
		flightPanel.add(jlDestino);
		jlDestino.setBounds(100, 230, 90, 20);
		jtfOriginCity.setBounds(200, 145, 250, 30);
		jtfDestinationCity.setBounds(200, 225, 250, 30);
		jrbFacebook.setBounds(200, 280, 100, 30);
		jrbGoogle.setBounds(320, 280, 100, 30);
		jrbFacebook.setBackground(Color.GRAY);
		jrbGoogle.setBackground(Color.GRAY);
		group = new ButtonGroup();
		jrbFacebook.setActionCommand("Facebook");
		jrbGoogle.setActionCommand("Google");
		group.add(jrbFacebook);
		group.add(jrbGoogle);
		jlNombre.setVisible(false);
		jlApellido.setVisible(false);
		jtfNombre.setVisible(false);
		jtfApellido.setVisible(false);
		jbCancelar.setVisible(false);
		jbAceptarRegistro.setVisible(false);
		jlMailRegistro.setVisible(false);
		jlPasswRegistro.setVisible(false);
		jtfEmailRegistro.setVisible(false);
		jpfPasswordRegistro.setVisible(false);
		jlRegisterPanelTitle.setVisible(false);
		// jspFlights.setVisible(false);
		// flightPanel.setVisible(true);
		jpBottom.add(jbBook);
		jpBottom.add(jbExitFlight);

		flightPanel.setPreferredSize(new Dimension(700, 620));
		jspFlights.setPreferredSize(new Dimension(696, 520));
		jspFlights.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"Current Flights", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("times new roman", Font.BOLD, 30)));
		// jpBottom.setPreferredSize(new Dimension(500, 300));
		splitPaneLeft.setPreferredSize(new Dimension(696, 620));
		splitPaneRight.setPreferredSize(new Dimension(496, 620));

		jbRegistrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jbRegistrarActionPerformed(e);
			}
		});

		jbCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jbCancelarActionPerformed(e);
			}
		});

		jbBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jbBuscarActionPerformed(e);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		jbExitFlight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jbExitFlightActionPerformed(e);
			}
		});

		jbBook.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jbBookActionPerformed(e);

			}
		});

		jbAceptarLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jbAceptarLoginActionPerformed(e);
			}
		});

		jbDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jbDeleteActionPerformed(e);
			}
		});

		jbExitLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jbExitLoginActionPerformed(e);
				// loginPanelShow(true);
			}
		});

		getContentPane().add(flightPanel, BorderLayout.LINE_START);
		getContentPane().add(titlePanel, BorderLayout.PAGE_START);
		flightPanel.setBackground(Color.LIGHT_GRAY);
		jspFlights.setBackground(Color.LIGHT_GRAY);
		jcNumPassenger = new JComboBox<Integer>();
		for (int i = 1; i <= num; i++) {
			jcNumPassenger.addItem(new Integer(i));
		}
		jcNumPassenger.setBounds(200, 297, 50, 24);
		picker.setBounds(330, 297, 120, 24);
		jlUser.setBounds(10, 10, 200, 20);
		jbExitLogin.setBounds(380, 10, 60, 20);
		jbDelete.setBounds(300, 10, 60, 20);
		flightPanel.add(jcNumPassenger);
		flightPanel.add(picker);
		getContentPane().add(loginPanel, BorderLayout.LINE_END);
		loginPanel.setPreferredSize(new Dimension(500, 620));
		loginPanel.setBackground(Color.GRAY);
		jpTop.add(jlUser);
		jpTop.add(jbExitLogin);
		jpTop.add(jbDelete);
		jpTop.setPreferredSize(new Dimension(496, 50));
		jspBooking.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"My Flights", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("times new roman", Font.BOLD, 30)));
		getContentPane().validate();
		getContentPane().repaint();
	}

	private void jbDeleteActionPerformed(ActionEvent evt) {
		System.out.println("deleting...");
		if (list1.isSelectionEmpty()) {
			System.out.println("Select the booking to delete");
		} else {
			String[] arrayFlightInfo = ((String) list1.getSelectedValue()).split(" ");
			long cod = Long.parseLong(arrayFlightInfo[2]);
			String ciudadOrigen = arrayFlightInfo[4];
			String ciudadDestino = arrayFlightInfo[6];
			String fecha = arrayFlightInfo[8];
			String airline = arrayFlightInfo[10];
			int num = Integer.parseInt(arrayFlightInfo[13]);

			int index = list1.getSelectedIndex();
			if (index >= 0) {
				userFlights.removeElementAt(index);
			}
			VueloDTO flight = new VueloDTO(ciudadOrigen, ciudadDestino, fecha, num, airline);
			try {
				controller.deleteBooking(cod, flight, user, seats);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void jbBookActionPerformed(ActionEvent evt) {
		List<ReservaDTO> bookingList = new ArrayList<>();
		user = new UsuarioDTO(null, null, jtfEmailLogin.getText(), null, null);
		if (signin == false) {
			System.out.println("You must to log in first");
		} else {

			if (list.isSelectionEmpty()) {
				System.out.println("select the flight to book");

			} else {
				String[] arrayFlightInfo = ((String) list.getSelectedValue()).split(" ");
				String ciudadOrigen = arrayFlightInfo[2];
				String ciudadDestino = arrayFlightInfo[4];
				String fecha = arrayFlightInfo[7];
				seats = (Integer) jcNumPassenger.getSelectedItem();
				String airline = arrayFlightInfo[10];
				VueloDTO flight = new VueloDTO(ciudadOrigen, ciudadDestino, fecha, num, airline);
				userFlights.clear();

				try {
					controller.storeBooking(flight, user, seats);
					bookingList = controller.getBookings(user);
					for (ReservaDTO b : bookingList) {
						userFlights.addElement(" # " + b.getId() + "  " + b.getFlight().getOriCity()
								+ " - " + b.getFlight().getDestCity() + "  "
								+ b.getFlight().getDate() + "  " + b.getFlight().getAirline()
								+ " airline  " + b.getSeats() + " passenger");
					}
					System.out.println("User flight size: " + userFlights.size());
					flightList.clear();

				} catch (RemoteException | NullPointerException e) {
					e.printStackTrace();
					System.out.println("RE or NPE Error");
				}
				getContentPane().validate();
				getContentPane().repaint();

				// System.out.println(list.getSelectedValue());
			}

		}
	}

	private void jbExitFlightActionPerformed(ActionEvent evt) {

		controller.clearList();
		flights.removeAllElements();
		getContentPane().remove(splitPaneLeft);
		getContentPane().add(flightPanel, BorderLayout.LINE_START);
		getContentPane().validate();
		getContentPane().repaint();
	}

	private void jbExitLoginActionPerformed(ActionEvent evt) {
		userFlights.clear();
		getContentPane().remove(splitPaneRight);
		getContentPane().add(loginPanel, BorderLayout.LINE_END);
		getContentPane().validate();
		getContentPane().repaint();
	}

	private void jbBuscarActionPerformed(ActionEvent evt) throws RemoteException {
		picker.setDate(picker.getDate());
		picker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		Date oDate = picker.getDate();
		DateFormat oDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		date = new String();
		date = oDateFormat.format(oDate);

		if (jtfOriginCity.getText().equals("")) {
			System.out.println("The Origin city can not be empty");
		} else if (jtfDestinationCity.getText().equals("")) {
			System.out.println("The Destination city can not be empty");
		} else {
			int numPassenger = (Integer) jcNumPassenger.getSelectedItem();
			// System.out.println(flightList.size());
			// System.out.println(jtfOriginCity.getText());
			// System.out.println(jtfDestinationCity.getText());
			// System.out.println(date);
			// System.out.println(numPassenger);

			flightList = controller.buscarVuelos(jtfOriginCity.getText(),
					jtfDestinationCity.getText(), date, numPassenger);
			for (VueloDTO f : flightList) {
				flights.addElement(" $ " + f.getOriCity() + " - " + f.getDestCity() + "   "
						+ f.getDate() + "   " + f.getAirline() + " Airline " + f.getNumSeatsLeft()
						+ " seats left...");
			}
			getContentPane().remove(flightPanel);
			getContentPane().add(splitPaneLeft, BorderLayout.LINE_START);
			getContentPane().validate();
			getContentPane().repaint();
		}
	}

	private void loginPanelShow(boolean show) {
		jrbFacebook.setVisible(show);
		jrbGoogle.setVisible(show);
		jlMailLogin.setVisible(show);
		jlPasswLogin.setVisible(show);
		jtfEmailLogin.setVisible(show);
		jpfPasswordLogin.setVisible(show);
		jbAceptarLogin.setVisible(show);
		jbRegistrar.setVisible(show);
		jlLoginPanelTitle.setVisible(show);
	}

	private void signUpShow(boolean show) {
		jlMailRegistro.setVisible(show);
		jlPasswRegistro.setVisible(show);
		jtfEmailRegistro.setVisible(show);
		jpfPasswordRegistro.setVisible(show);
		jbAceptarRegistro.setVisible(show);
		jlApellido.setVisible(show);
		jlNombre.setVisible(show);
		jtfApellido.setVisible(show);
		jtfNombre.setVisible(show);
		jbCancelar.setVisible(show);
		jlRegisterPanelTitle.setVisible(show);
	}

	private void jbCancelarActionPerformed(ActionEvent evt) {
		loginPanelShow(true);
		signUpShow(false);
	}

	private void jbRegistrarActionPerformed(ActionEvent evt) {
		signUpShow(true);
		loginPanelShow(false);
	}

	private void jbAceptarLoginActionPerformed(ActionEvent evt) {
		List<VueloDTO> flightList = new ArrayList<>();
		List<ReservaDTO> bookingList = new ArrayList<>();
		user = new UsuarioDTO(null, null, jtfEmailLogin.getText(), null, null);
		System.out.println("   £ Getting flights...");
		// controller.registrarse(u);
		if (jtfEmailLogin.getText().equals("")) {
			System.out.println("Enter the user mail");
		} else if (jpfPasswordLogin.getPassword().length == 0) {
			System.out.println("Enter the user password");
		} else {
			try {

				char[] pass = jpfPasswordLogin.getPassword();
				String choice = group.getSelection().getActionCommand();
				if (controller.iniciarSesion(new UsuarioDTO(null, null, jtfEmailLogin.getText(),
						new String(pass), choice))) {
					jlUser.setText("Hello " + controller.getUserName() + "...");
					bookingList = controller.getBookings(user);
					System.out.println("   £ Booking list size: " + flightList.size());//////////
					for (ReservaDTO b : bookingList) {
						userFlights.addElement(" # " + b.getId() + "  " + b.getFlight().getOriCity()
								+ " - " + b.getFlight().getDestCity() + "  "
								+ b.getFlight().getDate() + "  " + b.getFlight().getAirline()
								+ " airline  " + b.getSeats() + " passenger");
					}
					System.out.println("   £ User flight size: " + userFlights.size());
					flightList.clear();
					getContentPane().add(splitPaneRight);
					getContentPane().remove(loginPanel);
					getContentPane().validate();
					getContentPane().repaint();
					signin = true;
				} else {
					System.out.println("Oppps... the account does not exist. Go to sign up");
				}

			} catch (RemoteException e) {
				System.err.println("RE or NPE error");
				e.printStackTrace();

			}

		}

	}

	/** Exit the Application */
	private void exitForm(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_exitForm
		controller.exit();
	}
}
