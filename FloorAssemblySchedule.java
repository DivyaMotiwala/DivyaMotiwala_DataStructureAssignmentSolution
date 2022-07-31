package problemstatement1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 * @author - Divya Motiwala
 * This program uses Stack to store elements in descending order
 * Compares input array with the top of the stack to decide the assembly sequence
 */
public class FloorAssemblySchedule {

	//Stack to store input in descending order
	Stack<Integer> stack;
	
	//To store input by user
	int[] dayWiseFloorSizeInput;

	
	public FloorAssemblySchedule() {
		stack = new Stack<Integer>();
	}

	public static void main(String[] args) 
	{
		FloorAssemblySchedule driverObject = new FloorAssemblySchedule();
		driverObject.acceptUserInput();
		driverObject.findOrderOfConstruction();
	}

	private void acceptUserInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of floors in the building : ");
		int numFloors = sc.nextInt();
		dayWiseFloorSizeInput = new int[numFloors];

		for (int i = 0; i < numFloors; i++) {
			System.out.printf("Enter the floor size given on Day %d : \n", (i + 1));
			dayWiseFloorSizeInput[i] = sc.nextInt();
		}

		//Sort Data by cloning input array and storing in stack
		sortInput();
		
		sc.close();
	}

	private void sortInput() {

		int[] copyArray = dayWiseFloorSizeInput.clone();
		Arrays.sort(copyArray);

		pushIntoStack(copyArray);

	}

	private void pushIntoStack(int[] inputArray) {

		// Descending order

		for (int data : inputArray)
			stack.push(data);

	}
	
	//Method to decide assembly of floors
	private void findOrderOfConstruction()
	{
		System.out.println("The order of construction is as follows : ");
		
		for(int i=0; i<dayWiseFloorSizeInput.length ;i++)
		{
			System.out.printf("Day %d\n", (i+1));
			
			//Checking if largest floor size arrived
			if(dayWiseFloorSizeInput[i] == stack.peek())
			{
				System.out.print(stack.pop() + "\t");
				int j=i-1;
				
				//Assemble all the eligible floor sizes which have arrived
				while(j >=0 && !stack.isEmpty())
				{
					if(dayWiseFloorSizeInput[j] == stack.peek())
						System.out.print(stack.pop() + "\t");
					j--;
				}
				
			}
			System.out.println();
		}
	}

}
