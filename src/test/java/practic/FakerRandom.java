package practic;

import java.util.Random;

import com.github.javafaker.Faker;

public class FakerRandom {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Faker faker = new Faker();
		Random random = new Random();
		int number = random.nextInt(10);
		System.out.println(number);

	}

}
