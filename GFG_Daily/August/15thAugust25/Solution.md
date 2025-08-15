

# Solution Explanation

## Intuition
To maintain the list of intervals **sorted and non-overlapping** we traverse it once, adding intervals that come **before** the new one, **merging** those that overlap, and finally appending the rest. This single left-to-right pass keeps the result ordered while handling all overlaps in place.

## Approach
1. **Add intervals before the new interval** – while `end_i < newStart` push `intervals[i]` into the answer.
2. **Merge overlapping intervals** – while `start_i ≤ newEnd` update the merging window:
   • `start = min(start, start_i)`
   • `end   = max(end, end_i)`
3. **Insert the merged interval** `[start, end]` into the answer.
4. **Append the remaining intervals** (those starting after `end`).

## Complexity
- **Time Complexity:** `O(n)` – each interval is processed once.
- **Space Complexity:** `O(n)` – output list; no extra auxiliary space.

## Summary
A single linear scan suffices: copy the left part, merge the middle part with the new interval, then copy the right part. This guarantees an ordered, overlap-free list in optimal time.
```java
class Solution {

    static ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer,Integer[] > map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        helper(root,map,0,0);

        for(Integer[] val: map.values()){
            ans.add(val[1]);
        }

        return ans;

    }

    public static void helper(Node root,TreeMap<Integer,Integer[]> map, int col,int row){
        if(root==null){return;}

        map.putIfAbsent(col,new Integer[]{row,root.data});
        if(map.get(col)[0]>row){
            map.remove(col);
            map.put(col,new Integer[]{row,root.data});
        }

        helper(root.left,map,col-1,row+1);
        helper(root.right,map,col+1,row+1);
    }
}

```

