/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        TextNormalizer norma = new TextNormalizer();
        try {

            norma.normalizeText();
            System.out.println("Text normalization complete. Go to file:  ");
            norma.exportOutput();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
}
