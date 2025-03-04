package model;

public class RefuseProduction implements INamable {

    private String name;
    private int pointValue;

    public RefuseProduction(String name, int pointValue) {
        this.name = name;
        this.pointValue = pointValue;
    }

    public RefuseProduction(String name) {
        this.name = name;
        this.pointValue = 0;
    }

    public RefuseProduction() {
        this("DefaultRefuseProduction", 0);
    }

    public String getName() {
        return this.name;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof RefuseProduction)) return false;
        RefuseProduction otherRefuseProduction = (RefuseProduction)other;
        return (otherRefuseProduction.getName().equals(this.getName()));
    }

    public void cloneRefuseProduction(RefuseProduction source) {
        this.setPointValue(source.getPointValue());
    }
}
