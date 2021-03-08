package com.xworkz.service;

import com.xworkz.dto.FlightDTO;

public interface FlightService {

	boolean validateAndSave(FlightDTO flightDTO);

	void validAndRead(int flightId);

	void validateAndUpdate(int flightId);

	void validateAndDelete(int flightId);
}
