package people;
import java.util.Scanner;
import java.util.Random;
public class People {
	
	public static void main(String[] args) {
		//Asks the number of solvers
		Scanner scan1 = new Scanner(System.in);
		System.out.println("How many people are in the challenge?");
		int solvers = scan1.nextInt();
		//Checks if its a valid number
		if (solvers < 2 || solvers > 4) {
			System.out.println("Please reload and choose a number between 2 and 4");
		}
		//defines variables to make each person's globals
		double[] solver1Times;
		solver1Times = new double[10];
		double[] solver2Times;
		solver2Times = new double [10];
		double[] solver3Times;
		solver3Times = new double [10];
		double[] solver4Times;
		solver4Times = new double [10];
		String[] events = { "3x3 ", "2x2 ", "4x4 ", "5x5 ", "OH ", "Pyraminx ", "Megaminx ", "Skewb ", "Clock ",
				"Square-1 " };
		//creates 2 loops one cycles between events and the other between people
		for (int i = 0; i < solvers; i++) {
			for (int j = 0; j < 10; j++) {
				//asks for people's globals (repeats 1st and 2nd person for some reason)
				 System.out.println("What is person " + (i + 1) + "'s " + events[j] + "average");
				if (i == 0) {
					solver1Times[j] = new Scanner(System.in).nextDouble();
				} else if (i == 1) {
					solver2Times[j] = new Scanner(System.in).nextDouble();
				} else if (i == 2) {
					solver3Times[j] = new Scanner(System.in).nextDouble();
				} else if (i == 3) {
					solver4Times[j] = new Scanner(System.in).nextDouble();
				 }
				 
			}
		}
		for (int i = 0; i < solver1Times.length; i++) {
		}
		for (int i = 0; i < solver2Times.length; i++) {
		}
		for (int i = 0; i < solver3Times.length; i++) {
		}
		for (int i = 0; i < solver4Times.length; i++) {
		}
		//defines sum variables for each person and the full
		double goalSum = 0;
		double oneNewSum = 0;
		double twoNewSum = 0;
		double threeNewSum = 0;
		double fourNewSum = 0;
		// defines loop until goal time is reached
		while (0 == 0) {
			oneNewSum = 0;
			twoNewSum = 0;
			threeNewSum = 0;
			fourNewSum = 0;
			//sets random assignment for each event
			Random rand = new Random();
			int upperbound = solvers;
			int[] eventAssigned = {rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound)};
			//adds to personal sums
			for (int i = 0; i < 10; i++) {
				if (eventAssigned[i] == 0) {
					oneNewSum += solver1Times[i];
				} else if (eventAssigned[i] == 1) {
					twoNewSum += solver2Times[i];
				} else if (eventAssigned[i] == 2) {
					threeNewSum += solver3Times[i];
				} else if (eventAssigned[i] == 3) {
					fourNewSum += solver4Times[i];
				}
			}
			//defines strings for each person's event list
			String oneEvents = " Person one's events are: ";
			for (int i = 0; i < 10; i++) {
				if (eventAssigned[i] == 0) {
					oneEvents += events[i];
				}
			}
			String twoEvents = ", Person two's events are: ";
			for (int i = 0; i < 10; i++) {
				if (eventAssigned[i] == 1) {
					twoEvents += events[i];
				}
			}
			String threeEvents = ", Person three's events are: ";
			for (int i = 0; i < 10; i++) {
				if (eventAssigned[i] == 2) {
					threeEvents += events[i];
				}
			}
			String fourEvents = ", Person four's events are: ";
			for (int i = 0; i < 10; i++) {
				if (eventAssigned[i] == 3) {
					fourEvents += events[i];
				}
			}
			//creates sums for the time (math.max only works for 2 values)
			double firstSum = Math.max(twoNewSum, oneNewSum);
			double secondSum = Math.max(fourNewSum,  threeNewSum);
			double thirdSum = Math.max(firstSum, secondSum);
			//checks if the new sum is fast then overrides the old one if it is
			if (thirdSum < goalSum || goalSum == 0) {
				goalSum = thirdSum;
				//prints out the events each person has
				if (solvers > 3) {
					System.out.println(goalSum + oneEvents + twoEvents + threeEvents + fourEvents);
				} else if (solvers > 2 ) {
					System.out.println(goalSum + oneEvents + twoEvents + threeEvents);
				} else {
					System.out.println(goalSum + oneEvents + twoEvents);
				}
			}
		}
	}
}
//goalSum > (fullSum/(solvers*solvers)) || goalSum == 0
