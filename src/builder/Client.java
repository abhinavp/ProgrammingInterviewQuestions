package builder;

public class Client {

	public static void main(String[] args) {
		Person person = new Person.PersonBuilder("sasser", "san jose").age(12).build();
	}
}
