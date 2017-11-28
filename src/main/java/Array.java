import java.util.ArrayList;

public class Array {
	public static void main(String[] args) {
		
		ArrayList<String> country = new ArrayList<String>();
		country.add("United States");
		country.add("United Kingdom");
		country.add("Uganada");
		country.add("Ukrain");
		country.add("Turkey");
		
		String x = country.get(1);
		System.out.println(x);
	}
}
