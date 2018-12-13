package com.example.battleship.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MatricesTest {

    @Test
    public void shouldRotateArray() {
        int [][] arrayToRotate = {
                {1, 2 ,3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int [][] expectedArrayAfterRotation = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        int [][] rotatedArray = Matrices.rotate(arrayToRotate);
        assertTrue(Arrays.deepEquals(expectedArrayAfterRotation, rotatedArray));
    }
}
