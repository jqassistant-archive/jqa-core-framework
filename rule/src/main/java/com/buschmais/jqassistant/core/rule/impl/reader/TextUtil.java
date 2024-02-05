package com.buschmais.jqassistant.core.rule.impl.reader;


public class TextUtil {

    private TextUtil() {
    }

    public static String removeIndent(String text) {

        String resultLines = removeEmptyLines(text);
        String resultSpaces = removeExtraSpaces(text);
        String[] lines = text.split("\\r?\\n");
        int startIndex = 0;
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].trim().isEmpty()) {
                startIndex = i;
                break;
            }
        }


       if (startIndex >= 1){
           return resultLines;
        } else {
           return resultSpaces;
       }
    }

    public static String removeExtraSpaces(String text) {
        // Split the input by newline character
        String[] lines = text.split("\\n");
        // Process each line
        StringBuilder formattedText = new StringBuilder();
        boolean firstLine = true;
        for (String line : lines) {
            line = line.trim(); // Trim leading and trailing spaces

            // Replace multiple spaces with single space
            line = line.replaceAll("\\s+", " ");

            // Ensure there's a single whitespace at the beginning and end
            if (!line.isEmpty()) {
                if (!firstLine) {
                    // Add newline before non-first line
                    formattedText.append("\n");
                }
                if (line.charAt(0) != ' ') {
                    if (firstLine) {
                        line = " " + line;
                    } else {
                        line = "" + line;
                    }
                }
                if (line.charAt(line.length() - 1) != ' ') {
                    line = line + " ";
                }

                formattedText.append(line);
                firstLine = false;
            }
        }

        return formattedText.toString();
    }



    private static String removeEmptyLines(String text){

    String[] lines = text.split("\\r?\\n");
    // Split the string into lines

    // Find the index of the first text line
    int startIndex = 0;
        for (int i = 0; i < lines.length; i++) {
        if (!lines[i].isBlank()) {
            startIndex = i;
            break;
        }
    }

    // Find the index of the last text line
    int endIndex = lines.length - 1;
        for (int i = lines.length - 1; i >= 0; i--) {
        if (!lines[i].isBlank()) {
            endIndex = i;
            break;
        }
    }

    // Reconstruct the string excluding empty lines before and after text
    StringBuilder resultBuilder = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
        resultBuilder.append(lines[i]).append("\n");
    }

        return resultBuilder.toString();
}
}
