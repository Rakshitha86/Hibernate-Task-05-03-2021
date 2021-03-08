package com.xworkz.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.dto.FlightDTO;

public class FlightDAOImpl implements FlightDAO {

	@Override
	public boolean saveFlight(FlightDTO dto) {
		SessionFactory sessionFactory = new Configuration().configure("hibernateFlight.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Serializable id = session.save(dto);
		System.out.println(id);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		return false;
	}

	@Override
	public boolean readFlight(int Flightid) {
		SessionFactory sessionFactory = new Configuration().configure("hibernateFlight.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
		System.out.println(flightDTO);
		session.close();
		sessionFactory.close();
		return false;
	}

	@Override
	public boolean updateFlight(int Flightid) {
		SessionFactory sessionFactory = new Configuration().configure("hibernateFlight.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
		flightDTO.setName("SpaceJet");
		Transaction transaction = session.beginTransaction();
		session.update(flightDTO);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return false;
	}

	@Override
	public boolean deleteFlight(int Flightid) {
		SessionFactory sessionFactory = new Configuration().configure("hibernateFlight.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
		Transaction transaction = session.beginTransaction();
		session.delete(flightDTO);
		transaction.commit();
		session.close();
		sessionFactory.close();		
		return false;
	}

}
