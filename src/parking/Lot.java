package parking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lot {
	private static Parking parking = new Parking();

	public static void main(String[] args) {
		String inputString;
		BufferedReader bufferedReader = null;
		String[] inputs;
		boolean exit_app = false;
		try {
			if (args.length > 0) {
				bufferedReader = new BufferedReader(new FileReader(args[0]));
			}
			while (!exit_app) {
				if (args.length == 0) {
					System.out.println("Enter Command ");
					bufferedReader = new BufferedReader(new InputStreamReader(
							System.in));
				}
				inputString = bufferedReader.readLine().trim();
				inputs = inputString.split("\\s+");
				if (!inputs[0].isEmpty()) {
					switch (inputs[0]) {
					case "create_parking_lot": {
						if (!parking.isParkingLotCreated()) {
							if ((inputs.length - 1) == 1) {
								try {
									parking.createParkingLot(Integer
											.parseInt(inputs[1]));
								} catch (NumberFormatException e) {
									System.out
											.println("Inavlid input passed.\n");
									System.out.println(e.getMessage());
									System.out
											.println("maximum Input accepted is : 2147483647.\n");
								}
							} else {
								System.out.println("Invalid input passed.\n");
							}
						} else {
							System.out
									.println("Parking lot already created.\n");
						}

						break;
					}
					case "park": {
						if (parking.isParkingLotCreated()) {
							if ((inputs.length - 1) == 2) {
								parking.park(inputs[1], inputs[2]);
							} else {
								System.out.println("Invalid input passed.\n");
							}
						} else {
							System.out.println("Parking lot is Not Created.\n");
						}
						break;
					}

					case "leave": {
						if (parking.isParkingLotCreated()) {
							if ((inputs.length - 1) == 1) {
								final String REGEX = "\\d+";
								Pattern pattern = Pattern.compile(REGEX);
								Matcher matcher = pattern.matcher(inputs[1]);
								if (matcher.matches()) {
									try {
										parking.leave(Integer
												.parseInt(inputs[1]));
									} catch (NumberFormatException e) {
										System.out
												.println("Inavlid input passed.\n");
										System.out.println(e.getMessage());
										System.out
												.println("maximum Input accepted is : /.\n");
									}
								} else {
									System.out
											.println("Invalid input passed.\n");
								}
							} else {
								System.out.println("Invalid input passed.\n");
							}
						} else {
							System.out.println("Parking lot is Not Created.\n");
						}
						break;
					}

					case "status": {
						if (parking.isParkingLotCreated()) {
							if ((inputs.length - 1) == 0) {
								parking.parkingStatus();
							} else {
								System.out.println("Invalid input passed.\n");
							}

						} else {
							System.out.println("Parking lot is Not Created.\n");
						}
						break;
					}

					case "registration_numbers_for_cars_with_colour": {
						if (parking.isParkingLotCreated()) {
							if ((inputs.length - 1) == 1) {
								parking
										.registrationNosofCarsWithColor(inputs[1]);
							} else {
								System.out.println("Invalid input passed.\n");
							}
						} else {
							System.out.println("Parking lot is Not Created.\n");
						}
						break;
					}

					case "slot_numbers_for_cars_with_colour": {
						if (parking.isParkingLotCreated()) {
							if ((inputs.length - 1) == 1) {
								parking.slotNosOfCarsWithColor(inputs[1]);
							} else {
								System.out.println("Invalid input passed.\n");
							}
						} else {
							System.out.println("Parking lot is Not Created.\n");
						}
						break;
					}

					case "slot_number_for_registration_number": {
						if (parking.isParkingLotCreated()) {
							if ((inputs.length - 1) == 1) {
								parking
										.slotNoBasedOnRegistrationNo(inputs[1]);
							} else {
								System.out.println("Invalid input passed.\n");
							}
						} else {
							System.out.println("Parking lot is Not Created.\n");
						}
						break;
					}

					case "destroy_parking_lot": {
						if (parking.isParkingLotCreated()) {
							parking.destroyParkingLot();
						} else {
							System.out.println("Parking lot is Not Created.\n");
						}
						break;
					}

					case "exit_app": {
						exit_app = true;
						break;
					}
					default: {
						System.out.println("Invalid command Entered.\n");
						break;
					}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("App Terminated");
		}

	}

}
