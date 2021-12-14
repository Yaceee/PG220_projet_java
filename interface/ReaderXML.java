package interface;

import java.io.*;
import java.util.*;
import javax.xml.stream.*;
import logique.Create;

private class ReaderXML implements Reader{
	public static void xml_reader(String name, Factory fact) {
		
		static ArrayList<Create> read_client(XMLStreamReader r, Factory fact){
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
						liste.add(fact.initializeClient(id_client, liste.get(1), liste.get(5), liste.get(2), liste.get(0)));;
						id_client = Integer.parseInt(r.getAttributeValue(0));
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
	                        liste.add(fact.initDate(jour, mois, annee));
	                        liste.add(fact.initPrix(a,b));
						}
						catch(NumberFormatException e) {
							System.out.println("Bad arguments: Planche!");
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
						}
						catch(NumberFormatException e) {
							System.out.println("Bad arguments: Dimensions!");
						}
					}
				}
			}
			return liste;
		}
		
		static ArrayList<Create> read_fournisseur(XMLStreamReader r, Factory fact){
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
	        			liste.add(fact.initializeClient(id_fournisseur, liste.get(1), liste.get(5), liste.get(2), liste.get(0)));;
	        			id_fournisseur = Integer.parseInt(r.getAttributeValue(0));
	        		}
	        		if(r.getName().toString() == "panneau") {
	        			try {
	        				nombre++;
	        				id_panneau = Integer.parseInt(r.getAttributeValue(0));
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
	                        liste.add(fact.initDate(jour, mois, annee));
	                        liste.add(fact.initPrix(a,b));
	        			}
	        			catch(NumberFormatException e) {
	        				System.out.println("Bad Arguments: Panneau!");
	        			}
	        			if(r.getName().toString() == "dim") {
	        				try {
	        					String LString = (r.getAttributeValue(0));
	                            String lString = (r.getAttributeValue(1));
	                            String[] LDim = LString.split("\\.");
	                            String[] lDim = lString.split("\\.");
	                            Longueur = Integer.parseInt(LDim[0]);
	                            largeur = Integer.parseInt(lDim[0]);
	        				}
	        				catch(NumberFormatException e) {
	        					System.out.println("Bad Arguments: dimensions!");
	        				}
	        			}
	        		}
	        	}
	        }
	        return liste;
		}
		
		static ArrayList<Create> read_decoupe(XMLStreamReader r) {
			ArrayList<Create> liste = new ArrayList<>();
			int id_fournisseur;
	        int id_client;
	        int id_planche;
	        int id_panneau;
	        int x;
	        int y;
	        while(r.hasNext()) {
	        	if (r.next() == XMLStreamConstants.START_ELEMENT) {
	        		if(r.getName().toString() == "fournisseur") {
	        			try {
	        				id_fournisseur = Integer.parseInt(r.getAttributeValue(0));
	        				id_panneau = Integer.parseInt(r.getAttributeValue(1));
	        			}
	        			catch(NumberFormatException e) {
	        				System.out.println("Bad Arguments: Fournisseur!");
	        			}
	        		}
	        		if(r.getName().toString() == "client") {
	        			try {
	        				id_client = Integer.parseInt(r.getAttributeValue(0));
	        				id_planche = Integer.parseInt(r.getAttributeValue(1));
	        			}
	        			catch(NumberFormatException e) {
	        				System.out.println("Bad Arguments: Client!");
	        			}
	        		}
	        		if(r.getName().toString() == "position") {
	        			try {
	        				x = Math.round(Float.parseFloat(r.getAttributeValue(0)));
	        				y = Math.round(Float.parseFloat(r.getAttributeValue(1)));
	        			}
	        			catch(NumberFormatException e) {
	        				System.out.println("Bad Arguments: Position!");
	        			}
	        		}
	        	}
	        }
	        return liste;
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
