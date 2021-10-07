package pl.imgw.util;

import pl.imgw.model.ConfigProperties;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtil {
    private String filepath;

    public FileUtil(final ConfigProperties configProperties){
        setFilePath(configProperties);
    }

    public void saveFile(final String fileContent){
        try(FileWriter fileWriter= new FileWriter(filepath)) {
            fileWriter.write(fileContent);
        } catch (IOException e){
            e.getCause();
        }
    }

    public boolean isFileSaved(){
        File file = new File(filepath);
        return file.exists() && ! file.isDirectory();
    }

    private void setFilePath(final ConfigProperties configProperties){
        filepath = configProperties.getDirectory()
                + "//" + getCurrentDate()
                + "_" + configProperties.getStationName() + ".json";
    }

    public String getFilepath(){
        return filepath;
    }

    private String getCurrentDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }
}
