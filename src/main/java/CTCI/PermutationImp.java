package CTCI;

import java.util.HashSet;
import java.util.Set;

public class PermutationImp implements Permutation{




    @Override
    public Set<String> getPermutation(String str) {

        getPermutation(str,"");
        return powerSet;
    }

    @Override
    public void getPermutation(String str, String prefix) {
        if(str.length() == 0) {
            powerSet.add(prefix);
        } else {
            for(int i = 0; i < str.length(); i++) {
                String remains = str.substring(0,i) + str.substring(i+1);
                String newPrefix = prefix + str.charAt(i);
                getPermutation(remains,newPrefix);
            }
        }
    }
}
