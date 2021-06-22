
package com.omidghor.doggenetics;

/**
 *
 * @author omidghor
 */

   

import java.util.Random;
import java.util.Scanner;


public class dogGenetics2 {

    /*
    public static void main(String[] args)
    Entry point for the program; execution begins here.
     */
    public static void main(String[] args) {
        //How many random numbers/percentages.
        int numBreeds = 5;
        //Value randomly generated numbers must sum to.
        int rangeSum = 100;
        String dogName;
        int percentages[] = new int[numBreeds];
        String breeds[] = new String[numBreeds];

        Scanner sc = new Scanner(System.in);

        System.out.println("\n*****     GET YOUR DOG'S DNA BACKGROUND     *****");
        System.out.println("\nWhat is your dog's name?   ");
        dogName = sc.nextLine();

        System.out.print("\nWell then, I have this highly reliable rpeort on " + dogName + "'s ");
        System.out.println("prestigious background right here!");

        System.out.println("\n" + dogName + " is:\n");
        //Get random list of numBreeds values which sum to rangeSum.
        System.arraycopy(getSummableRange(numBreeds, rangeSum), 0, percentages, 0, numBreeds);
        //Get random list of numBreeds dog breeds.
        System.arraycopy(getBreeds(numBreeds), 0, breeds, 0, numBreeds);

        //Print percentages and breeds to console.
        for (int i = 0; i < numBreeds; i++) {
            System.out.println(percentages[i] + "% " + breeds[i]);
        }

        System.out.println("\nWow, that's QUITE the dog!\n");
    }

    /*
    public static int[] getSummableRange(int numValues, int sum) generates a specified 
    number of random integers which sum to a specified value. Returns integers as an array.
     */
    public static int[] getSummableRange(int numValues, int sum) {
        int rangeValues[] = new int[numValues];
        Random randomNum = new Random();
        int maxValue;

        /*Each random integer generated is restricted to a maximum equalling the final sum
          minus how many integers remain to be generated and each previously generated integer, i.e.,
          for 5 numbers summing to 100:
            the first maximum is (100 - 4)
            the second maximum is (100 - first number - 3)
         */
        for (int i = numValues - 1; i >= 0; i--) {
            if (i > 0) {
                maxValue = sum - i;
                rangeValues[i] = randomNum.nextInt(maxValue) + 1;
                sum -= rangeValues[i];
            } else {
                //Final value is simply the remaining difference.
                rangeValues[0] = sum;
            }

        }
        
        return rangeValues;
    }

    /*
    public static String[] getBreeds(int numBreeds) randomly generates a specified number of
    dog breeds from a list of 25 breeds.  Returns breeds as an array.
     */
    public static String[] getBreeds(int numBreeds) {
        String breeds[] = new String[numBreeds];
        boolean repeatValue = false;

        Random randomNum = new Random();

        /*
        Generates a non-repeating set of random integers in the range of 1-25.  The first random integer
        is set, then all remaining generated integers are first checked against all previously generated
        integers for a repeated value. If a value is repeated a new integer is generated and check. Integers
        are saved as string to re-use existing array to return list of breeds.
        */
        for (int i = 0; i < breeds.length; i++) {
            if (i == 0) {
                breeds[i] = Integer.toString(randomNum.nextInt(25) + 1);
            } else {
                do {
                    repeatValue = false;
                    breeds[i] = Integer.toString(randomNum.nextInt(25) + 1);
                    for (int j = 0; j <= i - 1; j++) {
                        if (breeds[i].equals(breeds[j])) {
                            repeatValue = true;
                            System.out.println("repeat");
                            break;
                        }
                    }
                } while (repeatValue);
            }
        }

        //Set breeds using non-repeating list of integer values as strings.
        for (int i = 0; i < breeds.length; i++) {
            switch (breeds[i]) {
                case "1":
                    breeds[i] = "Cardigan Welsh Corgi";
                    break;
                case "2":
                    breeds[i] = "Boston Terrier";
                    break;
                case "3":
                    breeds[i] = "Basset Hound";
                    break;
                case "4":
                    breeds[i] = "Golden Retriever";
                    break;
                case "5":
                    breeds[i] = "Australian Cattle Dog";
                    break;
                case "6":
                    breeds[i] = "Pembroke Welsh Corgi";
                    break;
                case "7":
                    breeds[i] = "Chihuahua";
                    break;
                case "8":
                    breeds[i] = "Vizsla";
                    break;
                case "9":
                    breeds[i] = "Tibetan Mastiff";
                    break;
                case "10":
                    breeds[i] = "Cairn Terrier";
                    break;
                case "11":
                    breeds[i] = "Miniature Wire Haired Dachshund";
                    break;
                case "12":
                    breeds[i] = "Toy Fox Terrier";
                    break;
                case "13":
                    breeds[i] = "Japanese Chin";
                    break;
                case "14":
                    breeds[i] = "Miniature Bull Terrier";
                    break;
                case "15":
                    breeds[i] = "French Bulldog";
                    break;
                case "16":
                    breeds[i] = "Great Dane";
                    break;
                case "17":
                    breeds[i] = "Borzoi";
                    break;
                case "18":
                    breeds[i] = "Weimaraner";
                    break;
                case "19":
                    breeds[i] = "Jack Russell Terrier";
                    break;
                case "20":
                    breeds[i] = "Rhodesian Ridgeback";
                    break;
                case "21":
                    breeds[i] = "Havanese";
                    break;
                case "22":
                    breeds[i] = "Neapolitan Mastiff";
                    break;
                case "23":
                    breeds[i] = "Komondor";
                    break;
                case "24":
                    breeds[i] = "English Bulldog";
                    break;
                case "25":
                    breeds[i] = "Saint Bernard";
                    break;
            }
        }
        
        return breeds;
    }

}

