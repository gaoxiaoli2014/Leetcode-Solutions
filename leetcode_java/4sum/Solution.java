import java.util.*;
public class Solution {
    public void twosum(int[] nums, int target, Set<List<Integer>> res, int idx1, int idx2){
        HashMap<Integer, Integer> dict= new HashMap<>();
        for(int i = idx2+1; i < nums.length; i++){
            if(dict.get(nums[i]) != null){
                res.add(Arrays.asList(nums[idx1], nums[idx2], nums[dict.get(nums[i])], nums[i]));
            }
            else{
                dict.put(target-nums[i], i);
            }
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resall = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++){
                twosum(nums, target, res, i, j);
            }
        }

        for(List<Integer> i:res){
            resall.add(i);
        }
        return resall;
    }
}


public class Solution {
    
    static class TwoSum {
        int index1;
        int index2;
        
        boolean overlap(TwoSum other){
            if(this == other) return true;
            
            if(index1 == other.index1) return true;
            if(index2 == other.index1) return true;

            if(index1 == other.index2) return true;
            if(index2 == other.index2) return true;
            
            return false;
        }
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> found = new ArrayList<List<Integer>>();
        
        if(num.length < 4) return found;
        
        HashMap<Integer, ArrayList<TwoSum>> cache = new HashMap<Integer, ArrayList<TwoSum>>();
        
        Arrays.sort(num);
        
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                
                int s = num[i] + num[j];
                TwoSum t = new TwoSum();
                
                t.index1 = i;
                t.index2 = j;
                
                ArrayList<TwoSum> l = cache.get(s);
                if(l == null){
                    l = new ArrayList<TwoSum>();
                    cache.put(s, l);
                }
                
                l.add(t);
            }
        }
        
        HashSet<String> block = new HashSet<String>();
        
        for(Integer a : cache.keySet()){
            Integer b = target - a;
            
            ArrayList<TwoSum> lsb = cache.get(b);
            if(lsb != null){
                ArrayList<TwoSum> lsa = cache.get(a);
                
                for(TwoSum sa : lsa)
                for(TwoSum sb : lsb){
                    
                    if(sa.overlap(sb)) continue;
                    
                    Integer[] sol = new Integer[]{num[sa.index1], num[sa.index2], num[sb.index1], num[sb.index2]};
                    Arrays.sort(sol);
                    
                    String uid = Arrays.toString(sol);
                    if(!block.contains(uid)){
                        found.add(Arrays.asList(sol));
                        
                        block.add(uid);
                    }
                    
                    
                }
                
                cache.put(a, null);
                cache.put(b, null);
            }
        }
        
        
        return found;
    }
}
