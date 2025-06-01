class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * arr[i])) {
                map.get(arr[i] * arr[i]).add(i);
            } else {
                map.put(arr[i] * arr[i], new ArrayList<>());
                map.get(arr[i] * arr[i]).add(i);
            }
        }

        for (Map.Entry<Integer, List<Integer>> i : map.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> j : map.entrySet()) {
                int k = i.getKey() + j.getKey();
                if (map.containsKey(k)) {
                    if (i.getKey() == k) {
                        if (i.getValue().size() > 1) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (j.getKey() == k) {
                        if (j.getValue().size() > 1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
