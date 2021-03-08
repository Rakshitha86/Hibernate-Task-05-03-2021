package com.xworkz.service;

import com.xworkz.dao.FlightDAO;
import com.xworkz.dto.FlightDTO;

public class FlightServiceImpl implements FlightService {
	private FlightDAO dao;

	public FlightServiceImpl(FlightDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean validateAndSave(FlightDTO flightDTO) {
		boolean validData = false;
		if (flightDTO != null) {
			System.out.println("dto is not null, can validate");
			int id = flightDTO.getId();
			if (id > 0) {
				System.out.println("id is valid");
				validData = true;
			} else {
				System.out.println("id is not valid");
				validData = false;
			}
			if (validData) {
				String name = flightDTO.getName();
				if (name != null && !name.isEmpty() && !name.contentEquals(" ")) {
					System.out.println("name is valid");
					validData = true;
				} else {
					System.out.println("name is not valid");
					validData = false;
				}
			}

			if (validData) {
				double fuelCapacity = flightDTO.getFuelCapacity();
				if (fuelCapacity != 0 && fuelCapacity > 2000) {
					System.out.println("fuelCapacity is valid");
					validData = true;
				} else {
					System.out.println("fuelCapacity is not valid");
					validData = false;
				}
			}
			if (validData) {
				String source = flightDTO.getSource();
				if (source != null && !source.isEmpty() && !source.contentEquals(" ")) {
					System.out.println("source is valid");
					validData = true;
				} else {
					System.out.println("source is not valid");
					validData = false;
				}
			}
			if (validData) {
				String destination = flightDTO.getDestination();
				if (destination != null && !destination.isEmpty() && !destination.contentEquals(" ")) {
					System.out.println("destination is valid");
					validData = true;
				} else {
					System.out.println("destination is not valid");
					validData = false;
				}
			}
			if (validData) {
				System.out.println("Invoke save method, data is valid");
				dao.saveFlight(flightDTO);
			}

		} else {
			System.out.println("dto is null, invalid data");
		}
		return false;
	}

	@Override
	public void validAndRead(int flightId) {
		if (flightId > 0) {
			System.out.println(" id is valid, can read: " + flightId);
			this.dao.readFlight(flightId);
		} else {
			System.out.println("invalid id");
		}
	}

	@Override
	public void validateAndUpdate(int flightId) {
		if (flightId > 0) {
			System.out.println(" id is valid, can update: " + flightId);
			this.dao.updateFlight(flightId);
		} else {
			System.out.println("invalid id");
		}

	}

	@Override
	public void validateAndDelete(int flightId) {
		if (flightId > 0) {
			System.out.println(" id is valid, can delete: " + flightId);
			this.dao.deleteFlight(flightId);
		} else {
			System.out.println("invalid id");
		}
	}

	
}
