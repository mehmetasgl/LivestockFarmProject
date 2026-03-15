// DERIN BULDANLI - 20210601012
// AYSE OZER - 20200601040
// MEHMET TASOGLU - 20210601059
// BERYKAY ISIK - 20190601204
// LIVESTOCK FARM

// -- Main Class --

public class Livestock {
    public static void main(String[] args) {

        // Create cattle
        DairyCattle dairyCattle = new DairyCattle();
        BeefCattle beefCattle  = new BeefCattle();

        // Create and register observer (Observer Pattern)
        Farmer farmer = new Farmer("Ali");
        dairyCattle.registerObserver(farmer);
        beefCattle.registerObserver(farmer);

        // Feed cattle (Abstract Factory Pattern)
        System.out.println("\n****** FEEDING TIME ******");
        dairyCattle.feed();
        beefCattle.feed();

        // Update locations (Observer + Singleton Pattern)
        System.out.println("\n****** UPDATING LOCATIONS ******");
        dairyCattle.changeLocation(40, 28);
        beefCattle.changeLocation(42, 36); // outside boundary → triggers observer

        // Send locations (Adapter Pattern)
        System.out.println("\n****** SENDING LOCATION DATA ******");
        SignalSender zigbeeSender    = new ZigbeeSender();
        BluetoothDevice bluetoothDevice = new BluetoothDevice();
        SignalSender bluetoothAdapter   = new BluetoothToZigbeeAdapter(bluetoothDevice);

        zigbeeSender.sendLocationData(dairyCattle, dairyCattle.getLocation());
        bluetoothAdapter.sendLocationData(beefCattle, beefCattle.getLocation());

        // Visitor Pattern: Veterinary visit
        System.out.println("\n****** AUTUMN SEASON: VETERINARY VISIT ******");
        VeterinaryPhysician vet = new VeterinaryPhysician("Dr. Ayse");
        dairyCattle.accept(vet);
        beefCattle.accept(vet);

        // Set ear tag status
        dairyCattle.setEarTag(true);
        beefCattle.setEarTag(false);

        // Visitor Pattern: Ministry inspection
        System.out.println("\n****** SPRING SEASON: MINISTRY INSPECTION ******");
        MinistryInspector inspector = new MinistryInspector(" Derin");
        dairyCattle.accept(inspector);
        beefCattle.accept(inspector);

        // Show Singleton database content
        System.out.println("\n****** DATABASE CONTENT *******");
        LocationDatabase db = LocationDatabase.getInstance();
        db.getAllLocations().forEach((id, coordinates) -> {
            System.out.printf("Cattle ID: %s  [%.1f, %.1f]%n", id, coordinates[0], coordinates[1]);
        });
    }
}
