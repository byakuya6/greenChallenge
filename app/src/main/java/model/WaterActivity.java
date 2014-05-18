package model;

public class WaterActivity {

    private String name;
    private int litersUsed;
    private int timesPerDay;

    public WaterActivity(String name, int litersUsed, int timesPerDay) {
        this.name = name;
        this.litersUsed = litersUsed;
        this.timesPerDay = timesPerDay;
    }

    public WaterActivity() {
        this("DefaultWaterActivity", 0, 0);
    }

    public String getName() {
        return this.name;
    }

    public int getLitersUsed() {
        return this.litersUsed;
    }

    public int getTimesPerDay() {
        return this.timesPerDay;
    }

    public int getDailyWaterUsage() {
        return litersUsed*timesPerDay;
    }

    public void increaseTimesPerDay() {
        this.timesPerDay++;
    }
}