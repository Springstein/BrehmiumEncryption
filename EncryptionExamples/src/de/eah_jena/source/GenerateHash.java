package de.eah_jena.source;
import java.io.*;

public class GenerateHash {

public static void main(String args[]){
	
	System.out.println("Bitte Text angeben, von dem Hashwert erzeugt werden soll:");
//	Konsolenobjekt f�r Eingabe initialisieren
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    String Str = null;
//  Ausgangstext einlesen  
	try {
		Str = new String(console.readLine());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//  erzeugten Haswert ausgeben
    System.out.println("Hashwert f�r eingegebenen String:" + Str.hashCode() );
 }

public void generateHash() {
	
	System.out.println("Bitte Text angeben, von dem Hashwert erzeugt werden soll:");
//	Konsolenobjekt f�r Eingabe initialisieren
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    String Str = null;
//  Ausgangstext einlesen  
	try {
		Str = new String(console.readLine());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//  erzeugten Haswert ausgeben
    System.out.println("\nHashwert f�r eingegebenen Text: " + Str.hashCode() );
}

}