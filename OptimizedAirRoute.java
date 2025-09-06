import java.util.ArrayList;
import java.util.List;

// This solution adds the smallest array into a tree map which maintains list based on descending order. We then iterate over through each element from the largest array and iterate over the map to get the max optimized route.
// At any point if we find better route we update it.
public class AirRouteOptimizer {

    
    private static List<List<Integer>> getOptimizedRoute(int[][] arr1, int[][] arr2, int target) {
        if(arr1.length>arr2.length) return getOptimizedRoute(arr2, arr1, target);
        List<List<Integer>> optimizedRoute = new ArrayList<>();
        int maxOptimizedValue = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for(int i=0;i<arr1.length;i++) {
            map.put(arr1[i][1], arr1[i][0]);
        }
        for (int i=0;i<arr2.length;i++) {
            int[] temp = arr2[i];
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey()+temp[1]>target) continue;
                else if(entry.getKey()+temp[1]>=maxOptimizedValue) {
                    if(entry.getKey()+temp[1]==maxOptimizedValue) optimizedRoute.clear();
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(temp[0]);
                    tempList.add(entry.getValue());
                    optimizedRoute.add(tempList);
                }
            }
        }
        return optimizedRoute;
    }


    public static void main(String args[])
    {
        int[][] arr1 = { {1, 2000}, {2, 3000}, {3, 4000} };
        int[][] arr2 = { { 1, 5000 }, {2, 3000} };

        List<List<Integer>> optimizedRoute = getOptimizedRoute(arr1, arr2, 7000);
        for(List<Integer> list: optimizedRoute) {
            list.stream().forEach(System.out::println);
            System.out.println();
        }
    }
}
