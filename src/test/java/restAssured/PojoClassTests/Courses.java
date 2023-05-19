package restAssured.PojoClassTests;

import java.util.List;

public class Courses {
List<WebAutomation> webAutomation;
List<Api> api;
List<Mobile> mobile;
public void setWebAutomation(List<WebAutomation> webAutomation) {
	this.webAutomation=webAutomation;
}
public List<WebAutomation> getWebAutomation() {
	return webAutomation;
}
public void setApi(List<Api> api) {
	this.api=api;
}
public List<Api> getApi() {
	return api;
}

public void setMobile(List<Mobile> mobile) {
	this.mobile=mobile;
}
public List<Mobile> getMobile() {
	return mobile;
}
}
