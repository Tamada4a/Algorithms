public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // This variable will contain decoded string
        StringBuilder stringBuilder = new StringBuilder();

        // Split input Morse Code by triple spaces - split words
        String[] splitMorseCode = morseCode.strip().split("   ");

        // For each word
        for (String code : splitMorseCode) {
            // Split word by space - get array of symbols
            String[] splitCode = code.split(" ");

            // Decode each symbol
            for (String sym : splitCode) {
                stringBuilder.append(MorseCode.get(sym));
            }
            // Appending space between words
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().strip();
    }
}