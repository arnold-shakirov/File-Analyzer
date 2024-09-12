import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        try {
            Scanner filik = new Scanner(System.in);
            System.out.println("Enter filename: ");
            Map<String, Integer> words = new TreeMap<String, Integer>();
            Map<String, Integer> characters = new TreeMap<String, Integer>();
            File file = new File(filik.nextLine());
            filik = new Scanner(file);
            while (filik.hasNextLine()) {
                String line = filik.nextLine();
                String wordsList[] = line.split("[^a-zA-Z]+");
                for (String st : wordsList) {
                    if (!st.isEmpty()) {
                        String word = st.toLowerCase();
                        for (char c : st.toCharArray()) {
                            String charString = String.valueOf(c).toLowerCase();
                            if (characters.containsKey(charString)) {
                                characters.put(charString, characters.get(charString) + 1);
                            } else {
                                characters.put(charString, 1);
                            }
                        }
                        if (words.containsKey(word)) {
                            words.put(word, words.get(word) + 1);
                        } else {
                            words.put(word, 1);
                        }
                    }
                }
            }
            int allCharacters = 0;
            for (int i : characters.values()) {
                allCharacters += i;
            }
            List<Map.Entry<String, Integer>> sortedCharacters = new ArrayList<>(characters.entrySet());
            Collections.sort(sortedCharacters, (a, b) -> b.getValue().compareTo(a.getValue()));
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(words.entrySet());
            Collections.sort(sortedWords, (a, b) -> b.getValue().compareTo(a.getValue()));
            System.out.println("There are " + allCharacters + " characters");
            System.out.println("There are " + words.size() + " words");
            System.out.println("The list of characters: ");
            for (Map.Entry<String, Integer> entry : sortedCharacters) {
                System.out.println("The character " + entry.getKey() + " appeared " + entry.getValue() + " times.");
            }
            System.out.println("The list of words: ");
            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println("The word " + entry.getKey() + " appeared " + entry.getValue() + " times.");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
    }
}