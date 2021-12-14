package logique

class Personnes implements Validable{
	int id;
	Prix prix;
	validDate date;
	
	Personne(int id, Prix prix, validDate date){
		this.id = id;
		this.prix = prix;
		this.date = date;
	}
	
	public boolean isValide() {
		if (id >= 0) {
			if(date.isValid()) {
				if(prix.isValid()) {
					return true;
				}
			}
		}
		else {
			return false;
		}
	}
}
