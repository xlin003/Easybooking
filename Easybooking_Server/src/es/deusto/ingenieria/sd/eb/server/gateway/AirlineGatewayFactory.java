package es.deusto.ingenieria.sd.eb.server.gateway;

import java.util.ArrayList;
import java.util.List;

public class AirlineGatewayFactory {

	IAirlineGateway airlineGateway;
	IAirlineGateway airlineGateway1;
	IAirlineGateway airlineGateway2;
	private int airNum = 1;

	private String[] args;
	private List<IAirlineGateway> airlineGatewayList = new ArrayList<IAirlineGateway>();

	public List<IAirlineGateway> getAirlineGatewayList() {
		return airlineGatewayList;
	}

	public void setAirlineGatewayList(List<IAirlineGateway> airlineGatewayList) {
		this.airlineGatewayList = airlineGatewayList;
	}

	public AirlineGatewayFactory(String[] args) {
		this.args = args;
	}

	public int checkAirNum(String airline) {
		if (airline.equals("Allairline"))
			this.setAirNum(2);
		else
			this.setAirNum(1);
		return airNum;
	}

	public List<IAirlineGateway> createAirlineGateway(String flightArgs) {
		String[] arrayflightArgs = flightArgs.split("#");

		if (arrayflightArgs[6].equals("Iberia")) {
			airlineGateway = new BuscarVueloIberia();
			airlineGatewayList.add(airlineGateway);
		} else if (arrayflightArgs[6].equals("Lufthansa")) {
			airlineGateway = new BuscarVueloLufthansa(args);
			airlineGatewayList.add(airlineGateway);
		} else if (arrayflightArgs[6].equals("Allairline")) {
			airlineGateway1 = new BuscarVueloIberia();
			airlineGateway2 = new BuscarVueloLufthansa(args);
			airlineGatewayList.add(airlineGateway1);
			airlineGatewayList.add(airlineGateway2);
		} else {
			System.err.println("Error airline kind");
		}
		System.out.println("airline size" + airlineGatewayList.size());
		return airlineGatewayList;

	}

	public int getAirNum() {
		return airNum;
	}

	public void setAirNum(int airNum) {
		this.airNum = airNum;
	}

}
