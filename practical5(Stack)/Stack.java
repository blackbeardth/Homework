class Stack {
	private int tos;
	final private int size;
	private int[] arr;

	Stack(int size) {
		this.tos = -1;
		this.size = size;
		arr = new int[size];
	}

	void push(int num) throws StackException {
		if (this.tos == size - 1)
			throw new StackException("Stack OverFlow: " + num + " can not pe pushed.");
		else
			this.arr[++tos] = num;
	}

	int pop() throws StackException {
		if (this.tos < 0)
			throw new StackException("Stack UnderFlow: Stack is empty.");
		else
			return this.arr[tos--];
	}

	int getTOS() {
		return this.tos;
	}
}