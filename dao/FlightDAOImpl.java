package com.xworkz.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.dto.FlightDTO;

public class FlightDAOImpl implements FlightDAO {

	@Override
	public boolean saveFlight(FlightDTO dto) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration().configure("hibernateFlight.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Serializable id = session.save(dto);
			System.out.println(id);
			transaction.commit();
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		} finally {
			try {
				if (session != null)
					session.close();
				if (sessionFactory != null)
					sessionFactory.close();

			} catch (HibernateException e2) {
				// TODO: handle exception
			}

		}

		return false;
	}

	@Override
	public boolean readFlight(int Flightid) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration().configure("hibernateFlight.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
			System.out.println(flightDTO);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		} finally {
			try {
				if (session != null)
					session.close();
				if (sessionFactory != null)
					sessionFactory.close();

			} catch (HibernateException e2) {
				// TODO: handle exception
			}

		}

		return false;
	}

	@Override
	public boolean updateFlight(int Flightid) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration().configure("hibernateFlight.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
			flightDTO.setName("SpaceJet");
			Transaction transaction = session.beginTransaction();
			session.update(flightDTO);
			transaction.commit();
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		} finally {
			try {
				if (session != null)
					session.close();
				if (sessionFactory != null)
					sessionFactory.close();

			} catch (HibernateException e2) {
				// TODO: handle exception
			}

		}

		return false;
	}

	@Override
	public boolean deleteFlight(int Flightid) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration().configure("hibernateFlight.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			FlightDTO flightDTO = session.get(FlightDTO.class, Flightid);
			Transaction transaction = session.beginTransaction();
			session.delete(flightDTO);
			transaction.commit();
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		} finally {
			try {
				if (session != null)
					session.close();
				if (sessionFactory != null)
					sessionFactory.close();

			} catch (HibernateException e2) {
				// TODO: handle exception
			}

		}

		return false;
	}

}
