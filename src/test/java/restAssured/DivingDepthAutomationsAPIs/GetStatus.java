package restAssured.DivingDepthAutomationsAPIs;

import io.restassured.path.json.JsonPath;
import restAssured.Files.Payloads;

public class GetStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
JsonPath js=new JsonPath(Payloads.getStatus());

int arraySize=js.get("size()");
System.out.println(arraySize);
int size=js.get("name.size()");
System.out.println(size);
//System.out.println(js.get("name"));
for(int i=0;i<arraySize;i++) {
	System.out.println(js.get("name["+i+"]"));
	if(js.get("name["+i+"]").equals("fish")) {
		System.out.println(js.get("status["+i+"]"));
	
	}
}
	}

}
