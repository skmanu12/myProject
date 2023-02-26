package QA1;

import static QAs.Test1.*;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Access static members of the class using class name
		//import QAs.Test1; package name
//Test1.method2();
//Test1.method3();
////Access static members of the class without using class name with help of 
//static import and make the class as static
//import static QAs.Test1.*; now the class is static, so we can directly access static members of the class
		method2();
		method3();
		//Using class name
		//RestAssured.given();
		
		//Withou using class name and with help of static import
		given();
	}

}
