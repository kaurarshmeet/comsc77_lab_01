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
    public String decimalToHex(int decimal) {
        return "";
    }

    //TODO: Arshmeet
    public int binaryToDecimal(String binary){
        return 0;
    }

    //TODO: bheraz2
    public String binaryToOctal(String binary){
      
    }

    //TODO: kvrm7
    public String binaryToHex(String binary){
        return "";
    }
}
