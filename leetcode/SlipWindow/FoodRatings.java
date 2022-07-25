import java.util.HashMap;
import java.util.Map;

class FoodRatings {
    private Map<String, String> reMap = new HashMap<>();
    private Map<String, Map<String, Integer>> foodMap = new HashMap<>();
    private Map<String, String> maxFoods = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++) {
                reMap.put(foods[i], cuisines);
                Map<String, Integer> map = new HashMap<>();
                map.put(foods[i], ratings[i]);
            if(foodMap.containKey(cuisines[i])) {
                foodMap.get(cuisines[i]).add(map);
//                 和最大的比
                String maxF = maxFoods.get(cuisines[i]);
                int maxR = foodMap.get(cuisines[i]).get(maxF);
                if(maxR > ratings[i] || maxR == ratings[i] && maxF.compareTo(foods[i]) > 0) {
                    maxFoods.put(cuisines[i], foods[i]);
                }
                
            } else {
                foodMap.put(cuisines[i], map);
                maxFoods.put(cuisines[i], foods[i]);
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        Map<String, Integer> map = new HashMap<>();
        map.put(food, newRating);
        String kind = reMap.get(food);
        foodMap.get(kind).put(food, newRating);
        
    }
    
    public String highestRated(String cuisine) {
        return maxFoods.get(cuisine);
    }
}
