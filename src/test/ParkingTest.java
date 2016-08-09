package test;

import static org.junit.Assert.*;
import org.junit.Test;
import parking.Parking;

public class ParkingTest {
	@Test
	public void TestisParkingCreated() throws Exception {

		Parking createParkingTester = new Parking();
		assertEquals(false, createParkingTester.isParkingLotCreated());
		createParkingTester.createParkingLot(6);
		assertEquals(true, createParkingTester.isParkingLotCreated());
	}

}