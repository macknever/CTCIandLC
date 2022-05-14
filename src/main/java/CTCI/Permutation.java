package CTCI;

import java.util.HashSet;
import java.util.Set;

public interface Permutation {
    static Set<String> powerSet = new HashSet<>();
    Set<String> getPermutation(String str);
    void getPermutation(String str, String prefix);
}
