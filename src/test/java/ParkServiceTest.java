import org.junit.Before;
import org.junit.Test;

import main.Entity.Car;
import main.Service.ParkService;

import static org.junit.Assert.assertEquals;

public class ParkServiceTest {

    ParkService parkService;
    Car firstCar;
    Car secondCar;
    Car thirdCar;
    Car fourthCar;

    @Before
    public void setup() {
        parkService = new ParkService();
        firstCar = new Car("ABC");
        secondCar = new Car("ZXY");
        thirdCar = new Car("PLO");
        fourthCar = new Car("A1A");

    }

    @Test
    public void testParkUnparkCompact() {
        parkService.park(secondCar);
        parkService.park(fourthCar);
        parkService.unpark(5001);
        parkService.park(firstCar);
        parkService.park(thirdCar);
        assertEquals(3, parkService.getParkLoad().size());
    }

    @Test
    public void testInstructions() {
        assertEquals("XYZ,TSW", parkService.processInstructions("pABC,pXYZ,pEFG,u5000,c,u5002,pTSW"));
    }
}
