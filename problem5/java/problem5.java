public class Problem5 {
	public static Integer smallestMultiple() {
		for (int i = 1; i < 1000000000; i++) {
			for (int j = 1; j < 21; j++) {
				if (i % j == 0) {
					if (j == 20) {
						return i;
					} else {
						continue;
					}
				} else {
					break;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Integer result = smallestMultiple(); 
		System.out.println(result);
	}
}
