/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Daniel McCoy Stephenson
 * @author Pasarus
 */
public class JsonWriterReader {
    private static String FILE_PATH;
    private static Type LIST_MAP_TYPE;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public JsonWriterReader() {
        LIST_MAP_TYPE = new TypeToken<List<Map<String, String>>>(){}.getType();
    }

    /**
     * Method to initialize the file path.
     *
     * @param filePath to initialize with.
     */
    public void initialize(String filePath) {
        FILE_PATH = filePath;
    }

    /**
     * Method to write out some data to a file.
     *
     * @param saveData to save.
     * @param fileName to save to.
     * @return {@link boolean} signifying whether or not the operation was successful.
     */
    public boolean writeOutFiles(List<Map<String, String>> saveData, String fileName) {
        try {
            writeDataToFileUsingStream(fileName, saveData);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    private void writeDataToFileUsingStream(String fileName, Object saveData) throws IOException {
        File parentFolder = new File(FILE_PATH);
        parentFolder.mkdir();
        File file = new File(FILE_PATH, fileName);
        file.createNewFile();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
        outputStreamWriter.write(gson.toJson(saveData));
        outputStreamWriter.close();
    }

    /**
     * Method to load data from a filename.
     *
     * @param filename to specify which file to load from.
     * @return {@link List<Map<String, String>>} containing the data from the file.
     */
    public List<Map<String, String>> loadDataFromFilename(String filename) {
        try{
            return loadDataFromFileUsingGson(filename);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private List<Map<String, String>> loadDataFromFileUsingGson(String filename) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonReader reader = new JsonReader(new InputStreamReader(Files.newInputStream(Paths.get(filename)), StandardCharsets.UTF_8));
        return gson.fromJson(reader, LIST_MAP_TYPE);
    }
}