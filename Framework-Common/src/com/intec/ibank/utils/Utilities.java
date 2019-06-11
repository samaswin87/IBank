package com.intec.ibank.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.intec.ibank.log.IBankLogger;
import com.intec.ibank.system.SystemConstants;

/**
 * Copyright. Contains the Utility Classes for the application It is never
 * Instantiated in the application. The caller methods will use the static
 * methods in this class
 */
public final class Utilities {

	private Utilities() {
		super();
	}

	/**
	 * Checks if is empty value.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is empty value
	 */
	public static boolean isEmptyValue(String value) {
		return ((value == null) || (value.trim().length() == 0));
	}

	/**
	 * Checks if is value equals.
	 * 
	 * @param value1
	 *            the value1
	 * @param value2
	 *            the value2
	 * @return true, if is value equals
	 */
	public static boolean isValueEquals(String value1, String value2) {
		return isValueEquals(value1, value2, false);
	}

	/**
	 * Checks if is value equals.
	 * 
	 * @param value1
	 *            the value1
	 * @param value2
	 *            the value2
	 * @param isIgnoreCase
	 *            the is ignore case
	 * @return true, if is value equals
	 */
	public static boolean isValueEquals(String value1, String value2,
			boolean isIgnoreCase) {
		if (value1 == null)
			return (value2 == null);
		else {
			if (value2 == null)
				return false;
			return (isIgnoreCase ? value1.equalsIgnoreCase(value2) : value1
					.equals(value2));
		}
	}

	public static boolean isValueChanged(String value1, String value2) {
		return isValueChanged(value1, value2, false);
	}

	/**
	 * Checks if is value equals.
	 * 
	 * @param value1
	 *            the value1
	 * @param value2
	 *            the value2
	 * @param isIgnoreCase
	 *            the is ignore case
	 * @return true, if is value equals
	 */
	public static boolean isValueChanged(String value1, String value2,
			boolean isIgnoreCase) {
		if (value1 == null)
			return (value2 != null);
		else {
			if (value2 == null)
				return true;
			return (!(isIgnoreCase ? value1.equalsIgnoreCase(value2) : value1
					.equals(value2)));
		}
	}

	/**
	 * Gets the 12 hour date time string.
	 * 
	 * @param thisDate
	 *            the this date
	 * @return the 12 hour date time string
	 */
	public static final String get12HourDateTimeString(Date thisDate) {
		return get12HourDateTimeString(thisDate, "/", ":");
	}

	/**
	 * Gets the 12 hour date time string.
	 * 
	 * @param thisDate
	 *            the this date
	 * @param dateDelimiter
	 *            the date delimiter
	 * @param timeDelimiter
	 *            the time delimiter
	 * @return the 12 hour date time string
	 */
	public static final String get12HourDateTimeString(Date thisDate,
			String dateDelimiter, String timeDelimiter) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(thisDate);

