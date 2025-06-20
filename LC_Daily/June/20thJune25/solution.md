# Solution Explanation

## Intuition
The problem asks for the maximum Manhattan distance from the origin that can be achieved at any time while performing a sequence of moves, where you are allowed to change at most **k** moves to any direction. The key insight is that the maximum distance is achieved by biasing the moves as much as possible in one direction (e.g., all North and East, or all North and West, etc.), using up to **k** changes to convert moves that oppose your chosen direction.

## Approach
1. **Try All Four Main Directions:**  
   - For each of the four possible "corners" (North-East, North-West, South-East, South-West), simulate the process:
     - For North-East: Change as many 'S' to 'N' and 'W' to 'E' as possible, up to **k** changes.
     - For North-West: Change as many 'S' to 'N' and 'E' to 'W' as possible, up to **k** changes.
     - For South-East: Change as many 'N' to 'S' and 'W' to 'E' as possible, up to **k** changes.
     - For South-West: Change as many 'N' to 'S' and 'E' to 'W' as possible, up to **k** changes.
2. **Simulate Each Path:**  
   - For each direction, after making the changes, simulate the walk and keep track of the Manhattan distance from the origin at each step.
   - Record the maximum Manhattan distance reached during the walk.
3. **Return the Maximum:**  
   - The answer is the maximum value among all four directions.

## Complexity
- **Time Complexity:** O(n), where n is the length of the string (since each simulation is linear and there are only four).
- **Space Complexity:** O(n), for the temporary arrays used in each simulation.

## Summary
**By simulating all four possible "corner" directions and greedily using up to k changes to bias the path, we can efficiently compute the maximum Manhattan distance achievable at any time.**  
This approach is both simple and optimal for the problem constraints.

```java
class Solution {
    private int goNorthEast(int n, String s, int k) {
        char[] arr = s.toCharArray();
        
        for(int i=0;i<n;i++) {
            if(k == 0) break;

            if(arr[i] == 'S') {
                k--;
                arr[i] = 'N';
            } else if(arr[i] == 'W') {
                k--;
                arr[i] = 'E';
            }
        }

        return manhattenDist(arr);
    }

    private int goNorthWest(int n, String s, int k) {
        char[] arr = s.toCharArray();
        
        for(int i=0;i<n;i++) {
            if(k == 0) break;

            if(arr[i] == 'S') {
                k--;
                arr[i] = 'N';
            } else if(arr[i] == 'E') {
                k--;
                arr[i] = 'W';
            }
        }

        return manhattenDist(arr);
    }

    private int goSouthEast(int n, String s, int k) {
        char[] arr = s.toCharArray();
        
        for(int i=0;i<n;i++) {
            if(k == 0) break;

            if(arr[i] == 'N') {
                k--;
                arr[i] = 'S';
            } else if(arr[i] == 'W') {
                k--;
                arr[i] = 'E';
            }
        }

        return manhattenDist(arr);
    }

    private int goSouthWest(int n, String s, int k) {
        char[] arr = s.toCharArray();
        
        for(int i=0;i<n;i++) {
            if(k == 0) break;

            if(arr[i] == 'N') {
                k--;
                arr[i] = 'S';
            } else if(arr[i] == 'E') {
                k--;
                arr[i] = 'W';
            }
        }

        return manhattenDist(arr);
    }

    private int manhattenDist(char[] arr) {
        int horizon = 0;
        int vertical = 0;
        int n = arr.length;
        int max = 0;

        for(int i=0;i<n;i++) {
            if(arr[i] == 'N') vertical++;
            else if(arr[i] == 'S') vertical--;
            else if(arr[i] == 'W') horizon++;
            else horizon--;

            max = Math.max(max, Math.abs(vertical) + Math.abs(horizon));
        }

        return max;
    }

    public int maxDistance(String s, int k) {
        int n = s.length();
        int ne = goNorthEast(n, s, k);
        int nw = goNorthWest(n, s, k);
        int se = goSouthEast(n, s, k);
        int sw = goSouthWest(n, s, k);

        return Math.max(ne, Math.max(nw, Math.max(se, sw)));
    }
}
