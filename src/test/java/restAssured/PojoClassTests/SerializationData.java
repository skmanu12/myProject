package restAssured.PojoClassTests;

import java.util.ArrayList;
import java.util.List;

public class SerializationData {
public AddPlace addPlace() {
	AddPlace a=new AddPlace();
	Location l=new Location();
	l.setLat(-38.32456);
	l.setLng(32.48858);
	a.setLocation(l);
	
	a.setAccuracy("50");
	a.setName("Frontline house");
	a.setPhone_number("9474847477");
	a.setAddress("29, side layout, cohen 09");
	
	List<String> types=new ArrayList<String>();
	types.add("shoe park");
	types.add("shop");
	a.setTypes(types);
	
	a.setWebsite("http://google.com");
	a.setLanguage("French-IN");
	return a;
}
}
