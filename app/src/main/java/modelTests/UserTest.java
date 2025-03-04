package modelTests;

import android.test.InstrumentationTestCase;

import model.ElectricDevice;
import model.RefuseProduction;
import model.User;
import model.WaterActivity;

public class UserTest extends InstrumentationTestCase {

    public void testInsertElectricDevice() {
        User user = User.getInstance();
        ElectricDevice electricDeviceOne = new ElectricDevice("DeviceOne", 100, 2, 5, 22);
        ElectricDevice electricDeviceTwo = new ElectricDevice("DeviceTwo", 100, 2, 5, 22);
        user.insertElectricDevice(electricDeviceOne);
        user.insertElectricDevice(electricDeviceTwo);
        assertEquals(user.getElectricDevices().get(0), electricDeviceOne);
        assertTrue(user.getElectricDevices().get(0).getPowerConsumption() == 100);
        assertTrue(user.getElectricDevices().get(0).getHoursPerDay() == 2);
        assertEquals(user.getElectricDevices().get(1), electricDeviceTwo);

        ElectricDevice electricDeviceOneRenewed = new ElectricDevice("DeviceOne", 500, 5, 0, 0);
        user.insertElectricDevice(electricDeviceOneRenewed);
        assertTrue(user.getElectricDevices().get(0).getHoursPerDay() == 5);
        assertTrue(user.getElectricDevices().get(0).getPowerConsumption() == 500);
    }

    public void testInsertWaterActivity() {
        User user = User.getInstance();
        WaterActivity waterActivityOne = new WaterActivity("ActivityOne", 10, 10);
        WaterActivity waterActivityTwo = new WaterActivity("ActivityTwo", 5, 5);
        user.insertWaterActivity(waterActivityOne);
        user.insertWaterActivity(waterActivityTwo);
        assertEquals(user.getWaterActivities().get(0), waterActivityOne);
        assertTrue(user.getWaterActivities().get(0).getLitersUsed() == 10);
        assertTrue(user.getWaterActivities().get(0).getTimesPerDay() == 10);
        assertEquals(user.getWaterActivities().get(1), waterActivityTwo);

        WaterActivity waterActivityOneRenewed = new WaterActivity("ActivityOne", 20, 15);
        user.insertWaterActivity(waterActivityOneRenewed);
        assertTrue(user.getWaterActivities().get(0).getLitersUsed() == 20);
        assertTrue(user.getWaterActivities().get(0).getTimesPerDay() == 15);
    }

    public void testInsertRefuseProduction() {
        User user = User.getInstance();
        RefuseProduction refuseProductionOne = new RefuseProduction("ProductionOne", 10);
        RefuseProduction refuseProductionTwo = new RefuseProduction("ProductionTwo", 20);
        user.insertRefuseProduction(refuseProductionOne);
        user.insertRefuseProduction(refuseProductionTwo);
        assertEquals(user.getRefuseProductions().get(0), refuseProductionOne);
        assertTrue(user.getRefuseProductions().get(0).getPointValue() == 10);
        assertEquals(user.getRefuseProductions().get(1), refuseProductionTwo);

        RefuseProduction refuseProductionOneRenewed = new RefuseProduction("ProductionOne", 15);
        user.insertRefuseProduction(refuseProductionOneRenewed);
        assertTrue(user.getRefuseProductions().get(0).getPointValue() == 15);
    }

    public void testReset() {
        User user = User.getInstance();
        this.prepareUser(user);
        assertFalse(user.getElectricDevices().isEmpty());
        assertFalse(user.getWaterActivities().isEmpty());
        assertFalse(user.getRefuseProductions().isEmpty());

        user.reset();
        assertTrue(user.getElectricDevices().isEmpty());
        assertTrue(user.getWaterActivities().isEmpty());
        assertTrue(user.getRefuseProductions().isEmpty());
    }

