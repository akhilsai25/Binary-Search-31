import java.util.ArrayList;
import java.util.List;

// This solution does a simple nested iteration on both loops and keep track of max optimized route. During the process, if a better path is found it will update the array list
public class AirRouteOptimizer {

    private static List<List<Integer>> getOptimizedRoute(int[][] arr1, int[][] arr2, int target) {
        List<List<Integer>> optimizedRoute = new ArrayList<>();
        int maxOptimizedValue = 0;
        for(int i=0; i<arr1.length; i++) {
            int id1 = arr1[i][0];
            int cost = arr1[i][1];
            for(int j=0; j< arr2.length; j++) {
                int id2 = arr2[j][0];
                int cost2 = arr2[j][1];
                if(cost+cost2>target) continue;
                else if(cost+cost2>=maxOptimizedValue) {
                    maxOptimizedValue=cost2+cost;
                    if(cost+cost2>maxOptimizedValue) optimizedRoute.clear();
                    List<Integer> temp = new ArrayList<>();
                    temp.add(id1);
                    temp.add(id2);
                    optimizedRoute.add(temp);
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
