package restAssured.DivingDepthAutomationsAPIs;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import restAssured.Files.Payloads;

public class sumCoursePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js=new JsonPath(Payloads.coursePrice1());
		
		//1. Print No of courses returned by API
		int size=js.get("courses.size()");
		System.out.println(size);
		
		//2.Print Purchase Amount
		int purchaseAmount = js.get("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
	
		//3. Print Title of the first course
		String titles = js.get("courses[0].title");
		System.out.println(titles);
		
		
	
		//4. Print All course titles and their respective Prices
		for(int i=0;i<size;i++) {
			String courseTitle=js.get("courses["+i+"].title");
			int coursePrice=js.get("courses["+i+"].price");
			System.out.println(courseTitle+" : "+coursePrice);
		}
		//5. Print no of copies sold by RPA Course
		int sum=0;
		for(int i=0;i<size;i++) {
			String courseTitle=js.get("courses["+i+"].title");
			if(courseTitle.equals("RPA")) {
				int price=js.get("courses["+i+"].price");
				int copies=js.get("courses["+i+"].copies");
				sum+=price*copies;
			}
			
		}
		System.out.println(sum);
		
		//6. Verify if Sum of all Course prices matches with purchase Amount
		int totalSum = 0;
		for(int i=0;i<size;i++) {
			
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].copies");
			totalSum+=price*copies;
		}
		System.out.println(totalSum);
		Assert.assertEquals(totalSum, purchaseAmount);

	}

}
