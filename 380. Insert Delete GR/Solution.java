import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;

	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}

	public boolean find(int val) {
		return map.containsKey(val);
	}

	public boolean insert(int val) {

		if ( find(val) ) return false;

		list.add(val);
		map.put(val, list.size() - 1);

		return true;
	}

	public boolean remove(int val) {

		if ( !find(val) ) return false;

		int index = map.get(val);

		//	index: 2
		list.set(index, list.get(list.size() - 1));
		//	0 1 2 3 4 5
		//	4 2 6 5 1

		map.put(list.get(index), index);	//	map(2, 0)
		list.remove(list.size() - 1);
		map.remove(val);

		return true;
	}

	public int getRandom() {
		Random random = new Random();
		return list.get(random.nextInt(list.size()));
	}
}

public class Solution {

	public static void main(String[] args) {

		RandomizedSet obj = new RandomizedSet();
		System.out.println("obj.insert(1) = " + obj.insert(4));
//		System.out.println("obj.remove(2) = " + obj.remove(2));
		System.out.println("obj.insert(2) = " + obj.insert(2));
		System.out.println("obj.insert(3) = " + obj.insert(3));
		System.out.println("obj.insert(5) = " + obj.insert(5));
		System.out.println("obj.insert(1) = " + obj.insert(1));
		System.out.println("obj.insert(6) = " + obj.insert(6));
//		System.out.println("obj.getRandom() = " + obj.getRandom());
		System.out.println("obj.remove(3) = " + obj.remove(3));
		System.out.println("obj.insert(2) = " + obj.insert(3));
//		System.out.println("obj.getRandom() = " + obj.getRandom());
	}
}
