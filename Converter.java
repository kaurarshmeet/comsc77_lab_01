import java.util.Scanner;

/**
 * @author Arshmeet Kaur
 * @author Bryan Heraz
 * @author Khushi Verma
 */
public class Converter {

    /**
     * Main method asks user for input in binary or decimal.
     * Use this to test.
     *
     * @param args
     */
    public static void main(String[] args) {

        // Use Scanner

        // ask user to enter a number in binary or decimal.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number (unsigned)!");
        String number = scanner.nextLine();

        // ask user what type of number it is
        System.out.println("What type of number is it? ");
        String type = scanner.nextLine();

        if (type.equalsIgnoreCase("decimal")) {
            // check if it's a legal number, then call the methods
            String acceptable_decimal = "0123456789.";
            if (containsOnly(number, acceptable_decimal)) {
                double decimal = Double.parseDouble(number);
                System.out.println("Binary: " + decimalToBinary(decimal, 8));
                System.out.println("Octal: " + decimalToOctal(decimal, 8));
                System.out.println("Hex: " + decimalToHex(decimal, 8));
            } else {
                throw new IllegalArgumentException("Not a valid decimal number.");
            }
        } else if (type.equalsIgnoreCase("binary")) {
            // check if valid numbers
            String acceptable_binary = "01.";
            if (containsOnly(number, acceptable_binary)){
                System.out.println("Decimal: " + binaryToDecimal(number));
                System.out.println("Octal: " + binaryToOctal(number));
                System.out.println("Hex: " + binaryToHex(number));
            } else {
                throw new IllegalArgumentException("Not a valid binary number.");
            }
        } else {
            throw new IllegalArgumentException("Not a valid type. Binary or decimal only.");
        }
    }

    public static boolean containsOnly(String test, String allowed) {
        for(String c: test.split("")){
            if (!allowed.contains(c))
                return false;
        }
        return true;
    }

    /**
     * Converts decimal to binary.
     *
     * @param decimal decimal number
     * @return the binary equivalent.
     * @author Arshmeet Kaur
     */
    public static String decimalToBinary(double decimal, int precision) {
        if (decimal % 1  == 0) // if this is an integer, need only call the integer converter.
            return decimalToBinaryInt((int) decimal);

        // convert number to string, process integer and float parts seperately.
        String decimal_string = Double.toString(decimal);
        String[] parts = decimal_string.split("\\.");
        String integerPart = decimalToBinaryInt(Integer.parseInt(parts[0]));
        String fractionalPart = decimalToBinaryFloat(Double.parseDouble("0." + parts[1]), precision);
        String result = integerPart + fractionalPart;
        return result;
    }

    /**
     * Helper method.
     * Uses division method convert integer to binary.
     * @param integerPart integer.
     * @return binary representation.
     * @author Arshmeet Kaur
     */
    public static String decimalToBinaryInt(int integerPart) {
        String result = "";

        while (integerPart != 1 && integerPart != 0) {
            int remainder = integerPart % 2;
            integerPart = integerPart / 2;
            result = Integer.toString(remainder) + result;
        }

        if (integerPart == 1)
            result = Integer.toString(integerPart) + result;
        return result;
    }

    /**
     * Helper method. Uses multiplication method to convert fraction to binary.
     * @param fractionalPart the fractional part of a decimal number.
     * @return the binary representation.
     * @author Arshmeet Kaur
     */
    public static String decimalToBinaryFloat(double fractionalPart, int precision) {
        // precision = num of decimals in the original fraction
        String result = "";

        for (int i = 0; i < precision; i++ ) {

            // multiply fraction by 2, figure out whether to store 0 or 1.
            // update the fractional Part for the next loop.
            double remainder = fractionalPart * 2;
            if (remainder > 1) {
                result = result + "1";
                fractionalPart = (fractionalPart * 2) - 1;
            } else {
                result = result + "0";
                fractionalPart = fractionalPart * 2;
            }
        }

        return "." + result;
    }

    //TODO: bheraz2

    // function to convert a complete decimal number (both integer and fractional parts) to octal
    public static String decimalToOctal(double decimal, int precision) {
        int integerPart = (int) decimal;
        double fractionalPart = decimal - integerPart;

        String octalInteger = decimalToOctalIntegerPart(integerPart);
        String octalFraction = decimalToOctalFractionalPart(fractionalPart, precision);

        if (octalFraction.isEmpty()) {
            return octalInteger;
        } else {
            return octalInteger + "." + octalFraction;
        }
    }

    public static String decimalToOctalIntegerPart(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        String octalInteger = "";

        while (decimal > 0) {
            int remainder = decimal % 8;
            octalInteger = remainder + octalInteger;
            decimal = decimal / 8;
        }

        return octalInteger;
    }

    // function to convert the fractional part of the decimal number to octal
    public static String decimalToOctalFractionalPart(double fractionalPart, int precision) {
        String octalFraction = "";

        while (precision > 0) {
            fractionalPart *= 8;
            int integerPart = (int) fractionalPart;
            octalFraction += integerPart;
            fractionalPart -= integerPart;
            precision--;
        }

        return octalFraction;
    }


    //TODO: kvrm7
    // Convert a decimal number (including fractional part) to hexadecimal
    public static String decimalToHex(double decimal, int precision) {
        int integerPart = (int) decimal; // Extract integer part
        double fractionalPart = decimal - integerPart; // Extract fractional part

        String hexInteger = decimalToHex(integerPart); // Convert integer part to hex
        String hexFraction = decimalToHexFractionalPart(fractionalPart, precision); // Convert fractional part to hex


        return hexFraction.isEmpty() ? hexInteger : hexInteger + "." + hexFraction;
    }

