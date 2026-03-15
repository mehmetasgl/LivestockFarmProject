// DERIN BULDANLI - 20210601012
// AYSE OZER - 20200601040
// MEHMET TASOGLU - 20210601059
// BERYKAY ISIK - 20190601204
// LIVESTOCK FARM

import java.util.UUID;

// Base class for Cattle
// - Client for Abstract Factory Pattern
// - Concrete Subject for Observer Pattern
// - Element for Visitor Pattern
abstract class Cattle extends Subject {
    private final String cattleId;
    private boolean hasEarTag = false;
    private double latitude;
    private double longitude;

    // Farm boundaries
    private static final double MIN_LAT  = 40.0;
    private static final double MAX_LAT  = 41.0;
    private static final double MIN_LONG = 28.0;
    private static final double MAX_LONG = 29.0;

    public Cattle() {
        this.cattleId = generateCattleId();
    }

    // Generate unique cattle ID
    private String generateCattleId() {
        if (getType().equals("Dairy Cattle")) {
            return "D_CATTLE-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        } else {
            return "B_CATTLE-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
    }

    public String getCattleId() {
        return cattleId;
    }

    public boolean hasEarTag() {
        return hasEarTag;
    }

    public void setEarTag(boolean hasEarTag) {
        this.hasEarTag = hasEarTag;
    }

    // Update cattle location and notify observers if outside boundary
    public void changeLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        System.out.println(getType() + " which has ID: " + cattleId + " updated location to [" + latitude + ", " + longitude + "]");

        // Store in Singleton database
        LocationDatabase.getInstance().updateLocation(cattleId, getLocation());

        // Outside boundary? Notify observers.
        if (!isWithinBoundary()) {
            setState(getType() + " which has ID: " + cattleId + " has crossed the farm boundary!!!");
            notifyObservers();
        }
    }

    private boolean isWithinBoundary() {
        return latitude >= MIN_LAT && latitude <= MAX_LAT
            && longitude >= MIN_LONG && longitude <= MAX_LONG;
    }

    public double[] getLocation() {
        return new double[]{latitude, longitude};
    }

    // Visitor Pattern method (double dispatch)
    public abstract void accept(Visitor visitor);
    public abstract String getType();
    public abstract void feed();
}

// Concrete Element A: DairyCattle
class DairyCattle extends Cattle {
    private final CattleFeedFactory feedFactory = new DairyCattleFeedFactory();

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // double dispatch call
    }

    @Override
    public String getType() {
        return "Dairy Cattle";
    }

    @Override
    public void feed() {
        Carbohydrate carb = feedFactory.createCarbohydrate();
        Protein protein = feedFactory.createProtein();
        System.out.println("Feeding Dairy Cattle which has ID: " + getCattleId() + " with:");
        System.out.println("- " + carb.getName());
        System.out.println("- " + protein.getName());
    }
}

// Concrete Element B: BeefCattle
class BeefCattle extends Cattle {
    private final CattleFeedFactory feedFactory = new BeefCattleFeedFactory();

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // double dispatch call
    }

    @Override
    public String getType() {
        return "Beef Cattle";
    }

    @Override
    public void feed() {
        Carbohydrate carb = feedFactory.createCarbohydrate();
        Protein protein = feedFactory.createProtein();
        System.out.println("Feeding Beef Cattle which has ID: " + getCattleId() + " with:");
        System.out.println("- " + carb.getName());
        System.out.println("- " + protein.getName());
    }
}
