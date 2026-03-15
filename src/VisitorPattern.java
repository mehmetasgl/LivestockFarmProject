// DERIN BULDANLI - 20210601012
// AYSE OZER - 20200601040
// MEHMET TASOGLU - 20210601059
// BERYKAY ISIK - 20190601204
// LIVESTOCK FARM

// --- Visitor Pattern ---

// Visitor interface for double dispatch
interface Visitor {
    void visit(DairyCattle dairyCattle);
    void visit(BeefCattle beefCattle);
}

// Concrete Visitor1: VeterinaryPhysician
class VeterinaryPhysician implements Visitor {
    private String name;

    public VeterinaryPhysician(String name) {
        this.name = name;
    }

    @Override
    public void visit(DairyCattle dairyCattle) {
        System.out.println("Veterinary Physician " + name + " vaccinates Dairy Cattle which has ID: " + dairyCattle.getCattleId());
    }

    @Override
    public void visit(BeefCattle beefCattle) {
        System.out.println("Veterinary Physician " + name + " vaccinates Beef Cattle which has ID: " + beefCattle.getCattleId());
    }
}

// Concrete Visitor2: MinistryInspector
class MinistryInspector implements Visitor {
    private String name;

    public MinistryInspector(String name) {
        this.name = name;
    }

    @Override
    public void visit(DairyCattle dairyCattle) {
        if (dairyCattle.hasEarTag()) {
            System.out.println("Ministry Inspector " + name + " confirms Dairy Cattle which has ID: " + dairyCattle.getCattleId() + " has an EAR TAG.");
        } else {
            System.out.println("!!!WARNING: Dairy Cattle which has ID: " + dairyCattle.getCattleId() + " has NO EAR TAG.!!!");
        }
    }

    @Override
    public void visit(BeefCattle beefCattle) {
        if (beefCattle.hasEarTag()) {
            System.out.println("Ministry Inspector " + name + " confirms Beef Cattle which has ID: " + beefCattle.getCattleId() + " has an EAR TAG.");
        } else {
            System.out.println("!!!WARNING: Beef Cattle which has ID: " + beefCattle.getCattleId() + " has NO EAR TAG.!!!");
        }
    }
}
