import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        // Initializing Scanner object
        Scanner sc = new Scanner(System.in);
        while(true) {
            // Display menu options
            System.out.println("Choose an option:");
            System.out.println("1. Encryption");
            System.out.println("2. Decryption");
            System.out.println("3. Brute Force Attack");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Calling encryption function
                    System.out.print("Enter plaintext: ");
                    String plaintext = sc.nextLine();
                    System.out.print("Enter key: ");
                    int key = sc.nextInt();
                    sc.nextLine();
                    String encrypted = encrypt(plaintext, key);
                    System.out.println("Ciphertext: " + encrypted);
                    break;
                case 2:
                    // Calling decryption function
                    System.out.print("Enter ciphertext: ");
                    String ciphertext = sc.nextLine();
                    System.out.print("Enter key: ");
                    key = sc.nextInt();
                    sc.nextLine();
                    String decrypted = decrypt(ciphertext, key);
                    System.out.println("Decrypted text: " + decrypted);
                    break;
                case 3:
                    // Calling brute force attack function
                    System.out.print("Enter ciphertext: ");
                    ciphertext = sc.nextLine();
                    bruteForceAttack(ciphertext);
                    break;
                case 4:
                    // Exit program
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Encryption function
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                // Performing the shift
                char encryptedChar = (char) ((c - base + key) % 26 + base);
                result.append(encryptedChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Decryption function
    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);  // Reusing the encrypt method by inverting the key
    }

    // Brute force attack function
    public static void bruteForceAttack(String text) {
        for (int i = 0; i < 26; i++) {
            String possiblePlaintext = decrypt(text, i);
            System.out.println("Key " + i + ": " + possiblePlaintext);
        }
    }
}