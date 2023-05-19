package restAssured.PojoClasses.copy;

public class GetCourse {
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private Course courses;
	private String linkedIn;

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getServices() {
		return services;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setCourses(Course courses) {
		this.courses = courses;
	}

	public Course getCourses() {
		return courses;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getLinkedIn() {
		return linkedIn;
	}
}
