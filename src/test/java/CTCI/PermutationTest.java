package CTCI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PermutationTest {

    @Test
    void permutationTest() {
        PermutationImp permutationOperator = new PermutationImp();
        String str = "abc";
        Set<String> permutations = permutationOperator.getPermutation(str);
        Assertions.assertEquals(6,permutations.size());
    }

}
