package domaci;

import java.util.Scanner;

public class Osoba {
	private String ime;
	private double visina;
	private double tezina;
	

	public Osoba(String ime, String prezime, double visina, double tezina) {
		this.ime = ime + " " + prezime;
		this.visina = visina;
		this.tezina = tezina;
	}
	
	public BMI bmi() {
		return new BMI(visina,tezina);
	}
	
	public String toString() {
		return String.format("%s (%.2f, %.2f): %.2f => %s", ime, visina, tezina, bmi().vrednost, bmi().kategorija);
	}
	
	private static int max(int[] niz) {
		int max = -1;
		for(int i=0;i<niz.length;i++) {
			if(max < niz[i])
				max = niz[i];
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodošli na sistematski pregled!");
		System.out.println("----------------------------------");
		System.out.println("Unesite osobe: ");
		
		Osoba[] niz = new Osoba[100];
		int duzina = 0;
		
		for(String unos=sc.next(); !unos.equals("kraj"); unos=sc.next()) {
			niz[duzina++] = new Osoba(unos, sc.next(), sc.nextDouble(), sc.nextDouble());
		}
		
		System.out.println("Osobe uspešno učitane!");
		System.out.println("-------------------------------------");
		
		int[] bmi_brojaci = new int[BMI.kategorije.length];
		for(int i=0; i<duzina;i++) {
			bmi_brojaci[niz[i].bmi().id]++;
		}
		
		System.out.println("Statistika: ");
		
		for(int i=max(bmi_brojaci);i>0;i--) {
			System.out.print(i+"\t");
			for(int j=0; j<bmi_brojaci.length; j++) {
				if(bmi_brojaci[j]>=i)
					System.out.print("*");
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.print("\t");
		for(int i=0;i<BMI.kategorije.length;i++) {
			System.out.print(BMI.skrati(i)+"\t");
		}
		System.out.println("\n-------------------------------------");
		for(int i=0;i<duzina;i++)
			System.out.println(niz[i]);
	}

}
