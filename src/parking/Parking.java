package parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class Parking {

	private TreeMap<Integer, Car> parkingLot = null;
	private int maxNoofVehicles;
	private boolean isParkingLotCreated = false;
	private List<Integer> vacantSlots = null;
	private List<String> parkedCarRegistrationNoList = null;

	public boolean isParkingLotCreated() {
		return isParkingLotCreated;
	}

	public void createParkingLot(int maxNoofVehicles) {
		try {
			if (maxNoofVehicles > 0) {
				this.maxNoofVehicles = maxNoofVehicles;
				parkingLot = new TreeMap<Integer, Car>();
				vacantSlots = new ArrayList<Integer>();
				parkedCarRegistrationNoList = new ArrayList<String>();
				for (int i = 0; i < maxNoofVehicles; i++) {
					vacantSlots.add(i + 1);
				}
				System.out.println("Created a parking lot with "
						+ maxNoofVehicles + " slots.\n");
				isParkingLotCreated = true;
			} else {
				System.out
						.println("Unable to Create Parking Lot.Enter Postive No for Creating Parking Lot.\n");
			}
		} catch (Exception e) {
			System.out.println("Error creating the parking Lot.\n");
			System.out.println(e.getMessage());
		}
	}

	public void destroyParkingLot() {
		parkingLot = null;
		vacantSlots = null;
		isParkingLotCreated = false;
		parkedCarRegistrationNoList = null;
		System.out.println("Parking lot Destroyed.\n");
	}

	public void park(String registrationNo, String color) {

		if (!parkedCarRegistrationNoList.contains(registrationNo)) {
			if (parkingLot.keySet().size() == maxNoofVehicles) {
				System.out.println("Sorry, parking lot is full.\n");
			} else {
				Car tempCar = new Car(registrationNo, color);
				int parkingSlot = nearestParkingSlot();
				parkingLot.put(parkingSlot, tempCar);
				vacantSlots.remove(vacantSlots.indexOf(parkingSlot));
				parkedCarRegistrationNoList.add(registrationNo);
				System.out.println("Allocated slot number: " + parkingSlot
						+ ".\n");
			}
		} else {
			System.out.println("Car with Registration No. " + registrationNo
					+ " already parked.\n");
		}
	}

	public void leave(int parkingSlotNo) {
		if (parkingLot.containsKey(parkingSlotNo)) {
			String parkedCarregistrationNo = parkingLot.get(parkingSlotNo)
					.getRegNo();
			parkingLot.remove(parkingSlotNo);
			parkedCarRegistrationNoList.remove(parkedCarRegistrationNoList
					.indexOf(parkedCarregistrationNo));
			vacantSlots.add(parkingSlotNo);
			Collections.sort(vacantSlots);
			System.out.println("Slot number " + parkingSlotNo + " is free.\n");
		} else if (parkingSlotNo > maxNoofVehicles) {
			System.out
					.println("Invalid Input.Input beyond Parking lot capacity.\n");
		} else {
			System.out.println("Parking Slot is already vacant.\n");
		}
	}

	public void parkingStatus() {
		Iterator<Integer> iterator = parkingLot.keySet().iterator();
		System.out.println("Slot No.	Registration No.	Colour");
		while (iterator.hasNext()) {
			Integer parkingSlot = iterator.next();
			Car parkedCar = parkingLot.get(parkingSlot);
			System.out.println(parkingSlot.toString() + "		"
					+ parkedCar.getRegNo() + "		" + parkedCar.getColor());
		}
		System.out.println("\n");
	}

	public void registrationNosofCarsWithColor(String color) {
		String queriedRegistrationNo = "";
		Iterator<Integer> iterator = parkingLot.keySet().iterator();
		while (iterator.hasNext()) {
			Integer parkingSlot = iterator.next();
			Car parkedCar = parkingLot.get(parkingSlot);
			if (parkedCar.getColor().equals(color)) {
				queriedRegistrationNo = queriedRegistrationNo
						+ parkedCar.getRegNo().toString() + ",";
			}
		}
		queriedRegistrationNo = queriedRegistrationNo.substring(0,
				queriedRegistrationNo.length() - 1);
		System.out.println(queriedRegistrationNo);

	}

	public void slotNosOfCarsWithColor(String color) {
		String queriedSlotNo = "";
		Iterator<Integer> iterator = parkingLot.keySet().iterator();
		while (iterator.hasNext()) {
			Integer parkingSlot = iterator.next();
			Car parkedCar = parkingLot.get(parkingSlot);
			if (parkedCar.getColor().equals(color)) {
				queriedSlotNo = queriedSlotNo + parkingSlot.toString() + ",";
			}
		}
		queriedSlotNo = queriedSlotNo.substring(0, queriedSlotNo.length() - 1);
		System.out.println(queriedSlotNo);

	}

	public void slotNoBasedOnRegistrationNo(String registrationNo) {
		String queriedSlotNo = "";
		Iterator<Integer> iterator = parkingLot.keySet().iterator();
		while (iterator.hasNext()) {
			Integer parkingSlot = iterator.next();
			Car parkedCar = parkingLot.get(parkingSlot);
			if (parkedCar.getRegNo().equals(registrationNo)) {
				queriedSlotNo = parkingSlot.toString();
			}
		}
		System.out.println(queriedSlotNo);

	}

	private int nearestParkingSlot() {
		return vacantSlots.get(0);
	}

}