    // Convert an integer decimal number to hexadecimal
    private static String decimalToHex(int decimal) {
        if (decimal == 0) return "0"; // Handle zero case
        StringBuilder hex = new StringBuilder();
        String hexDigits = "0123456789ABCDEF";
        while (decimal > 0) {
            hex.insert(0, hexDigits.charAt(decimal % 16)); // Get remainder and convert to hex digit
            decimal /= 16;  // Divide by 16 to process the next digit
        }
        return hex.toString();
    }
 // Convert the fractional part of a decimal number to hexadecimal
    private static String decimalToHexFractionalPart(double fractionalPart, int precision) {
        StringBuilder hexFraction = new StringBuilder();
        while (precision > 0 && fractionalPart > 0) {
            fractionalPart *= 16; // Multiply fractional part by 16
            int integerPart = (int) fractionalPart; // Extract integer part
            hexFraction.append(Integer.toHexString(integerPart).toUpperCase()); // Convert to hex digit
            fractionalPart -= integerPart; // Remove integer part from fractional part
            precision--; // Decrease precision counter
        }
        return hexFraction.toString();
    }
    /**
     * Converts a binary number to a decimal.
     * @param binary the binary number
     * @return decimal representation.
     * @author Arshmeet Kaur
     */
    public static double binaryToDecimal(String binary) {
        String[] parts = binary.split("\\.");
        int integerPart = binaryToDecimalInt(parts[0]);
        double floatPart = binaryToDecimalFloat(parts[1]);
        return integerPart + floatPart;
    }

    /**
     * Helper method, converting just the "whole number" part of the binary to an integer.
     * @param binary binary input.
     * @return the decimal representation.
     * @author Arshmeet Kaur
     */
    public static int binaryToDecimalInt(String binary){
        int result = 0;
        String[] bytes = binary.split("");
        int places = bytes.length - 1;
        for(int i = 0; i < bytes.length; i++){
            result += Integer.parseInt(bytes[places]) * Math.pow(2, i);
            places--;
        }
        return result;
    }

    /**
     * Helper method, converting just the "fractional number" part of the binary to an integer.
     * @param binary binary input.
     * @return the decimal representation.
     * @author Arshmeet Kaur
     */
    public static double binaryToDecimalFloat(String binary){
        double result = 0;
        String[] bytes = binary.split("");
        for(int i = 0; i < bytes.length; i++){
            result += Double.parseDouble(bytes[i]) * Math.pow(2, -(i+1));
        }
        return result;
    }

    //TODO: bheraz2
    // Function to convert a complete binary number (both integer and fractional parts) to octal
    public static String binaryToOctal(String binary) {
        String[] parts = binary.split("\\.");  // Split binary input into integer and fractional parts
        String integerPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";

        // Convert the integer part of the binary to octal
        String octalInteger = binaryToOctalIntegerPart(integerPart);

        // Convert the fractional part of the binary to octal
        String octalFraction = binaryToOctalFractionalPart(fractionalPart);

        // Combine integer and fractional parts
        if (octalFraction.isEmpty()) {
            return octalInteger;
        } else {
            return octalInteger + "." + octalFraction;
        }
    }
    public static String binaryToOctalIntegerPart(String binary) {

        int padding = (3 - (binary.length() % 3)) % 3; //Number of zeros needed to make lenght in binary
        StringBuilder paddedBinary = new StringBuilder();
        //adds values until append values is 0
        while (padding-- > 0) {
            paddedBinary.append("0");
        }
        paddedBinary.append(binary);

        StringBuilder octalInteger = new StringBuilder();

        // Process every 3 bits as a group
        for (int i = 0; i < paddedBinary.length(); i += 3) {
            String group = paddedBinary.substring(i, i + 3);
            int decimalValue = Integer.parseInt(group, 2);  // Convert binary group to decimal
            octalInteger.append(decimalValue);
        }

        return octalInteger.toString();
    }
    // Function to convert the fractional part of the binary number to octal
    public static String binaryToOctalFractionalPart(String binary) {
        StringBuilder octalFraction = new StringBuilder();
        double fractionalPart = Integer.parseInt(binary, 2) / Math.pow(2, binary.length());

        // Convert the fractional part of the binary to octal
        while (fractionalPart != 0) {
            fractionalPart *= 8;
            int integerPart = (int) fractionalPart;
            octalFraction.append(integerPart);
            fractionalPart -= integerPart;
        }

        return octalFraction.toString();
    }

    //TODO: kvrm7 
    // Convert a binary number (including fractional part) to hexadecimal
    public static String binaryToHex(String binary) {
        String[] parts = binary.split("\\."); // Split binary number into integer and fractional parts
        String integerPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";

        String hexInteger = binaryToHexIntegerPart(integerPart); // Convert integer part to hex
        String hexFraction = binaryToHexFractionalPart(fractionalPart); // Convert fractional part to hex

        return hexFraction.isEmpty() ? hexInteger : hexInteger + "." + hexFraction;
    }

    // Convert the integer part of a binary number to hexadecimal
    private static String binaryToHexIntegerPart(String binary) {
        int decimalValue = Integer.parseInt(binary, 2); // Convert binary to decimal
        return decimalToHex(decimalValue); // Convert decimal to hex
    }

    // Convert the fractional part of a binary number to hexadecimal
    private static String binaryToHexFractionalPart(String binaryFraction) {
        double fractionalDecimal = 0.0;
        for (int i = 0; i < binaryFraction.length(); i++) {
            if (binaryFraction.charAt(i) == '1') {
                fractionalDecimal += Math.pow(2, -(i + 1)); // Convert binary fraction to decimal fraction
            }
        }
        return decimalToHexFractionalPart(fractionalDecimal, 5); // Convert decimal fraction to hex with precision 5
    }
}
