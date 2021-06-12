
package com.omidghor.doggenetics;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author omidghor
 */
public class DogGenetics {
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
//        boolean repeatValue = false;

        Random randomNum = new Random();

        /*
        Generates a non-repeating set of random integers in the range of 1-25.  The first random integer
        is set, then all remaining generated integers are first checked against all previously generated
        integers for a repeated value. If a value is repeated a new integer is generated and check. Integers
        are saved as string to re-use existing array to return list of breeds.
        */
        for (int i = 0; i < breeds.length; i++) {
            if (i == 0) {
                breeds[i] = Integer.toString(randomNum.nextInt(5) + 1);
            } else {
                boolean repeatValue = false;
                do {
                   // boolean repeatValue = false;
                    breeds[i] = Integer.toString(randomNum.nextInt(5) + 1);
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
                
            }
        }
        
        return breeds;
    }

}

