import java.util.Scanner;

public class Converter {

    /**
     * Main method asks user for input in binary or decimal.
     * Use this to test.
     * @param args
     */
    public static void main(String[] args) {
        // Use Scanner
        //TODO: ask user to enter a number in binary or decimal.
        //TODO: ask user what type of number it is
        //TODO: check to make sure the number is legal (a decimal number contains only 0-9). If the number is not legal, it should error out!
        //TODO: If the number is legal, convert the number to the other 3 types (Hint: There are a total of 4 types: binary, octal, hexadecimal, decimal)
        // => will call 3 other methods

        // TODO: Use this to test your methods.
       
    }


    //TODO: Arshmeet
    public String decimalToBinary(int decimal){
        return "";
    }

    //TODO: bheraz2
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

    // unction to convert a complete decimal number (both integer and fractional parts) to octal
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

    //TODO: kvrm7
    // Converts a decimal number to hexadecimal
    public String decimalToHex(int decimal) {
        if (decimal == 0) return "0";
        
        String hexDigits = "0123456789ABCDEF";
        StringBuilder hex = new StringBuilder();
      
        // Convert decimal to hexadecimal by repeatedly dividing by 16
        while (decimal > 0) {
            hex.insert(0, hexDigits.charAt(decimal % 16));
            decimal /= 16;
        }
        
        return hex.toString();
    }

    //TODO: Arshmeet
    public int binaryToDecimal(String binary){
        return 0;
    }

    //TODO: bheraz2
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

    //TODO: kvrm7 
    // Converts a binary string to hexadecimal
    public static String binaryToHex(String binary) {
        int decimalValue = Integer.parseInt(binary, 2);
        return decimalToHex(decimalValue);
    public String binaryToHex(String binary){
        
    }
}
