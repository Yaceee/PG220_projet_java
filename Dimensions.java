package logique;

class Dimension implements Validable {
	float Longueur;
	float largeur;
	//Gestion des exceptions:
	Dimensions(float Longueur, float largeur){
		try {
			if (l > 0 && L > l) {
				this.Longueur = Longueur;
				this.largeur = largeur;
			}
			else {
				throw new IllegalArgumentException("Length must be greater than width and the two must be positif");
			}
		}
		catch(IllegalArgumentException exception) {
			System.out.println("Length must be greater than width and the two must be positif").
		}
	}
	
	public boolean Valide() {
		if (this.Longueur < this.largeur || this.largeur < 0 || this.Longueur < 0) {
			return(false);
		}
		else {
			return(true);
		}
	}
}
