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
		
		static ArrayList<Create> read_client(XMLStreamReader r){
			ArrayList<Create> liste = new ArrayList<Create>();
			int Longueur;
			int largeur;
			int jour;
			int mois;
			int annee;
			int id_planche;
			int nombre;
			int nombre_client;
			int id_client = Integer.parseInt(r.getAttributeValue(0));
			while(r.hasNext()) {
				if(r.next() == XMLStreamConstants.START_ELEMENT) {
					if(r.getName().toString() == "client") {
						list.add(f.initializeClient(id_client, list.get(1), list.get(5), list.get(2), list.get(0)));
						//id_client = Integer.parseInt(r.getAttributeValue(0));
					}
					if (r.getName().toString() == "planche") {
						
					}
				}
			}
			
		}
		
		static ArrayList<Create> read_fournisseur(XMLStreamReader r){
			
		}
		
		static ArrayList<Create> read_decoupe(XMLStreamReader r){
			
		}
			
		//Gestion des exceptions...
		try {
			FileInputStream f = new FileInputStream(name);
			XMLStreamReader r = XMLInputFactory.newInstance().createXMLStreamReader(f);
			while(r.hasNext() == true) {
				if(r.next() == XMLStreamConstants.START_ELEMENT) {
					if(r.getName().toString() == "client") {
						read_client(r);
						return;
					}
					if(r.getName().toString() == "fournisseur") {
						read_fournisseur(r);
						return;
					}
					if(r.getName().toString() == "decoupe") {
						read_decoupe(r);
						return;
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
