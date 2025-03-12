package AmazonInterview.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {
    public static void permutations(String s, String ans, List<String> permutations){
        if(s.isEmpty()) {
            permutations.add(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String in = s.substring(0,i) + s.substring(i+1);
            char ch = s.charAt(i);

            permutations(in,ans +ch,permutations);
        }
    }

    public static void main(String[] args) {
        String s = "ABC";
        List<String> ans = new ArrayList<>();
        permutations(s,"",ans);
        for(String a : ans){
            System.out.println(a);
        }
    }
}
