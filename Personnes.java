package logique


class Personnes implements Validable{
	int id;
	Price price;
	Date date;
	
	Customer(int id, Price price, Date date){
		this.id = id;
		this.price = price;
		this.date = date;
	}
	
	public boolean Valide() {
		if (id < 0) {
			return(false);
		}
		else {
			return(true);
		}
	}
}
