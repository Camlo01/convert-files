import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;

import java.io.*;

public class convertMain {

    //Path of where is located the files
    private static final String path = "C:\\Users\\Camilo\\Desktop\\music-library\\";

    // Main Method
    public static void main(String[] args) {
        File folder = new File(path);
        findAllFilesInFolder(folder);
    }

    /**
     * Iterate a path
     *
     * @param folder where is ubicated the files
     */
    private static void findAllFilesInFolder(File folder) {
        for (File file : folder.listFiles()) {
            try {
                convertToWav(file);
                System.out.println("Convertido exitosamente! " + file.getName());
            } catch (Exception e) {
                System.out.println("Hubo un problema con " + file.getName());
            }
        }
    }

    /**
     * method in charge of providing the new name to the final file
     *
     * @param fileName with the new extension file
     * @return Sting
     */
    private static String convertFileExtensionName(String fileName) {
        if (fileName.endsWith("mp3")) {
            return fileName.substring(0, fileName.length() - 3) + "wav";
        } else {
            return fileName;
        }
    }

    /**
     * Method in charge of converting mp3 files to wav
     *
     * @param file to convert
     */
    private static void convertToWav(File file) {
        File wavFile = new File(file.getAbsolutePath().replace(".mp3", ".wav"));
        try {
            Converter converter = new Converter();
            String destName = convertFileExtensionName(file.getAbsolutePath());
            converter.convert(file.getAbsolutePath(), destName);
        } catch (JavaLayerException e) {
            System.out.println("Error al convertir el archivo: " + e.getMessage());
        }
    }

}
