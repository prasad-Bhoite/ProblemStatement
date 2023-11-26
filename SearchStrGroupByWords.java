import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SearchStrGroupByWords{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        String check = "";
        boolean flag = false;

        do {
            System.out.println("Enter data to Add in Storage -(Press Enter For stoping)");
            check = scanner.nextLine();
            
            ArrayList<String> inputList = new ArrayList<>(Arrays.asList(check.split(", ")));

            flag = false;
            for (ArrayList<String> temp : data) {
                if (temp.get(0).length() == check.length()) {
                    temp.addAll(inputList);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                data = groupByWords(data, inputList);
            }
        } while (!check.isBlank());

        data.remove(data.size() - 1);

        System.out.println("Storage Data - " + data);
        System.out.println("Enter element to check -(press enter for exit)");
        check = scanner.nextLine();
        isExist(convertion(data), check);
        scanner.close();
    }

    public static ArrayList<ArrayList<String>> groupByWords(ArrayList<ArrayList<String>> storage, ArrayList<String> inputstr) {
        ArrayList<String> temp = new ArrayList<>(inputstr);
        storage.add(temp);
        return storage;
    }

    public static HashMap<Integer, ArrayList<String>> convertion(ArrayList<ArrayList<String>> temp) {
        HashMap<Integer, ArrayList<String>> storage = new HashMap<>();
        for (ArrayList<String> arr : temp) {
            storage.put(arr.get(0).length(), arr);
        }
        return storage;
    }

    public static void isExist(HashMap<Integer, ArrayList<String>> temp, String check) {
        try {
            // Step 1 - Firstly, we check if the element is a single element or not
            if (!check.contains(",")) {
                check = check.trim();
                check = check.replace(" ", "");
            }
            // Step 2 - Secondly, we check if the element's length group exists or not
            if (temp.containsKey(check.length())) {
                // Step 3 - If the entered element exists in our data, print "Already Exists"
                if (temp.get(check.length()).contains(check)) {
                    System.out.println("Already Exists....");
                    System.out.println(temp.get(check.length()));
                }
                // Step 4 - If the entered element does not exist in our data, print "Not Exist"
                // and add it to its relevant group
                else {
                    System.out.println("The entered element is not in Our Data Storage so we are adding it to its group");
                    temp.get(check.length()).add(check);
                    System.out.println(temp.get(check.length()));
                }
                return;
            } else {
                // Step 5 - If the entered element is not matching with any group in data,
                // create a group of that element separately and add it to the data
                ArrayList<String> sizei = new ArrayList<>();
                sizei.add(check);
                temp.put(check.length(), sizei);
            }
            System.out.println(temp);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
/*

Enter data to Add in Storage -(Press Enter For stoping)
cat
Enter data to Add in Storage -(Press Enter For stoping)
dog
Enter data to Add in Storage -(Press Enter For stoping)
abc
Enter data to Add in Storage -(Press Enter For stoping)
tram
Enter data to Add in Storage -(Press Enter For stoping)
help
Enter data to Add in Storage -(Press Enter For stoping)
boat
Enter data to Add in Storage -(Press Enter For stoping)
world
Enter data to Add in Storage -(Press Enter For stoping)
range
Enter data to Add in Storage -(Press Enter For stoping)
grail

Storage Data - [[cat, dog, abc], [tram, help, boat], [world, range, grail]]
Enter element to check -(press enter for exit)
NIUM
The entered element is not in Our Data Storage so we are adding it to its group
[tram, help, boat, NIUM]

prasad@prasad:~/Desktop/JAVA$ 


Enter data to Add in Storage -(Press Enter For stoping)
a
Enter data to Add in Storage -(Press Enter For stoping)
b
Enter data to Add in Storage -(Press Enter For stoping)
aa
Enter data to Add in Storage -(Press Enter For stoping)
bb
Enter data to Add in Storage -(Press Enter For stoping)
abc
Enter data to Add in Storage -(Press Enter For stoping)
cdf
Enter data to Add in Storage -(Press Enter For stoping)
dfg
Enter data to Add in Storage -(Press Enter For stoping)
trail


Storage Data - [[a, b], [aa, bb], [abc, cdf, dfg], [trail]]
Enter element to check -(press enter for exit)
india
The entered element is not in Our Data Storage so we are adding it to its group
[trail, india]
 */