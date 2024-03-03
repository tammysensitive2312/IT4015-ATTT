import java.util.Scanner;

public class Main {

    public static String encrypt(String text, int shift, int mod) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                // kiểm tra đầu vào để có thể dịch đúng ký tự in thường hoặc hoa tương ứng ( có thể bỏ qua )
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                // tính toán giá trị dịch chuyển (ý tưởng là tìm khoảng cách từ a đến ký tự hiện tại cộng với
                // độ dịch chuyển
                int offset = (character - base + shift) % mod;
                result.append((char) (base + offset));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift, int mod) {
        return encrypt(text, mod - shift, mod);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        int shift = sc.nextInt();
        int mod = 26;

        String encryptedMessage = encrypt(message, shift, mod);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift, mod);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
