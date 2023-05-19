package DepthAndDynamicJsonAPIs;

import org.testng.Assert;

import Payload.JsonPayloads;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		JsonPath js=new JsonPath(JsonPayloads.courses());
		int purchaseAmount = js.get("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		int size=js.get("courses.size()");
		System.out.println(js.get("courses.size()"));
		System.out.println(js.get("courses[0].title"));
		
		for(int i=0;i<size;i++) {
			String course = js.get("courses["+i+"].title");
			int price = js.get("courses["+i+"].price");
			System.out.println(course+":"+price);
		}
//Print no of copies sold by RPA Course
		System.out.println("Print no of copies sold by RPA Course");
		for(int i=0;i<size;i++) {
			String course = js.get("courses["+i+"].title");
			if(course.contains("RPA")) {
				int price = js.get("courses["+i+"].price");
				System.out.println("Print no of copies sold by RPA Course"+":"+price);
				break;
			}
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
				System.out.println("Print no of copies sold by RPA Course");
				int sum = 0;
				for(int i=0;i<size;i++) {
					int price = js.get("courses["+i+"].price");
					int copies = js.get("courses["+i+"].copies");
					 sum+= price*copies;
				}
				System.out.println("Sum of all Course prices: "+sum);
				
				Assert.assertEquals(sum, purchaseAmount);
	}

}
