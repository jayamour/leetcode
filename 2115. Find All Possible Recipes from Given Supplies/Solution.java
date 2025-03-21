import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

		Map<String, List<String>> ingredientMap = new HashMap<>();
		Map<String, Integer> inDegree = new HashMap<>();

		for ( int i = 0; i < recipes.length; i++ ) {
			String recipe = recipes[i];
			List<String> requiredIngredients = ingredients.get(i);

			inDegree.put(recipe, requiredIngredients.size());

			for ( String ingredient : requiredIngredients ) {
				ingredientMap.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
			}
		}

		Queue<String> queue = new LinkedList<>();
		for ( int i = 0; i < supplies.length; i++ ) {
			queue.add(supplies[i]);
		}

		List<String> result = new ArrayList<>();

		while ( !queue.isEmpty() ) {
			String ingredient = queue.poll();

			if ( ingredientMap.containsKey(ingredient) ) {

				List<String> recipesUsingIngredient = ingredientMap.get(ingredient);

				for ( String recipe : recipesUsingIngredient ) {

					inDegree.put(recipe, inDegree.get(recipe) - 1);

					if ( inDegree.get(recipe) == 0 ) {
						result.add(recipe);
						queue.add(recipe);
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		String[] recipes = {"bread", "sandwich", "burger"};

		String[] i1 = {"yeast", "flour"};
		String[] i2 = {"bread", "meat"};
		String[] i3 = {"sandwich", "meat", "bread"};

		List<String> l1 = Arrays.stream(i1).collect(Collectors.toList());
		List<String> l2 = Arrays.stream(i2).collect(Collectors.toList());
		List<String> l3 = Arrays.stream(i3).collect(Collectors.toList());

		List<List<String>> ingredients = new ArrayList<>();
		ingredients.add(l1);
		ingredients.add(l2);
		ingredients.add(l3);

		String[] supplies = {"yeast", "flour", "meat"};

		List<String> result = solution.findAllRecipes(recipes, ingredients, supplies);
		System.out.println(result);
	}
}
