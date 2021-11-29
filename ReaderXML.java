package interface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ReaderXML{
	public static void xml_reader(String name) {
		
		static ArrayList<> read_client(XMLStreamReader r){
			
		}
		
		static ArrayList<> read_fournisseur(XMLStreamReader r){
			
		}
		
		static ArrayList<> read_decoupe(XMLStreamReader r){
			
		}
			
		//Gestion des exceptions...
		try {
			FileInputStream f = new FileInputStream(name);
			XMLStreamReader r = XMLInputFactory.newInstance().createXMLStreamReader(f);
			while(r.hasNext() == true) {
				if(r.next() == XMLStreamConstants.START_ELEMENT) {
					if(r.getName().toString() == "client") {
						
					}
					if(r.getName().toString() == "fournisseur") {
						
					}
					if(r.getName().toString() == "decoupe") {
						
					}
				}
			}
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(XMLStreamException xmlexception) {
			xmlexception.printStackTrace();
		}	
	}
}
