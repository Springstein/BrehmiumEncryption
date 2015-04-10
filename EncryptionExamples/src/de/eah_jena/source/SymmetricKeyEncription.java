package de.eah_jena.source;

import javax.crypto.*;
//zur Schl�sselgenerierung 
import javax.crypto.spec.SecretKeySpec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;


public class SymmetricKeyEncription {
	
private Cipher AesCipher;
private byte[] key;
private String keyStr;
private byte[] encryptText;
private SecretKeySpec secretKeySpec;
private BufferedReader console;
private String textStr;
private byte[] byteText;
private MessageDigest sha;

	public SymmetricKeyEncription() throws Exception{
		// TODO Auto-generated constructor stub
		System.out.println("Bitte Schl�ssel/Passwort angeben:");
//    	Konsolenobjekt f�r Eingabe initialisieren
    	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//        String keyStr = null;
    //  Ausgangstext einlesen  
    	try {
    		keyStr = new String(console.readLine());
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	System.out.println("\nBitte zu verschl�sselnden Text eingeben: ");
     	try {
    		textStr = new String(console.readLine());
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
		key = (keyStr).getBytes("UTF-8");
		byteText = textStr.getBytes();
		AesCipher = Cipher.getInstance("AES");
//		aus dem  Array einen Hash-Wert mit MD5 oder SHA erzeugen
		sha = MessageDigest.getInstance("MD5");
		key = sha.digest(key);
		// nur die ersten 128 bit nutzen; da AES auf eine feste Gr��e beschr�nkt ist
		key = Arrays.copyOf(key, 16); 
		secretKeySpec = new SecretKeySpec(key, "AES");
	}

//    public static void main(String[] args) throws Exception {
//        
//        // Das Passwort 
//        String keyStr = "geheim";
//        // byte-Array erzeugen
//        byte[] key = (keyStr).getBytes("UTF-8");
//        // aus dem Array einen Hash-Wert erzeugen mit MD5 oder SHA
//        MessageDigest sha = MessageDigest.getInstance("MD5");
//        key = sha.digest(key);
//        // nur die ersten 128 bit nutzen; da AES auf eine feste Gr��e beschr�nkt ist
//        key = Arrays.copyOf(key, 16); 
//        // der fertige Schluessel
//        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
// 
//        
//
//        //zu verschl�sselnder Text
//        byte[] byteText = "quelle: http://stackoverflow.com/questions/20796042/aes-encryption-and-decryption-with-java".getBytes();
//
//        AesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//        
//        //Verschl�sseln und Ausgabe in Console
//        byte[] encryptText = AesCipher.doFinal(byteText);
//        System.out.println("Verschl�sselter Text:");
//        System.out.write(encryptText);
//
////      Milestone
//        //hier liest er den verschl�sselten Text aus, den er entschl�sselt
//        byte[] cipherText = encryptText;
//
//        //Entschl�sseln
//        AesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//        byte[] bytePlainText = AesCipher.doFinal(cipherText);
//        
//        //Ausgabe in Console
//        System.out.println("\n \n Entschl�sselter Text:");
//        System.out.write(bytePlainText);
//    }

    
    public void encrypt() throws Exception {
    	
    	// byte-Array erzeugen
        // aus dem Array einen Hash-Wert erzeugen mit MD5 oder SHA
//        MessageDigest sha = MessageDigest.getInstance("MD5");
        // der fertige Schluessel
        //  Ausgangstext einlesen  
            //zu verschl�sselnder Text
//            byte[] byteText = textStr.getBytes();
//          Verschl�sselungsmodus der Cipher-Klasse initialisieren
            AesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);	
            
            //Verschl�sseln und Ausgabe in Console
            encryptText = AesCipher.doFinal(byteText);
            System.out.println("\nVerschl�sselter Text:");
            System.out.write(encryptText);
    }
    
    public void decrypt() throws Exception {
    	
    	 //hier liest er den verschl�sselten Text aus, den er entschl�sselt
        byte[] cipherText = encryptText;

        //Entschl�sseln
        AesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] bytePlainText = AesCipher.doFinal(cipherText);
        
        //Ausgabe in Console
        System.out.println("\n \nEntschl�sselter Text:");
        System.out.write(bytePlainText);
    }
    
    public void decryptCustomEncryptedText() throws Exception {
    	
       System.out.println("\n \nVerschl�sselter Text:");
    	
       String inputText =  new String(console.readLine());
       
       System.out.println("Bitte Schl�ssel/Passwort angeben:");
       
       String inputKey =  new String(console.readLine());
       
    
   	 //hier liest er den verschl�sselten Text aus, den er entschl�sselt
       byte[] byteInput = (inputText).getBytes("UTF-8");
       encryptText = byteInput;	
       byte[] cipherText = encryptText;

      
       AesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
       byte[] bytePlainText = AesCipher.doFinal(cipherText);
       
       //Ausgabe in Console
       System.out.println("\n \nEntschl�sselter Text:");
       System.out.write(bytePlainText);
   }
}
