package com.fwd.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;

public class XmlUtils {

	// T inputObj should be have @XmlRootElement
	public static <T> void writeXml(String xmlFile, T inputObj) throws IOException, XMLStreamException, JAXBException {
		FileOutputStream adrFile = null;
		JAXBContext ctx;
	    try {
	    	adrFile = new FileOutputStream(xmlFile);	       
			ctx = JAXBContext.newInstance(inputObj.getClass());
	        Marshaller ma = ctx.createMarshaller();
	        ma.marshal(inputObj, adrFile);
	        ma.marshal(inputObj, System.out);
	    }
	    catch(IOException exc) {
	    	throw exc;
	    }
	    catch(JAXBException ex){
	    	throw ex;
	    }
	    finally {
	    	adrFile.close();
	    	adrFile = null;
	    	ctx = null;
	    }		
	}
	@SuppressWarnings("unchecked")
	public static <T> T readXml(String xmlFile, Class<T> clazz) throws IOException, XMLStreamException, JAXBException {		
		FileInputStream adrFile = null;
		JAXBContext ctx;
		try {
		    adrFile = new FileInputStream(xmlFile);
		    ctx = JAXBContext.newInstance(clazz);
		    Unmarshaller um = ctx.createUnmarshaller();
		    return (T) um.unmarshal(adrFile);
		}
		catch(IOException exc) {
			throw exc;
		}
		catch(JAXBException exc) {
			throw exc;
		}
		finally {
	    	adrFile.close();
	    	adrFile = null;
	    	ctx = null;
		}
	}
	
	public static <T> T readXml(URL url, Class<T> clazz) {		
		return (T) JAXB.unmarshal(url, clazz);
	}

}
