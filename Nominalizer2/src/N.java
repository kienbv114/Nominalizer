/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class TextNormalizer {

    private final String inputFile = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Nominalizer2\\input.txt";
    private final String outputFile = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Nominalizer2\\output.txt";
    private String line;  // đọc chuỗi từ file ra
    
    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public String getLine() {
        return line;
    }

    public TextNormalizer() {

    }

    public void normalizeText() throws IOException {
        String normalizedText = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(this.inputFile))) {
            
            boolean firstLine = true;
            while ((this.line = reader.readLine()) != null) {
                if (firstLine) {
                    this.line = capitalizeFirstWord();  // viet hoa chu dau
                    firstLine = false;
                }
                this.line = removeExtraSpaces();
                this.line = capitalizeAfterDot();
                this.line = removeSpacesInsideQuotes();
                normalizedText += line + "\n";
            }
            reader.close();
        }
//        normalizedText += ".";  // đảm bảo cuối câu có dấu chấm

        writeOutput(normalizedText);
    }

    public String capitalizeFirstWord() {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    public String removeExtraSpaces() {
//        return line.replaceAll("\\s+    ", " ");
          return line.replaceAll("\\s+   ", " ").trim();
    }

    public String capitalizeAfterDot() {
        return line.replaceAll("\\.\\s+(\\w)", ". $1");
    }

    public String removeSpacesInsideQuotes() {
        return line.replaceAll("\\s*\"(.*?)\"\\s*", "\"$1\"");
    }

    public void writeOutput(String normalizedText) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.outputFile))) {
            writer.write(normalizedText);
    }
    }

    public void exportOutput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
