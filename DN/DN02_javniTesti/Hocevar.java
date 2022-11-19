	import java.util.*;

	public class Hocevar { 
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int b = sc.nextInt(); //vrstaTipkovnice
			int d = sc.nextInt(); //širinaTipkovnice
			int n = sc.nextInt(); //dolzinaZaporedja
			int a = sc.nextInt(); //zacetnoStevilo
			
			int celotnaPot = 0;
			int prvaStevka = a;
			
			while (sc.hasNextInt()) {
					int naslednjaStevka = sc.nextInt();
					int razdalja = 0;
					if (b == 1) {
						razdalja = Line (prvaStevka, naslednjaStevka);
					} else if (b == 2) {
						razdalja = Square (prvaStevka, naslednjaStevka, d);
					} else if(b == 3) {
						razdalja = Pyramid (prvaStevka, naslednjaStevka, d);
					} else {
						razdalja = Spiral(prvaStevka, naslednjaStevka, d);
					} 
					celotnaPot += razdalja;
					prvaStevka = naslednjaStevka;
				}
				
			System.out.println(celotnaPot);
		}
		
		//metoda za absolutno vrednost:
		
		public static int Absolutna(int a) {
			int absolutna = a > 0 ? a : -a;
			
			return absolutna;
		}

		
		//METODE TIPKOVNIC:
		
		//Raznovrstnica - tipkovnica dolžine d z števkami od 0 do d - 1
		public static int Line(int a, int naslednjaStevka) {
			int razdalja = Absolutna(a - naslednjaStevka);
			return razdalja;
		}
		
		//Kvadratnica - tipkovnica v obliki kvadrata s stranico d in števkami od 0 do d * d - 1
		public static int Square(int a, int naslednjaStevka, int stranica) {
			int horizontalnaRazdalja = Absolutna(a % stranica - naslednjaStevka % stranica);//vrsticam je skupen ostanek pri deljenju z d
			int vertikalnaRazdalja = Absolutna (a / stranica - naslednjaStevka / stranica);//stolpci imajo enako vrednost pri deljenju z d
			int razdalja = horizontalnaRazdalja + vertikalnaRazdalja;
			
			return razdalja;
		}
		
		//Piramidnica - tipkovnica v obliki piramide višine d
		public static int Pyramid(int prvaStevka, int naslednjaStevka, int visina) {
			int vrsticaPrvega = 0;
			int vrsticaDrugega = 0;
			int horizontalnaRazdalja = 0;
			
			//vrstico najdemo s pomočjo popolnih kvadratov ki so na zacetku vsake vrstice
			for (int a = 0; a < visina; a++){
				if (prvaStevka >= a*a && prvaStevka < (a + 1) * (a + 1)){
					vrsticaPrvega = a;
				}
			}
			for (int a = 0; a < visina; a++){
				if (naslednjaStevka >= a*a && naslednjaStevka < (a + 1) * (a + 1)){
					vrsticaDrugega = a;
				}
			}
			
			int vertikalnaRazdalja = Absolutna(vrsticaDrugega - vrsticaPrvega);
			int sredinaPrvega = vrsticaPrvega * vrsticaPrvega + vrsticaPrvega;
			int sredinaDrugega = vrsticaDrugega * vrsticaDrugega + vrsticaDrugega;
			
			//stolpec poiscemo glede na oddaljenost od srednje vrednosti vrstice ki ima formulo a * a + a kjer je a stevilka vrstice
			if (sredinaPrvega - prvaStevka < 0 && sredinaDrugega - naslednjaStevka > 0 || sredinaPrvega - prvaStevka > 0 && sredinaDrugega - naslednjaStevka < 0) {
				horizontalnaRazdalja = Absolutna(sredinaPrvega - prvaStevka) + Absolutna(sredinaDrugega - naslednjaStevka);
			} else {
				horizontalnaRazdalja = Absolutna((sredinaPrvega - prvaStevka) - (sredinaDrugega - naslednjaStevka));
			}
			int razdalja = horizontalnaRazdalja + vertikalnaRazdalja;
			
			return razdalja;
		}
		
		// - tipkovnica v obliki kvadrata s stranico d in števkami od 0 do d * d - 1
		public static int Spiral(int prva, int druga, int d) {
			int radij1 = 0;
			int radij2 = 0;
			int M = (d - 1) / 2; //maximalen radij
			int x1 = 0;
			int y1 = 0;
			int x2 = 0;
			int y2 = 0;
			
			//najprej določimo radij obeh števkam
			for (int a = M; a > 0; a--){
				if (prva < (2 * a + 1) * (2 * a + 1)){
					radij1 = a;
				}
				if (druga < (2 * a + 1) * (2 * a + 1)){
					radij2 = a;
				}
			}
			
			if (prva == 0) {
				x1 = M + 1;
				y1 = M + 1;
			} else if (prva <= (Fixed(radij1) + 2 * radij1)){
				x1 = M - radij1 + prva - Fixed(radij1) + 1;
				y1 = (d - 1) / 2 - radij1 + 1;
			} else if (prva <= (Fixed(radij1) + 4 * radij1)){
				x1 = (d - 1) / 2 - radij1 + 1 + 2 * radij1;
				y1 = M - radij1 + prva - (Fixed(radij1) + 2 * radij1) + 1;
			} else if (prva <= (Fixed(radij1) + 6 * radij1)){
				x1 = M - radij1 + Fixed(radij1) + 6 * radij1 - prva + 1;
				y1 = (d - 1) / 2 - radij1 + 1 + 2 * radij1;
			} else {
				x1 = (d - 1) / 2 - radij1 + 1;
				y1 = (d - 1) / 2 - radij1 + 1 + 2 * radij1 -(prva - (Fixed(radij1) + 6 * radij1));
			}
			
			if (druga == 0) {
				x2 = M + 1;
				y2 = M + 1;
			} else if (druga <= (Fixed(radij2) + 2 * radij2)){
				x2 = M - radij2 + druga - Fixed(radij2) + 1;
				y2 = (d - 1) / 2 - radij2 + 1;
			} else if (druga <= (Fixed(radij2) + 4 * radij2)){
				x2 = (d - 1) / 2 - radij2 + 1 + 2 * radij2;
				y2 = M - radij2 + druga - (Fixed(radij2) + 2 * radij2) + 1;
			} else if (druga <= (Fixed(radij2) + 6 * radij2)){
				x2 = M - radij2 + Fixed(radij2) + 6 * radij2 - druga + 1;
				y2 = (d - 1) / 2 - radij2 + 1 + 2 * radij2;
			} else {
				x2 = (d - 1) / 2 - radij2 + 1;
				y2 = (d - 1) / 2 - radij2 + 1 + 2 * radij2 -(druga - (Fixed(radij2) + 6 * radij2));
			}
			
			int razdalja = Absolutna(x1 - x2) + Absolutna(y1 - y2);
			
			return razdalja;
		}
		//fiksna koordinata popolnega kvadrata lihega števila
		public static int Fixed(int radij) {
			int kordinata = (2 * radij - 1) * (2 * radij - 1);
			
			return kordinata;
		}
	}