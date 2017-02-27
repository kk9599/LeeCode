import java.util.HashMap;
import java.util.Map;

public class isAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> tmp = new HashMap<>();
        char [] ss = s.toCharArray();
        char [] tt = t.toCharArray();
        for(int i=0; i<ss.length; i++)
        {
        	if(tmp.containsKey(ss[i]))
        		tmp.put(ss[i], tmp.get(ss[i]+1));
        	else
        		tmp.put(ss[i], 1);
        }
        for(int i=0; i<tt.length; i++)
        {
        	if(!tmp.containsKey(tt[i]) && tmp.get(tt[i])<=0)
        		return false;
        	else
        		tmp.put(ss[i], tmp.get(ss[i]-1));
        }
        return true;
    }
    //这种循环方式省去了判断和i的自增，效率很高
    public boolean isAnagram1(String s, String t) {
        int [] tmp = new int[26];
        for(char c : s.toCharArray())
            tmp[c-'a'] ++;
        for(char c:t.toCharArray())
            tmp[c-'a'] --;
        for(int a:tmp)
            if(a!=0)
                return false;
        return true;
    }
    //思路与上面代码相同，但是循环方式比较耗时
    public boolean isAnagram2(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
