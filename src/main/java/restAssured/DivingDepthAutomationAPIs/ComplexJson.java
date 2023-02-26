package restAssured.DivingDepthAutomationAPIs;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import restAssured.Files.Payloads;

public class ComplexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. Print No of courses returned by API 2. Print Purchase Amount 3. Print
		 * Title of the first course 4. Print All course titles and their respective
		 * Prices 5. Print no of copies sold by RPA Course 6. Verify if Sum of all
		 * Course prices matches with Purchase Amount
		 */
		JsonPath js = new JsonPath(Payloads.coursePrice());
		int puchaseAmount = js.get("dashboard.purchaseAmount");
		System.out.println(puchaseAmount);
		String websiteName = js.get("dashboard.website");
		System.out.println(websiteName);

		int size = js.getInt("courses.size()");
		// 3. Print Title of the first course
		String firstCourse = js.get("courses[0].title");
		System.out.println(firstCourse);
		System.out.println(size);
		// * 4. Print All course titles and their respective Prices
		for (int i = 0; i < size; i++) {
			//
			System.out.println(js.get("courses[" + i + "].title"));
			System.out.println(js.get("courses[" + i + "].price"));
		}
		// Print no of copies sold by RPA Course
		for (int i = 0; i < size; i++) {
			if (js.get("courses[" + i + "].title").equals("RPA")) {
				System.out.println("No of Copies for RPA: " + js.get("courses[" + i + "].copies"));
				break;
			}

		}

		// * 6. Verify if Sum of all Course prices matches with Purchase Amount
		int sum = 0;
		for (int i = 0; i < size; i++) {
			int price = js.get("courses[" + i + "].price");
			int copies = js.get("courses[" + i + "].copies");
			sum += price * copies;

		}
		System.out.println(sum);
		
	}

}
