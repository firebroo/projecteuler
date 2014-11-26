import java.util.ArrayList;
import java.util.List;



public class Demo {
	public static void main(String[] args) {
		Trangular trangular = new Trangular();
		System.out.println(trangular.generate());
	}

}

class Trangular{
	public Integer generate() {
		Integer tmp = 0;
		Integer addNumber = 1;
		while (true) {
			tmp += addNumber;
			addNumber++;
			if (div(tmp).toArray().length > 50) {
				return tmp;
			}
		}
	}
	
	public  List<Integer> div(Integer x) {
		List<Integer> list = new ArrayList<Integer>();
		for (Integer i=1;i <= x; i++) {
			if (x % i == 0) {
				list.add(i);
			}
		}
		return list;
	}
}
