package questions;

public class Decoder {
	final static int[] message = {82, 96, 103, 103, 27, 95, 106, 105, 96, 28};
	final int key = 5;
	
	public static void main(String[] args){
		for(int i : message){
			i += 5;
			char j = (char) i;
			System.out.print(j);
		}
	}
}
