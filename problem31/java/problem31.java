public class Coin {

	public static int count_change(int amount) {
		return cc(amount, 8);
	}

	public static int cc(int amount, int kinds_of_coins) {
		if (amount == 0) {
			return 1;
		} else if (amount < 0 || kinds_of_coins == 0) {
			return 0;
		} else {
			return cc(amount, kinds_of_coins - 1)
					+ cc(amount - first_denomination(kinds_of_coins),
							kinds_of_coins);
		}
	}

	private static int first_denomination(int kinds_of_coins) {
		switch (kinds_of_coins) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 5;
		case 4:
			return 10;
		case 5:
			return 20;
		case 6:
			return 50;
		case 7:
			return 100;
		case 8:
			return 200;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		int result = count_change(200);
		System.out.println(result);
	}
}
