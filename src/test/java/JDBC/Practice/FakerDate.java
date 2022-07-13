package JDBC.Practice;

import com.github.javafaker.Faker;

/**
 * 
 * @author Raman Jha
 * @description : This method is going to create faker data which is req. for Test Execution.
 *
 */

public class FakerDate 
{
	Faker faker = new Faker();
	/**
	 * @author Raman Jha
	 * @description : This method is going to generate a random name
	 * @return String Random name
	 */
	public String firstName1()
	{
		return faker.name().firstName();
	}
	/**
	 * @author Raman Jha
	 * @description : This method is going to generate a random name for last name
	 * @return String Random last name
	 */
	public String lastNmae()
	{
		return faker.name().lastName();
	}
	/**
	 * @author Raman Jha
	 * @description : This method is generate a random name for company
	 */
	public String company()
	{
		return faker.company().name();
	}
	
	

}