    public void testUserStatsModification() {
        User user = User.getInstance();
        user.getUserStats().setPowerUsage(10);
        user.getUserStats().setRefuseProductionPoints(20);
        user.getUserStats().setStandbyPowerUsage(30);
        user.getUserStats().setWaterUsage(40);
        assertTrue(user.getUserStats().getPowerUsage() == 10);
        assertTrue(user.getUserStats().getRefuseProductionPoints() == 20);
        assertTrue(user.getUserStats().getStandbyPowerUsage() == 30);
        assertTrue(user.getUserStats().getWaterUsage() == 40);

        user.getUserStats().setPowerUsage(4);
        user.getUserStats().setRefuseProductionPoints(3);
        user.getUserStats().setStandbyPowerUsage(2);
        user.getUserStats().setWaterUsage(1);
        assertTrue(user.getUserStats().getPowerUsage() == 4);
        assertTrue(user.getUserStats().getRefuseProductionPoints() == 3);
        assertTrue(user.getUserStats().getStandbyPowerUsage() == 2);
        assertTrue(user.getUserStats().getWaterUsage() == 1);
    }

    public void testRemoveElectricDevice() {
        User user =  User.getInstance();
        this.prepareUser(user);
        int numberOfElectricDevices = user.getElectricDevices().size();
        String deviceToRemoveName = user.getElectricDevices().get(0).getName();
        String deviceToStayName = user.getElectricDevices().get(1).getName();
        ElectricDevice electricDeviceOne = new ElectricDevice(deviceToRemoveName);
        user.removeElectricDevice(electricDeviceOne);
        assertTrue(user.getElectricDevices().size() == numberOfElectricDevices - 1);
        assertFalse(user.getElectricDevices().get(0).getName().equals(deviceToRemoveName));
        assertTrue(user.getElectricDevices().get(0).getName().equals(deviceToStayName));
    }

    public void testRemoveWaterActivity() {
        User user = User.getInstance();
        this.prepareUser(user);
        int numberOfWaterActivities = user.getWaterActivities().size();
        String activityToRemoveName = user.getWaterActivities().get(0).getName();
        String activityToStayName = user.getWaterActivities().get(1).getName();
        WaterActivity waterActivityOne = new WaterActivity(activityToRemoveName);
        user.removeWaterActivity(waterActivityOne);
        assertTrue(user.getWaterActivities().size() == numberOfWaterActivities - 1);
        assertFalse(user.getWaterActivities().get(0).getName().equals(activityToRemoveName));
        assertTrue(user.getWaterActivities().get(0).getName().equals(activityToStayName));
    }

    public void testRemoveRefuseProduction() {
        User user = User.getInstance();
        this.prepareUser(user);
        int numberOfRefuseProductions = user.getRefuseProductions().size();
        String productionToRemoveName = user.getRefuseProductions().get(0).getName();
        String productionToStayName = user.getRefuseProductions().get(1).getName();
        RefuseProduction refuseProductionOne = new RefuseProduction(productionToRemoveName);
        user.removeRefuseProduction(refuseProductionOne);
        assertTrue(user.getRefuseProductions().size() == numberOfRefuseProductions - 1);
        assertFalse(user.getRefuseProductions().get(0).getName().equals(productionToRemoveName));
        assertTrue(user.getRefuseProductions().get(0).getName().equals(productionToStayName));
    }

    private void prepareUser(User user) {
        ElectricDevice electricDeviceOne = new ElectricDevice("DeviceOne", 100, 2, 5, 22);
        ElectricDevice electricDeviceTwo = new ElectricDevice("DeviceTwo", 100, 2, 5, 22);
        user.insertElectricDevice(electricDeviceOne);
        user.insertElectricDevice(electricDeviceTwo);
        WaterActivity waterActivityOne = new WaterActivity("ActivityOne", 10, 10);
        WaterActivity waterActivityTwo = new WaterActivity("ActivityTwo", 5, 5);
        user.insertWaterActivity(waterActivityOne);
        user.insertWaterActivity(waterActivityTwo);
        RefuseProduction refuseProductionOne = new RefuseProduction("ProductionOne", 10);
        RefuseProduction refuseProductionTwo = new RefuseProduction("ProductionTwo", 20);
        user.insertRefuseProduction(refuseProductionOne);
        user.insertRefuseProduction(refuseProductionTwo);
    }
}
