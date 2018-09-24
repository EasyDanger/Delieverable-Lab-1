package lab1;

import java.util.InputMismatchException; //Allows program to handle if user input is not an integer.
import java.util.NoSuchElementException;
import java.util.Scanner; //Allows program to scan for user input.

//Program will take user input in the form of 2 integers of the same number of digits, and compare those numbers by checking that the sums of the digits between the two numbers is equivalent by decimal place. The digits in each place (billion's place, hundred million's place, etc.) must sum to the same as the digits in every other place, or the program will print the false/failure statement. Otherwise, the true/success statement will be displayed.

//Try inputing any integer (or non-integer) combination, including negative numbers or letters. Program SHOULD only allow valid integer inputs of the same length. An easter egg exists under ONE specific condition.

public class Lab1_1 {
	// All variables declared here, before the main method, should be used in
	// multiple methods. While it's possible a stray generalization was made, we
	// tended to move variables up here as they became needed in more than one
	// method.

	// Length variables to compare the two numbers to ensure same length. Also
	// function to help control flow within program. Once the integers have been
	// excepted, these variables are assigned an equal value and are used
	// interchangeably.
	static int length1;
	static int length2;

	// Variables to store first number and its individual digits. And integer can only accept up to 10 digits, so program maxes at ten possible digits.
	static int firstNum;
	static int firDigit;
	static int secDigit;
	static int thiDigit;
	static int fouDigit;
	static int fivDigit;
	static int sixDigit;
	static int sevDigit;
	static int eigDigit;
	static int ninDigit;
	static int tenDigit;

	// Variables to store second number and its individual digits.
	static int secNum;
	static int firDigit2;
	static int secDigit2;
	static int thiDigit2;
	static int fouDigit2;
	static int fivDigit2;
	static int sixDigit2;
	static int sevDigit2;
	static int eigDigit2;
	static int ninDigit2;
	static int tenDigit2;

	// Variables to aid with math while separating digits. Placeholder variables for
	// equations. It is possible the math is possible without so many variables
	// here, but this made the math clearer and more obvious in the moment of
	// coding.
	static int place10;
	static int place9;
	static int place8;
	static int place7;
	static int place6;
	static int place5;
	static int place4;
	static int place3;
	static int place2;
	static int place1;
	static int place9b;
	static int place8b;
	static int place7b;
	static int place6b;
	static int place5b;
	static int place4b;
	static int place3b;
	static int place2b;
	static int place1b;
	static Scanner read = new Scanner(System.in); // Calling the scanner to allow user input.
	public static void main(String[] args) {
		letsGo(); // Originally, beginning of program was placed in a separate method because we
					// were often calling back to the "letsGo()" method in order to loop in the way
					// that the try/catch and do/while loops are currently. Now, moving program
					// start into the "main(String[] args)" method breaks program. Must investigate
					// further.
	}

