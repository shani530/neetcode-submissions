class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars  =(str.toCharArray());
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(str);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr , list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        
        ans.addAll(map.values());
        return ans;
        
    }
}
