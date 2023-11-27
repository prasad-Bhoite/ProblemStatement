//problem : Take an ArrayList of String as input add to its relevant group by length.
import java.util.*;

public class WordGrouperByLength {
    public static ArrayList<ArrayList<String>> groupByWords(ArrayList<String> inputStrings) {
        // Initialize a HashMap to store words grouped by their lengths
        HashMap<Integer, ArrayList<String>> wordMap = new HashMap<>();

        // Iterate through each input string
        for (String inputString : inputStrings) {
            // Split the input string into words
            String[] words = inputString.split("\\s+");

            // Iterate through each word
            for (String word : words) {
                // Calculate the length of the word
                int wordLength = word.length();

                // Check if the length is already present in the HashMap
                if (wordMap.containsKey(wordLength)) {
                    // If present, add the word to the existing ArrayList
                    wordMap.get(wordLength).add(word);
                } else {
                    // If not present, create a new ArrayList for that length and add the word
                    ArrayList<String> wordList = new ArrayList<>();
                    wordList.add(word);
                    wordMap.put(wordLength, wordList);
                }
            }
        }

        // Convert the values of the HashMap to an ArrayList and return
        return new ArrayList<>(wordMap.values());
    }

    public static void main(String[] args) {
        // Accept input strings from the user
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputStrings = new ArrayList<>();

        System.out.println("Enter strings (type 'done' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("done")) {
                break;
            }
            inputStrings.add(input);
        }

        // Call the groupByWords function
        ArrayList<ArrayList<String>> result = groupByWords(inputStrings);

        // Print the result
        // for (ArrayList<String> group : result) {
        //     System.out.println(group);
        // }
        System.out.println("\n2D ARRAYLIST OF STRING : ");
        System.out.println(result);

        // Close the scanner
        scanner.close();
    }
}

/*
Enter strings (type 'done' to finish):
my name is prasad currently i'm learning new tech frameworks like nextJS and API-TESTING etc i love coding abc head s hjk ghjjk yyyyyyy fgggg
done

2D ARRAYLIST OF STRING : 
[[i, s], [my, is], [i'm, new, and, etc, abc, hjk], [name, tech, like, love, head], [ghjjk, fgggg], [prasad, nextJS, coding], [yyyyyyy], [learning], [currently], [frameworks], [API-TESTING]]
prasad@prasad:~/JAVAPRACTISE$ */


/*
Enter strings (type 'done' to finish):
abc tram help world dog boat cat range xyzqw prasad 
done

2D ARRAYLIST OF STRING : 
[[abc, dog, cat], [tram, help, boat], [world, range, xyzqw], [prasad]]
prasad@prasad:~/JAVAPRACTISE$ */