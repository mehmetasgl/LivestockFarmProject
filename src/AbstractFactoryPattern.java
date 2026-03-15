// DERIN BULDANLI - 20210601012
// AYSE OZER - 20200601040
// MEHMET TASOGLU - 20210601059
// BERYKAY ISIK - 20190601204
// LIVESTOCK FARM

// ---- Abstract Factory Pattern ----

// Abstract ProductA for Protein
abstract class Protein {
    void type() {
        System.out.println("This is Protein");
    }
    abstract String getName();
}

// Concrete ProductA1 for Protein: Soybean
class Soybean extends Protein {
    @Override
    public String getName() {
        return "It's Soybean";
    }
}

// Concrete ProductA2 for Protein: Canola
class Canola extends Protein {
    @Override
    public String getName() {
        return "It's Canola";
    }
}

// Abstract ProductB for Carbohydrate
abstract class Carbohydrate {
    void type() {
        System.out.println("This is Carbohydrate");
    }
    abstract String getName();
}

// Concrete ProductB1 for Carbohydrate: Corn
class Corn extends Carbohydrate {
    @Override
    public String getName() {
        return "It's Corn";
    }
}

// Concrete ProductB2 for Carbohydrate: Wheat
class Wheat extends Carbohydrate {
    @Override
    public String getName() {
        return "It's Wheat";
    }
}

// Abstract Factory for Cattle Feed
abstract class CattleFeedFactory {
    abstract Carbohydrate createCarbohydrate();
    abstract Protein createProtein();
}

// Concrete Factory1 for Dairy Feed
class DairyCattleFeedFactory extends CattleFeedFactory {
    public Carbohydrate createCarbohydrate() {
        return new Corn();
    }
    public Protein createProtein() {
        return new Soybean();
    }
}

// Concrete Factory2 for Beef Feed
class BeefCattleFeedFactory extends CattleFeedFactory {
    public Carbohydrate createCarbohydrate() {
        return new Wheat();
    }
    public Protein createProtein() {
        return new Canola();
    }
}
