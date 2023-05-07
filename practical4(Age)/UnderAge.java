class UnderAge extends Exception {
	private int age;

	UnderAge(int age) {
		this.age = age;
	}

	public void showException() {
		System.out.println("UnderAge(" + this.age + ")");
	}
}