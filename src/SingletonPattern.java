// DERIN BULDANLI - 20210601012
// AYSE OZER - 20200601040
// MEHMET TASOGLU - 20210601059
// BERYKAY ISIK - 20190601204
// LIVESTOCK FARM

import java.util.*;

// --- Singleton Pattern ---

// Singleton class for cattle location storage
class LocationDatabase {
    private static LocationDatabase instance;
    private Map<String, double[]> locationData;

    private LocationDatabase() {
        locationData = new HashMap<>();
    }

    public static synchronized LocationDatabase getInstance() {
        if (instance == null) {
            instance = new LocationDatabase();
        }
        return instance;
    }

    public void updateLocation(String cattleId, double[] location) {
        locationData.put(cattleId, location);
        System.out.println("Location updated for Cattle which has ID: " + cattleId + " = [" + location[0] + ", " + location[1] + "]");
    }

    public Map<String, double[]> getAllLocations() {
        return new HashMap<>(locationData);
    }
}
