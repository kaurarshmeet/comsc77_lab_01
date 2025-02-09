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
    public String decimalToOctal(int decimal) {
        return "";
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
        int length = binary.length(); 
        int padding = (3-(length % 3)) % 3; // calculate required padding, number of zeros needed
        StringBuilder paddedBinary = new StringBuilder();

        //while loop tuns until padding becomes zero, checks if it still needs to add
        while (padding --> 0){
            paddedBinary.append("0");
        }
        paddedBinary.append(binary);


        return "";
    }

    //TODO: kvrm7
    public String binaryToHex(String binary){
        return "";
    }
}
