public abstract class Bois implements Validable{
	int longueur;
	int largeur;
	Prix prix;
	validDate date;

	Bois(int longueur, int largeur, int a, int b, int jour, int mois, int annee)
	{
		this.date = new Date(jour,mois,annee);
		this.longueur = longueur;
		this.largeur = largeur;
		this.prix = new Prix(a,b);
	}

	public boolean isValid()
	{
		if((largeur <= longueur)&&(longueur > 0)&&(largeur>0))
		{
			if(date.isValid()){
				if(prix.isValid()){
					return true;
				}
			}
		}
		return false;
	}
}
