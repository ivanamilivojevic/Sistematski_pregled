package domaci;

public class BMI {
	final public int id;
	final public String kategorija;
	final public String skracenica;
	final double vrednost;
	
	public static final String[] kategorije = {"Neuhranjenost", "Idealna Masa", "Prekomerna masa", "Gojaznost"};
	public static String skrati(int id) {
		String skracenica = "";
		String[] reci = kategorije[id].split(" ");
		for(int i=0;i<reci.length;i++)
			skracenica += reci[i].toUpperCase().charAt(0);
		return skracenica;
	}
	
	
	public BMI(double visina, double tezina) {
		vrednost = tezina / Math.pow(visina, 2);
		if(vrednost < 18.5) {
			id = 0;
		}else if(vrednost < 25) {
			id = 1;
		}else if(vrednost < 30) {
			id = 2;
		}else {
			id = 3;
		}
		kategorija = kategorije[id];
		skracenica = skrati(id);
	}
}