		StringBuffer value = new StringBuffer("");
		value.append(cal.get(Calendar.DATE));
		value.append(dateDelimiter);
		value.append(String.valueOf(getMonth(cal)));
		value.append(dateDelimiter);
		value.append(cal.get(Calendar.YEAR));
		value.append(dateDelimiter);
		value.append(cal.get(Calendar.HOUR));
		value.append(timeDelimiter);
		value.append(cal.get(Calendar.MINUTE));
		value.append(timeDelimiter);
		value.append(cal.get(Calendar.SECOND));
		value.append(timeDelimiter);
		value.append(cal.get(Calendar.MILLISECOND));
		value.append("");
		value.append(getAM_PM(cal));
		System.out.println(cal.getTimeInMillis());
		return value.toString();
	}

	/**
	 * Gets the 24 hour date time string.
	 * 
	 * @param thisDate
	 *            the this date
	 * @return the 24 hour date time string
	 */
	public static final String get24HourDateTimeString(Date thisDate) {
		return get24HourDateTimeString(thisDate, "/", ":");
	}

	/**
	 * Gets the 24 hour date time string.
	 * 
	 * @param thisDate
	 *            the this date
	 * @param dateDelimiter
	 *            the date delimiter
	 * @param timeDelimiter
	 *            the time delimiter
	 * @return the 24 hour date time string
	 */
	public static final String get24HourDateTimeString(Date thisDate,
			String dateDelimiter, String timeDelimiter) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(thisDate);

		StringBuffer value = new StringBuffer("");
		value.append(cal.get(Calendar.DATE));
		value.append(dateDelimiter);
		value.append(String.valueOf(getMonth(cal)));
		value.append(dateDelimiter);
		value.append(cal.get(Calendar.YEAR));
		value.append(dateDelimiter);
		value.append(String.valueOf(get24Hour(cal)));
		value.append(timeDelimiter);
		value.append(cal.get(Calendar.MINUTE));
		value.append(timeDelimiter);
		value.append(cal.get(Calendar.SECOND));
		value.append(timeDelimiter);
		value.append(cal.get(Calendar.MILLISECOND));
		System.out.println(cal.getTimeInMillis());
		return value.toString();
	}

	/**
	 * Gets the 24 hour.
	 * 
	 * @param cal
	 *            the cal
	 * @return the 24 hour
	 */
	public static final int get24Hour(Calendar cal) {
		return (cal.get(Calendar.HOUR) + (cal.get(Calendar.AM_PM) * 12));
	}

	/**
	 * Gets the month.
	 * 
	 * @param cal
	 *            the cal
	 * @return the month
	 */
	public static final int getMonth(Calendar cal) {
		return (cal.get(Calendar.MONTH) + 1);
	}

	/**
	 * Gets the AM / PM value.
	 * 
	 * @param cal
	 *            the cal
	 * @return the AM / PM value
	 */
	public static final String getAM_PM(Calendar cal) {
		return ((cal.get(Calendar.AM_PM) == 0) ? "AM" : "PM");
	}

	/**
	 * Gets the protocol name.
	 * 
	 * @param uri
	 *            the uri
	 * @return the protocol name
	 */
	public static String getProtocolName(String uri) {
		if (isEmptyValue(uri))
			return "";
		int endIndex = uri.indexOf(':');
		if (endIndex < 0)
			return "";
		return uri.substring(0, endIndex);
		
	}

	
	 

	/**
	 * Gets the tag value.
	 * 
	 * @param currentElement
	 *            the current element
	 * @param tagName
	 *            the tag name
	 * @return the tag value
	 */
	public static String getTagValue(Element currentElement, String tagName) {
		NodeList tagNameElementList = currentElement
				.getElementsByTagName(tagName);
		Element tagNameElement = (Element) tagNameElementList.item(0);
		NodeList tagNamechildNodeList = tagNameElement.getChildNodes();
		String value = ((Node) tagNamechildNodeList.item(0)).getNodeValue();
		// System.out.println(tagName + " : " + value);
		return value;
	}

	/**
	 * Gets the boolean value.
	 * 
	 * @param value
	 *            the value
	 * @return the boolean value
	 */
	public static final boolean getBooleanValue(String value) {
		if (isValueEquals(value, Boolean.TRUE.toString(), true))
			return true;
		return false;
	}

	/**
	 * String to boolean.
	 * 
	 * @param value
	 *            the value
	 * @return true, if successful
	 */
	public static boolean stringToBoolean(String value) {
		if ((value != null) && value.equals("1"))
			return true;
		return false;
	}

	/**
	 * Boolean to string.
	 * 
	 * @param booleanValue
	 *            the boolean value
	 * @return the string
	 */
	public static String booleanToString(boolean booleanValue) {
		String strValue = booleanValue ? "1" : "0";
		return strValue;
	}

	/**
	 * Serialize.
	 * 
	 * @param obj
	 *            the obj
	 * @return the byte array output stream
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static ByteArrayOutputStream serialize(Serializable obj)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(obj);
		out.close();
		return baos;
	}

	/**
	 * Gets the serialized byte object.
	 * 
	 * @param obj
	 *            the obj
	 * @return the serialized byte object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static byte[] getSerializedByteObject(Serializable obj)
			throws IOException {
		ByteArrayOutputStream out = serialize(obj);
		byte[] byteObject = out.toByteArray();
		return byteObject;
	}

	/**
	 * De serialize.
	 * 
	 * @param byteObject
	 *            the byte object
	 * @return the serializable
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static Serializable deSerialize(byte[] byteObject)
			throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(byteObject);
		ObjectInputStream in = new ObjectInputStream(bais);
		in.close();
		return (Serializable) in.readObject();
	}

	/**
	 * Gets the xml to object.
	 * 
	 * @param xmlValue
	 *            the xml value
	 * @param className
	 *            the class name
	 * @param schemaFileName
	 *            the schema file name
	 * @return the xml to object
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Serializable getXmlToObject(String xmlValue,
			Class<? extends Serializable> className, String schemaFileName)
			throws JAXBException, IOException {
		try {
			JAXBContext context = JAXBContext.newInstance(className);
			javax.xml.bind.Unmarshaller um = context.createUnmarshaller();

			// The SchemaFactory instance
			if (!isEmptyValue(schemaFileName)) {

				// Schema validation
				// create an instance of the SchemaFactory for the W3C XML
				// Schema language:
				SchemaFactory sf = SchemaFactory
						.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

				try {
					InputStream ins = Utilities.class
							.getResourceAsStream(schemaFileName);

					if (ins == null)
						ins = ClassLoader
								.getSystemResourceAsStream(schemaFileName);

					if (ins == null)
						ins = Thread.currentThread().getContextClassLoader()
								.getResourceAsStream(schemaFileName);

					Schema schema;
					if (ins == null) {
						String realSchemaFileName = Utilities
								.getRealFileName(schemaFileName);
						schema = sf.newSchema(new File(realSchemaFileName));
					} else
						schema = sf.newSchema(new StreamSource(ins));// new
																		// File(schemaFileName));
					if (schema != null)
						um.setSchema(schema);
					
				} catch (SAXException e1) {
					IBankLogger.log(e1);
				}
			}
			StringReader reader = new StringReader(xmlValue);
			Serializable output = (Serializable) um.unmarshal(reader);
			return output;
		} catch (JAXBException ex) {
			IBankLogger.log(ex);
			throw ex;
		} finally {
		}
		// return null;
	}

	/**
	 * Gets the xml string.
	 * 
	 * @param obj
	 *            the obj
	 * @param schemaFileName
	 *            the schema file name
	 * @return the xml string
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String getXmlString(Serializable obj, String schemaFileName)
			throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		if (!isEmptyValue(schemaFileName)) {
			// Schema validation
			// create an instance of the SchemaFactory for the W3C XML Schema
			// language:
			SchemaFactory sf = SchemaFactory
					.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

			// The SchemaFactory instance
			try {
				ClassLoader.getSystemResource(schemaFileName);
				InputStream ins = ClassLoader
						.getSystemResourceAsStream(schemaFileName);
				Schema schema = sf.newSchema(new StreamSource(ins));// new
																	// File(schemaFileName));
				m.setSchema(schema);
			} catch (SAXException e1) {
				IBankLogger.log(e1);
			}
		}

		StringWriter w = null;
		StreamResult result = null;
		try {
			w = new StringWriter();
			result = new StreamResult(w);
			m.marshal(obj, result);
			return ((StringWriter) w).getBuffer().toString();
		} finally {
			try {
				w.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Gets the file as string.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the file as string
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String getFileAsString(String fileName)
			throws FileNotFoundException, IOException {
		File file = new File(fileName);
		StringBuffer strContent = new StringBuffer("");
		FileInputStream fin = new FileInputStream(file);

		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fin);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String strLine;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			strContent.append(strLine);
		}
		br.close();
		in.close();
		fin.close();

		return strContent.toString();
	}

	/**
	 * Gets the real file name.
	 * 
	 * @param relativeName
	 *            the relative name
	 * @return the real file name
	 */
	public static String getRealFileName(String relativeName) {
		if (isEmptyValue(relativeName))
			return null;
		URL url = ClassLoader.getSystemResource(relativeName);

		if (url == null) {
			url = Thread.currentThread().getContextClassLoader()
					.getResource(relativeName);
			if (url == null)
				return relativeName;
			else {
				File thisFile = new File(url.getFile());
				try {
					return thisFile.getPath().replaceAll("%20", " ");
				} catch (Exception ex) {
					return relativeName;
				}
			}
		}
		return ((url == null) ? relativeName : url.getFile().replaceAll("%20",
				" "));
	}

	/**
	 * Checks if is number.
	 * 
	 * @param token
	 *            the token
	 * @return true, if is number
	 */
	public static boolean isNumber(String token) {
		try {
			new BigDecimal(token);
			return true;
		} catch (NumberFormatException nfe) {
			IBankLogger.log(nfe);
		}
		return false;
	}

	/**
	 * Checks if is java identifier.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is a legal java identifier
	 */
	public static boolean isJavaIdentifier(String s) {
		if (s.length() == 0) {
			return false;
		}
		if (!Character.isJavaIdentifierStart(s.charAt(0))) {
			return false;
		}
		for (int i = 1; i < s.length(); i++) {
			if (!Character.isJavaIdentifierPart(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the file extension name.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the file extension name
	 */
	public static String getFileExtension(String fileName) {
		if (isEmptyValue(fileName))
			return null;
		int index = fileName.lastIndexOf('.');
		int length = fileName.length();
		if ((index != -1) && (length > index)) {
			return fileName.substring((index + 1), length);
		}
		return "";

	}

	public static Date stringtodate(String date) throws ParseException {
		String DATE_FORMAT_NOW = "yyyy-mm-dd";

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		Date da = sdf.parse(date);

		return da;
	}

	/**
	 * Current date.
	 * 
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public Date currentDate() throws ParseException {
		String DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String date1 = sdf.format(cal.getTime());
		Date date;

		date = (Date) sdf.parse(date1);
		return date;

	}

	public String currentDate1() throws ParseException {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = sdf.format(cal.getTime());

		return date1;

	}

	/**
	 * Gets the copy rights.
	 * 
	 * @return the copy rights
	 */
	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}

	public static boolean fileDelete(String fileName) {
		File fileObj = new File(fileName);
		if (fileObj.exists()) {
			fileObj.delete();
			return true;
		} else {
			return false;
		}

	}
}
