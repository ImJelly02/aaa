// Question 1
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        Main q1 = new Main();

        System.out.println("--- SECTION 1---");
        q1.task1();
        System.out.println("\n--- SECTION 2---");
        q1.task2();
        System.out.println("\n--- SECTION 3---");
        q1.task3();
    }

    private void task1(){
        // Create an array
        System.out.println(" Q: Variable \"arrayA\" is a string array of car brands: [\"Honda\", \"Toyota\", \"Proton\"]");
        String[] car = {"Honda", "Toyota", "Proton"};
        // Display elements in the array
        for (String carDisplay : car) {
            System.out.println(carDisplay);
        }

        System.out.println("\n Q: Add \"Nissan\" to it. Print it out.");
        // Copy array "car" and increase the length
        String[] tempArr = Arrays.copyOf(car, car.length + 1);
        // Add elements to the new array
        tempArr[car.length] = "Nissan";
        // Display elements in the array
        for (String carNew : tempArr){
            System.out.println(carNew);
        }

        System.out.println("\n Q: Add \"Mazda\" as the first element within the string array. Print it out.");
        // Copy array "tempArr", increase the length, assign the new array name as "arrayA"
        String[] arrayA = Arrays.copyOf(tempArr, tempArr.length + 1);
        // Add element 'Mazda' to the first position of the array
        arrayA[0] = "Mazda";
        System.arraycopy(tempArr, 0, arrayA, 1, tempArr.length);
        // Display elements in the array
        for (String carFinal : arrayA){
            System.out.println(carFinal);
        }

        System.out.println("\n Q: Now make a new variable \"arrayB\" which is a string array of animals.");
        // Create arrayB
        String[] arrayB = {"Cat", "Dog", "Duck", "Horse"};
        System.out.println(Arrays.toString(arrayB));
        
        System.out.println("\n Q: Combine both arrays into variable \"arrayA\".");
        // Determine length of arrayA and arrayB
        int a = arrayA.length;
        int b = arrayB.length;

        // Perform merging
        String[] newArray = new String[a + b];
        System.arraycopy(arrayA, 0, newArray, 0, a);
        System.arraycopy(arrayB, 0, newArray, a, b);
        // Display the new array
        System.out.println(Arrays.toString(newArray));
    }

    private void task2(){
        System.out.println("\n Q: Variable \"mapC\" & \"mapD\" are both separate Map[String, String] objects of employee IDs and employee names, where:\r\n" + //
                "mapC -> [\"123\": \"Justin\",  \"456\": \"Owen\", \"789\": \"Hugo\"]\r\n" + //
                "mapD -> [\"123\": \"George\", \"555\":\"Jack\", \"888\": \"Julian\"]");

        // Create mapC
        HashMap<String, String> mapC = new HashMap<String, String>();
        mapC.put("123", "Justin");
        mapC.put("456", "Owen");
        mapC.put("789", "Hugo");

        // Create mapD
        HashMap<String, String> mapD = new HashMap<String, String>();
        mapD.put("123", "George");
        mapD.put("555", "Jack");
        mapD.put("888", "Julian");

        System.out.println("\n Q: Combine them both into the variable \"mapC\" and print it out.");
        // Copy all the keys and values from mapD to mapC
        mapC.putAll(mapD);
        System.out.println(mapC);

        // Explanation
        System.out.println("\n Q: Print out the reason why the result no longer has the value \"Justin\"?");
        System.out.println("Answer: The result no longer has the value \"Justin\" " +
                "because it was being replaced/overwrote by \"George\" from mapD" +
                "during the merging process since they both shared the same key, which is the employee ID.");

        System.out.println("\n Q: Return values in \"mapC\" where key contains \"5\"");
        // Loop through each entry in the mapC
        for (HashMap.Entry<String, String> entry : mapC.entrySet()){
            // Check if the key contains the character "5"
            if (entry.getKey().contains("5")){
                // Print the value
                System.out.println(entry.getValue());
            }
        }

        System.out.println("\n Q: Remove map entries where the value contains the \"o\" character in \"mapC\". (ignore case)");
        // Create an iterator to loop through mapC entries
        Iterator<HashMap.Entry<String, String>> iterator = mapC.entrySet().iterator();
        // Loop through the map using the iterator
        while (iterator.hasNext()) {
            // Get the next entry in the map
            HashMap.Entry<String, String> entry = iterator.next();
            // Check if the value contains the character "o" (ignoring case)
            if (entry.getValue().toLowerCase().contains("o")) {
                // Print the value to be removed
                System.out.println(entry.getValue());
                // Remove the entry from the map
                iterator.remove();
            }
        }
    }

    private void task3(){
        System.out.println("\n Q: I have a string variable \"str\" of \"111222888222555\". Reverse this string and assign it back to variable \"str\". Print it out.");
        // Create and assign value to string
        String str = "11122288822255";
        // Create an empty string as the new placement for the reversed string
        String reversedStr = "";
        // loop through "str" and take the current character at index "i" then prepend it to "reversedStr"
        for (int i = 0; i < str.length(); i++){
            reversedStr = str.charAt(i) + reversedStr;
        }
        // Print out and compare the original and reversed string
        System.out.println("Original string: " + str + "\nReversed string: " + reversedStr);

        System.out.println("\n Q: Replace the last occurrence of \"222\" in variable \"str\"  with \"aaa\" and assign it back to variable \"str\". Print it out.");
        // Loop through
        for (int i = 0; i < str.length(); i++){
            // Check if the string contains "222"
            if(str.contains("222")){
                // Find the last index of the substring "222"
                int lastIndex = str.lastIndexOf("222");
                // Replace the last occurrence of "222" with "aaa" using substring manipulation
                str = str.substring(0, lastIndex) + "aaa" + str.substring(lastIndex + 3);
                // Display the string
                System.out.println(str);
                // Stop the loop once the replacement is done
                break;
            }
        }
    }
}