	public static void letsGo() {
//Flavor text and user explanations/prompts Could have used a single "println" command with (\n) line breaks, but the code looks neater this way, personally. Or, at least it did originally.
		System.out.println(
				"Hi! Today, we're going to compare some integers that you're going to enter. Sounds like fun, right?");
		System.out.println(
				"We promise you this is for your benefit, and not at all just to prove to myself and others that I'm capable of learning to code.");
		System.out.println(
				"We're going to see if two integers you enter have digits in all of the corresponding places that sum to the same number. See? I told you it was fun!?");
		System.out.println("So let's get started with your first integer. Please enter it now:");

		do { // Do loop is used to allow the process to repeat in case user enters integers
				// that are not the same length or characters that are not integers.


			try { // Try/catch statement allows program to not fall apart if user enters a too-big
					// number or non-integer.

				firstNum = read.nextInt(); // Accepts first integer.
				firstNum = Math.abs(firstNum); // Converts any pesky negative numbers trolls might try to enter.

//Following requests and accepts second integer.		
				System.out.println("Fantastic looks like you put in " + firstNum
						+ ".\n Now, how about that second number, huh? Please enter that, now. But remember, it needs to have the same number of digits as the first number you put in:");

				secNum = read.nextInt(); // Accepts second integer.
				secNum = Math.abs(secNum); // Converts like for the first digit.

//Determines number of digits for the two integers and stores those numbers for comparisons and flow control later.			
				length1 = (int) (Math.log10(firstNum) + 1);
				length2 = (int) (Math.log10(secNum) + 1);

//Checks to see if the integers have the same number of digits.	If/else statement only gives feedback to user, no longer loops the way previous version did. This potential loop is now handled exclusively by the while statement.
				if (length1 != length2) {
					System.out.println(
							"Sorry, we're going to need you to enter two integers that have the SAME number of digits. Let's try that again starting with the first integer:");
				}

				else {
					System.out.println("Okay, awesome. Looks like you put in " + secNum
							+ " this time. Now we're gonna do some math stuff to see if those digit-sums match!");
				}

			}

//Catch statement allows program to not fall apart if unusable input is entered. Originally, program would loop back from this catch statement upon invalid input by calling back to the letsGo() method, but this caused a bug. Looping is entirely handled now by while statement. Catch now simply ensures condition that allows while to loop by making length1 and 2 not equivalent. Must investigate further. 
			catch (InputMismatchException firstNum) {
				length1 = 6;
				length2 = 5;
				System.out.println(
						"That's not gonna work this time, friendo. We need you to put in integers only. Let's leave out the too-big numbers, the letters, and whatnot, please. \n \nNow, let's try that again, with the first integer.");
			}System.out.println(length1 + "" + length2);


		}
		// While statement will loop the do statement until program receives two
		// integers of the same number of digits. Perhaps the most important line of
		// code in the program.
		while (length1 != length2);
		
//This switch handles separating the first integer by its digits. "break" statements deliberately omitted to keep from having to repeat code for larger digits. Program handles up to 10 digits as this is the longest representation of an integer Java can handle.		
		switch (length1) {
		case 10:
			place10 = firstNum % 1000000000;
			place10 = firstNum - place10;
			tenDigit = place10 / 1000000000;
		case 9:
			place9 = firstNum - place10;
			place9b = place9 % 100000000;
			place9 = place9 - place9b;
			ninDigit = (place9 / 100000000);
		case 8:
			place8 = (firstNum - place10) - place9;
			place8b = place8 % 10000000;
			place8 = place8 - place8b;
			eigDigit = (place8 / 10000000);
		case 7:
			place7 = ((firstNum - place10) - place9) - place8;
			place7b = place7 % 1000000;
			place7 = place7 - place7b;
			sevDigit = (place7 / 1000000);
		case 6:
			place6 = (((firstNum - place10) - place9) - place8) - place7;
			place6b = place6 % 100000;
			place6 = place6 - place6b;
			sixDigit = (place6 / 100000);
		case 5:
			place5 = ((((firstNum - place10) - place9) - place8) - place7) - place6;
			place5b = place5 % 10000;
			place5 = place5 - place5b;
			fivDigit = (place5 / 10000);
		case 4:
			place4 = (((((firstNum - place10) - place9) - place8) - place7) - place6) - place5;
			place4b = place4 % 1000;
			place4 = place4 - place4b;
			fouDigit = (place4 / 1000);
		case 3:
			place3 = ((((((firstNum - place10) - place9) - place8) - place7) - place6) - place5) - place4;
			place3b = place3 % 100;
			place3 = place3 - place3b;
			thiDigit = (place3 / 100);
		case 2:
			place2 = (((((((firstNum - place10) - place9) - place8) - place7) - place6) - place5) - place4) - place3;
			place2b = place2 % 10;
			place2 = place2 - place2b;
			secDigit = (place2 / 10);
		case 1:
			place1 = ((((((((firstNum - place10) - place9) - place8) - place7) - place6) - place5) - place4) - place3)
					- place2;
			place1b = place1 % 1;
			place1 = place1 - place1b;
			firDigit = (place1 / 1);
			break;
		default:
			break;
		}

//Switch repeats above process for second integer		
		switch (length2) {
		case 10:
			place10 = secNum % 1000000000;
			place10 = secNum - place10;
			tenDigit2 = place10 / 1000000000;
		case 9:
			place9 = secNum - place10;
			place9b = place9 % 100000000;
			place9 = place9 - place9b;
			ninDigit2 = (place9 / 100000000);
		case 8:
			place8 = (secNum - place10) - place9;
			place8b = place8 % 10000000;
			place8 = place8 - place8b;
			eigDigit2 = (place8 / 10000000);
		case 7:
			place7 = ((secNum - place10) - place9) - place8;
			place7b = place7 % 1000000;
			place7 = place7 - place7b;
			sevDigit2 = (place7 / 1000000);
		case 6:
			place6 = (((secNum - place10) - place9) - place8) - place7;
			place6b = place6 % 100000;
			place6 = place6 - place6b;
			sixDigit2 = (place6 / 100000);
		case 5:
			place5 = ((((secNum - place10) - place9) - place8) - place7) - place6;
			place5b = place5 % 10000;
			place5 = place5 - place5b;
			fivDigit2 = (place5 / 10000);
		case 4:
			place4 = (((((secNum - place10) - place9) - place8) - place7) - place6) - place5;
			place4b = place4 % 1000;
			place4 = place4 - place4b;
			fouDigit2 = (place4 / 1000);
		case 3:
			place3 = ((((((secNum - place10) - place9) - place8) - place7) - place6) - place5) - place4;
			place3b = place3 % 100;
			place3 = place3 - place3b;
			thiDigit2 = (place3 / 100);
		case 2:
			place2 = (((((((secNum - place10) - place9) - place8) - place7) - place6) - place5) - place4) - place3;
			place2b = place2 % 10;
			place2 = place2 - place2b;
			secDigit2 = (place2 / 10);
//Some things could be omitted for the last case, but was left in for consistency's sake.
		case 1:
			place1 = ((((((((secNum - place10) - place9) - place8) - place7) - place6) - place5) - place4) - place3)
					- place2;
			place1b = place1 % 1;
			place1 = place1 - place1b;
			firDigit2 = (place1 / 1);
			break;
		default:
			break;
		}

//Calls forth the actual comparison method.		
		comparisons();
	}

//Following method handles actual logic of assignment. 
	public static void comparisons() {

//Variables to store sums of digits for comparison and the math to actually acquire the sums program will compare.
		int sumFirDigit = firDigit + firDigit2;
		int sumSecDigit = secDigit + secDigit2;
		int sumThiDigit = thiDigit + thiDigit2;
		int sumFouDigit = fouDigit + fouDigit2;
		int sumFivDigit = fivDigit + fivDigit2;
		int sumSixDigit = sixDigit + sixDigit2;
		int sumSevDigit = sevDigit + sevDigit2;
		int sumEigDigit = eigDigit + eigDigit2;
		int sumNinDigit = ninDigit + ninDigit2;
		int sumTenDigit = tenDigit + tenDigit2;

//For fun, but also to make the final product slightly more visually pleasing.		
		System.out.println("\n \n What for it ... \n \n ");

//Switch statement determines whether the digit sums match. With fewer digits, the higher digits are ignored. The more digits, the more it depends on cumulative math, hence, again, breaks occur only in the case of failure, in which case the failure() method is called. I think this may render the breaks in the else statements redundant. Must investigate further. 
		switch (length2) {
		case 10:
			if (sumNinDigit == sumTenDigit) {
			} else {
				failure();
				break;
			}
		case 9:
			if (sumEigDigit == sumNinDigit) {
			} else {
				failure();
				break;
			}
		case 8:
			if (sumSevDigit == sumEigDigit) {
			} else {
				failure();
				break;
			}
		case 7:
			if (sumSixDigit == sumSevDigit) {
			} else {
				failure();
				break;
			}
		case 6:
			if (sumFivDigit == sumSixDigit) {
			} else {
				failure();
				break;
			}
		case 5:
			if (sumFouDigit == sumFivDigit) {
			} else {
				failure();
				break;
			}
		case 4:
			if (sumThiDigit == sumFouDigit) {
			} else {
				failure();
				break;
			}
		case 3:
			if (sumSecDigit == sumThiDigit) {
			}

			else {
				failure();
				break;
			}
		case 2:
			if (sumFirDigit == sumSecDigit) {
				success();
			} else {
				failure();
			}
			break;
		case 1:
			onlyOne();
		default:
			break;
		}
	}

	public static void failure() {// Called in the event that the digit sums are not equivalent.
		System.out.println("Sorry, pal, that's gonna be a FALSE. Those digit-sums are not equivalent.");
	}

	public static void success() {// Called in the event that the digit-sums ARE equivalent.
		System.out.println("Looks like a TRUE, good buddy! Those digit-sums are all the same!");
	}

	public static void onlyOne() {// You tried to give me single digits and undermine the entire program.
		System.out.println(
				"There's only one digit here. I mean, what do you expect to be here? We've technically done all of the same math, but you can't really compare the sums of a pair of digits when you've only got one pair to sum, now, can you? Do you think you're clever? Whose time are you trying to waste, ours or your own? What was even the point of this, if you're just going to try to be cute and input one digit numbers? Do you have any idea how much math is involved here, just for you to be cheeky? How many lines of code went into your little troll here? You know, what, don't even start over. The program is ending now. You don't get to calculate the sums of the digits of numbers anymore. Just go home, and leave us all in peace, will you? Jeez.");
	}
}
