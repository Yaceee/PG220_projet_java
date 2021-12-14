package logique;

import java.util.*;
import ui.XmlRead.readXml;

class Decoupe{
	public static void main(String[] args) {
		ArrayList<Create> liste_client = new ArrayList<>();
		ArrayList<Create> liste_fournisseur = new ArrayList<>();
		ArrayList<Create> liste_decoupe = new ArrayList<>();
		Factory fact = new Factory();
		liste_client = xml_reader(args[0], fact);
		liste_fournisseur = xml_reader(args[1], fact);
		liste_decoupe = xml_reader(args[2], fact);
	}
}
