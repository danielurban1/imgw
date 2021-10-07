package pl.imgw.model;

public class ConfigProperties {
    private String stationName;
    private String directory;

    public ConfigProperties(String stationName, String directory) {
        this.stationName = stationName;
        this.directory = directory;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
