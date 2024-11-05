package stepDefinition;

import io.cucumber.java.en.Given;

public class Sample {
	@Given("Print {int}")
	public void print(Integer int1) {
	   System.out.println(int1);
	}
}
