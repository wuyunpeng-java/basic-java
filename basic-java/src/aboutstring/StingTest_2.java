package aboutstring;

public class StingTest_2 {

	public static void main(String[] args) {
		String str = "aanbaernbat3nbakkldnbaalnbadnball ";
		String key = "nba";
		int count = getKeyStringCount(str, key);
		System.out.print("count=" + count);
	}

	public static int getKeyStringCount(String str, String key) {
		int count = 0;
		int index = 0;
		while ((index = str.indexOf(key)) != -1) {
			str = str.substring(index + key.length());
			count++;
		}
		return count;

	}
}
