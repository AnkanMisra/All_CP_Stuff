class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();

        for(String f:folder){
            if(list.isEmpty() || !f.startsWith(list.get(list.size()-1)+"/")){
                list.add(f);
            }
        }
        return list;
    }
}