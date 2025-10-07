package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RLE {

    public static void main(String[] args) throws FileNotFoundException {
        String decompressedString = textToString("src/main/resources/COVID-19");
        String compressedString = compress(decompressedString);
        System.out.println(compressedString);
    }

    /** This method converts the information stored in a text file into a String. */
    public static String textToString(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String subSeq = sc.next();
            for (int i = 0; i < subSeq.length(); i++) {
                sb.append(subSeq.charAt(i));
            }
        }
        return sb.toString();
    }

    /** TODO 1: Given a String (a genome sequence of COVID-19) implement the RLE algorithm that will use RLE to compress a String. Returns the compressed String. */
    public static String compress(String uncompressed) {
        int numberOfOccurrences = 0;
        String givenLetter = "";
        String toReturn = "";
        for(int i = 0; i < uncompressed.length()-1; i++) {
            givenLetter = String.valueOf(uncompressed.charAt(i));
            if(String.valueOf(uncompressed.charAt(i)) == " ") {

            }
            if (uncompressed.charAt(i) == uncompressed.charAt(i+1)){
                numberOfOccurrences++;
            }
            else{
                toReturn += (numberOfOccurrences+1) + givenLetter;
                numberOfOccurrences = 0;
                givenLetter = "";
            }
        }
        toReturn += (numberOfOccurrences+1) + givenLetter;
        return toReturn;
    }

    /** TODO 2: Given a String (a genome sequence of COVID-19) implement the RLE algorithm that will use RLE to decompress a String. Returns the uncompressed String. */
    public static String decompress(String compressed) {
        String toReturn = "";

        int n = 0;
        int index = 0;

        while(compressed.length() > index) {
            if(Character.isDigit(compressed.charAt(index))) {
                n = Integer.parseInt(n+String.valueOf(compressed.charAt(index)));
            }
            else{
                char letter = compressed.charAt(index);
                while(n > 0){
                    toReturn += letter;
                    n--;
                }
            }
            index++;
        }

        return toReturn;
    }


}
