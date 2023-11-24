//Solved By P.S.Bhoite

/*Firstly the problem is rounding arround the group of similar length elements and its length so the first thought i get in my mind is about HashMap due to its fast execution so i break the problem into two parts length of that similar element group as key and group itself as value so that i can easily check the existence of key and that get that group rapidly*/

import java.util.*;
public class checkStringInList {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        Collections.addAll(data, new ArrayList<>(Arrays.asList("cat", "dog", "abc")),
                new ArrayList<>(Arrays.asList("tram", "help", "boat")),
                new ArrayList<>(Arrays.asList("world", "range", "grail")));
          // String Group is Converted into Hashmap as insertion length of that subgroup
        // is key and group is value
        /*
         * strGrp                              Hashmap
         * { {
         *     {"cat", "dog", "abc"},          3 = {"cat", "dog", "abc"},
         *     {"tram", "help", "boat"},       4 = {"tram", "help", "boat"},
         *     {"world", "range", "grail"},    5 = {"world", "range", "grail"},
         * } }                                                                            
         *
         */
        System.out.println("Enter element to check -");
        String check = sc.nextLine();
        isExist(convertion(data), check);
    }

    public static HashMap<Integer, ArrayList<String>> convertion(ArrayList<ArrayList<String>> temp) 
    {
        HashMap<Integer, ArrayList<String>> storage = new HashMap<>();
        for (ArrayList<String> arr : temp) 
        {
            storage.put(arr.get(0).length(), arr);
        }
        return storage;
    }

    public static void isExist(HashMap<Integer, ArrayList<String>> temp, String check) 
    {
        try {
            // Step 1 - Firstly we check input string is valid or not and if contains space then ->trim
            if (!check.contains(",")) {
                check = check.trim();
                check = check.replace(" ", "");
            }
            // Step 2 - Secondly we check the string length group is exist or not
            if (temp.containsKey(check.length())) 
            {
                // Step 3 - If the entered string exist in our data group then return string is already
                // exists and print the group of that specific string...
                if (temp.get(check.length()).contains(check)) 
                {
                    System.out.println("Given string is already exists....");
                    System.out.println("It Belongs To Group : "+ temp.get(check.length()));
                }
                // Step 4 - If the entered element not exists in out dataGroup then print string not exist
                // and add to its relevant group
                else 
                {
                    System.out.println("The entered element is not in Our Data Storage so we are adding it to its group");
                    temp.get(check.length()).add(check);
                    System.out.println(temp.get(check.length()));
                }
                return;
            } 
            else 
            {
                // Step 5 - If the entered string is not matching with any group of dataGroup
                // then we simply make a group of that element seperately and add it to the
                // data
                ArrayList<String> sizei = new ArrayList<>();
                sizei.add(check);
                 System.out
                            .println("The entered string group is not in Our Data Storage so we are adding it to our data\n");
                temp.put(check.length(), sizei);
            }
            System.out.println(temp);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

// Time complexity : O(N)
// Space complexity : O(N)


//Unit Test:  


/*Unit Test Case 1 : if string is exist in our data Groups

Enter element to check -
abc
Given string is already exists....
It Belongs To Group : [cat, dog, abc]
*/



/*Unit Test Case 2 :if string is not exist in our data Groups

Enter element to check -
www
The entered element is not in Our Data Storage so we are adding it to its group
[cat, dog, abc, www]
prasad@bhoite ~/D/JAVA_PRASAD>*/



/*Unit Test Case 3 : if string data list is not exist our data then we will create list

Enter element to check -
prasad
The entered string group is not in Our Data Storage so we are adding it to our data

{3=[cat, dog, abc], 4=[tram, help, boat], 5=[world, range, grail], 6=[prasad]}
*/



/*Unit Test Case 4: If input string is not continous then trim the spaces and searching. 

Enter element to check -
abc cdf fgd 
The entered string group is not in Our Data Storage so we are adding it to our data
{3=[cat, dog, abc], 4=[tram, help, boat], 5=[world, range, grail], 9=[abccdffgd]}
*/
