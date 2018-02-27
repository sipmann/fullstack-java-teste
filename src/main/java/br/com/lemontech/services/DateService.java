package br.com.lemontech.services;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

/**
 * DateService faz transformacoes nas datas
 * @author sipmann
 *
 */
@Component
public class DateService {
	/**
	 * Utilitário de transformação de valores/data
	 * 
	 * @param millisecond
	 *            Eg: new Date().getTime();
	 * @return
	 */
	public XMLGregorianCalendar getGregorianFromMilis(Long millisecond) {
		try {
			GregorianCalendar dt = new GregorianCalendar();
			dt.setTimeInMillis(millisecond);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(dt);
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Utilitário de transformação de valores/data
	 * 
	 * @param greg
	 * @return
	 */
	public java.sql.Date getDateFromGregorian(XMLGregorianCalendar greg) {
		java.sql.Date d = new java.sql.Date(greg.getMillisecond());
		return d;
	}
}
