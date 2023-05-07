class ExceptionDemo {
	public void test(int age) throws UnderAge {
		if (age < 18)
			throw new UnderAge(age);
		System.out.println("You are of age.");
	}
}