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
			ArrayList<Create> liste = new ArrayList<>();
			int Longueur;
			int largeur;
			int jour;
			int mois;
			int annee;
			int id_planche;
			int nombre;
			int nombre_client;
			int id_client = Integer.parseInt(r.getAttributeValue(0));
			int a;
			int b;
			
			while(r.hasNext()) {
				if(r.next() == XMLStreamConstants.START_ELEMENT) {
					if(r.getName().toString() == "client") {
						liste.add(f.initializeClient(id_client, liste.get(1), liste.get(5), liste.get(2), liste.get(0)));;
						//id_client = Integer.parseInt(r.getAttributeValue(0));
					}
					if (r.getName().toString() == "planche") {
						try {
							nombre++;
							id_planche = Integer.parseInt(r.getAttributeValue(0));
	                        nombre = Integer.parseInt(r.getAttributeValue(1));
	                        String dates = (r.getAttributeValue(2));
	                        String[] allDates = dates.split("\\.");
	                        jour = Integer.parseInt(allDates[0]);
	                        mois = Integer.parseInt(allDates[1]);
	                        annee = Integer.parseInt(allDates[2]);
	                        String prix = (r.getAttributeValue(3));
	                        String[] allprice = prix.split("\\.");
	                        a = Integer.parseInt(allprice[0]);
	                        b = Integer.parseInt(allprice[1]);
	                        
	                        //list.add(f.initializeDate(jour, mois, annee));
	                        //list.add(f.initializePrix(prix));
	                        //list.add(f.initializeNbBois(nombre));
						}
						catch(NumberFormatException e) {
							System.out.println("Bad arguments type!");
						}
					}
					if(r.getName().toString() == "dim") {
						try {
							String LString = (r.getAttributeValue(0));
	                        String lString = (r.getAttributeValue(1));
	                        String[] LDim = LString.split("\\.");
	                        String[] lDim = lString.split("\\.");
	                        Longueur = Integer.parseInt(LDim[0]);
	                        largeur = Integer.parseInt(lDim[0]);
	                        
	                        //list.add(f.initializeDimensions(L,l));
	                        //list.add(f.initializePlanche(list.get(3),idPlanche));
	                        //list.add(f.initializeBois(list.get(3),idPlanche));
						}
						catch(NumberFormatException e) {
							System.out.println("Bad arguments type!");
						}
					}
				}
			}
			return liste;
		}
		
		static ArrayList<Create> read_fournisseur(XMLStreamReader r){
			ArrayList<Create> liste = new ArrayList<>();
	        int id_fournisseur = Integer.parseInt(r.getAttributeValue(0));
	        int Longueur;
	        int largeur;
	        int id_panneau;
	        int nombre;
	        int jour;
	        int mois;
	        int annee;
	        int a;
	        int b;
	        int nombre_fournisseur;
	        while(r.hasNext()) {
	        	if(r.next() == XMLStreamConstants.START_ELEMENT) {
	        		if(r.getName().toString() == "fournisseur") {
	        			liste.add(f.initializeClient(id_fournisseur, liste.get(1), liste.get(5), liste.get(2), liste.get(0)));;
	        			//id_fournisseur = Integer.parseInt(r.getAttributeValue(0));
	        		}
	        		if(r.getName().toString() == "panneau") {
	        			try {
	        				nombre++;
	        				id_panneau = Integer.parseInt(r.getAttributeValue(0));
	                        nombre = Integer.parseInt(r.getAttributeValue(1));
	                        String dates = (reader.getAttributeValue(2));
	                        String[] allDates = dates.split("\\.");
	                        jour = Integer.parseInt(allDates[0]);
	                        mois = Integer.parseInt(allDates[1]);
	                        annee = Integer.parseInt(allDates[2]);
	                        String prix = (r.getAttributeValue(3));
	                        String[] allprice = prix.split("\\.");
	                        a = Integer.parseInt(allprice[0]);
	                        b = Integer.parseInt(allprice[1]);
	                        
	                        //list.add(f.initializeDate(jour, mois, annee));
	                        //list.add(f.initializePrix(prix));
	                        //list.add(f.initializeNbBois(nombre));
	        			}
	        			catch(NumberFormatException e) {
	        				System.out.println("Bad Arguments!");
	        			}
	        			if(r.getName().toString() == "dim") {
	        				try {
	        					String LString = (r.getAttributeValue(0));
	                            String lString = (r.getAttributeValue(1));
	                            String[] LDim = LString.split("\\.");
	                            String[] lDim = lString.split("\\.");
	                            Longueur = Integer.parseInt(LDim[0]);
	                            largeur = Integer.parseInt(lDim[0]);
	                            
	                            //list.add(f.initializeDimensions(L,l));
	                            //list.add(f.initializePlanche(list.get(3),idPanneau));
	                            //list.add(f.initializeBois(list.get(3),idPanneau));
	        				}
	        				catch(NumberFormatException e) {
	        					System.out.println("Bad Arguments!");
	        				}
	        			}
	        		}
	        	}
	        }
	        return liste;
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
