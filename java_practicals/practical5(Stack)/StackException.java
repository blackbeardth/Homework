class StackException extends Exception {
	private String message;

	StackException(String str) {
		this.message = str;
	}

	void showException() {
		System.out.println(this.message);
	}	
}