import java.util.ArrayList;

public class Sorter {

	public static void sort(ArrayList list) {
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size() - i - 1; j++) {
				CompareMe first = (CompareMe) list.get(j);
				CompareMe second = (CompareMe) list.get(j + 1);
				
				if(first.compareTo(second) < 0) {
					list.add(j + 1, list.remove(j));
				}
			}
		}
	}
}
