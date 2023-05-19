package restAssured.PojoClasses.copy;

import java.util.ArrayList;
import java.util.List;

public class TestData {
	public static AddPlace addPlace(double lat, double lng, int accuracy, String name, String phone_number, String address,
			String types1, String types2, String website,String language) {

		
		AddPlace a = new AddPlace();
		Locations l = new Locations();
		l.setLat(lat);
		l.setLng(lng);

		a.setLocation(l);
		a.setAccuracy(accuracy);
		a.setName(name);
		a.setPhone_number(phone_number);
		a.setAddress(address);
		ArrayList<String> listTpes = new ArrayList<String>();
		listTpes.add(types1);
		listTpes.add(types2);

		a.setTypes(listTpes);
		a.setWebsite(website);
		a.setLanguage(language);
		return a;
	}
}
