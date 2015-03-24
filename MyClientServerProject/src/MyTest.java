import java.io.Serializable;

public class MyTest implements Serializable{
	private String myString = null;

	public MyTest(String myString) {
		super();
		this.myString = myString;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	@Override
	public String toString() {
		return "MyTest [myString=" + myString + "]";
	}

}
