import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharacterCounter {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = keyboard.nextLine();

        File file = new File(fileName);

        try {

            int characters = countCharacters(file);
            int words = countWords(file);
            int lines = countLines(file);

            System.out.println("\n----- File Statistics -----");
            System.out.println("Characters: " + characters);
            System.out.println("Words: " + words);
            System.out.println("Lines: " + lines);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        keyboard.close();
    }

    public static int countCharacters(File file) throws FileNotFoundException {

        int count = 0;

        try (Scanner input = new Scanner(file)) {

            while (input.hasNextLine()) {
                String line = input.nextLine();
                count += line.length();
            }
        }

        return count;
    }

    public static int countWords(File file) throws FileNotFoundException {

        int count = 0;

        try (Scanner input = new Scanner(file)) {

            while (input.hasNext()) {
                input.next();
                count++;
            }
        }

        return count;
    }

    public static int countLines(File file) throws FileNotFoundException {

        int count = 0;

        try (Scanner input = new Scanner(file)) {

            while (input.hasNextLine()) {
                input.nextLine();
                count++;
            }
        }

        return count;
    }
}

// Danielle Changes made
