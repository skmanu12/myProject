package restAssured.TestData;

import java.util.ArrayList;
import java.util.List;

import restAssured.PojoClasses.AddPlace;
import restAssured.PojoClasses.Locations;

public class TestBuildData {
public AddPlace addPlace() {
	AddPlace a=new AddPlace();
	Locations l=new Locations();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	a.setLocation(l);
	a.setAccuracy(50);
	a.setName("Frontline house");
	a.setPhone_number("(+91) 983 893 3937");
	a.setAddress("29, side layout, cohen 09");
	List<String> lists=new ArrayList<String>();
	lists.add("shoes park");
	lists.add("shop");
	a.setTypes(lists);
	a.setWebsite("http://google.com");
	a.setLanguage("English");
	return a;
}
}
