package com.xworkz.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class FlightDTO implements Serializable {

	@Id
	@Column(name = "flight_id")
	private int id;

	@Column(name = "flight_name")
	private String name;

	@Column(name = "flight_fuelcapacity")
	private int fuelCapacity;

	@Column(name = "flight_source")
	private String source;

	@Column(name = "flight_destination")
	private String destination;

	public FlightDTO() {
		System.out.println("Invoked Default dto");
	}

	public FlightDTO(int id, String name, int fuelCapacity, String source, String destination) {

		this.id = id;
		this.name = name;
		this.fuelCapacity = fuelCapacity;
		this.source = source;
		this.destination = destination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "FlightDTO [id=" + id + ", name=" + name + ", fuelCapacity=" + fuelCapacity + ", source=" + source
				+ ", destination=" + destination + "]";
	}

}
