// DERIN BULDANLI - 20210601012
// AYSE OZER - 20200601040
// MEHMET TASOGLU - 20210601059
// BERYKAY ISIK - 20190601204
// LIVESTOCK FARM

// --- Adapter Pattern (Object Adapter) ---

// Target interface
interface SignalSender {
    void sendLocationData(Cattle cattle, double[] location);
}

// Concrete Target: ZigbeeSender
class ZigbeeSender implements SignalSender {
    @Override
    public void sendLocationData(Cattle cattle, double[] location) {
        System.out.println("Sending the location of " + cattle.getType() + " which has ID: " + cattle.getCattleId() + " via Zigbee: [" + location[0] + ", " + location[1] + "]");
    }
}

// Adaptee: BluetoothDevice
class BluetoothDevice {
    public void sendBluetoothLocation(Cattle cattle, double[] location) {
        System.out.println("Sending the location of " + cattle.getType() + " which has ID: " + cattle.getCattleId() + " via Bluetooth: [" + location[0] + ", " + location[1] + "]");
    }
}

// Adapter: Adapts Bluetooth to Zigbee
class BluetoothToZigbeeAdapter implements SignalSender {
    private BluetoothDevice bluetoothDevice;

    public BluetoothToZigbeeAdapter(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }

    @Override
    public void sendLocationData(Cattle cattle, double[] location) {
        bluetoothDevice.sendBluetoothLocation(cattle, location);
        System.out.println("Changing Bluetooth data to Zigbee format for server...");
    }
}
