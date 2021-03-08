package com.xworkz.tester;

import com.xworkz.dao.FlightDAO;
import com.xworkz.dao.FlightDAOImpl;
import com.xworkz.dto.FlightDTO;
import com.xworkz.service.FlightService;
import com.xworkz.service.FlightServiceImpl;

public class Tester {

	public static void main(String[] args) {
		FlightDAO flightDAO = new FlightDAOImpl();
		FlightDTO flightDTO = new FlightDTO(16, "Air India", 4000, "Banglore", "Pune");
//		flightDAO.saveFlight(flightDTO);
//		flightDAO.readFlight(01);
//		flightDAO. updateFlight(3);
//		flightDAO.deleteFlight(11);
		
		FlightService flightService = new FlightServiceImpl(flightDAO);
		flightService.validateAndSave(flightDTO);
		flightService.validAndRead(14);
		flightService.validateAndUpdate(1);
		flightService.validateAndDelete(6);
	}

}
