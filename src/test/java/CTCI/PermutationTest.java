package CTCI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationTest {

    @Test
    void permutationTest() {
        PermutationImp perm = new PermutationImp();
        final String str = "abc";
        int size = perm.getPermutation(str).size();
        assertEquals(6,size);
    }
}
