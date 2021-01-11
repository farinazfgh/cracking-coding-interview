package bitwisexor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BitVector {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println("i: " + i + " , " + (1 << i));
        }
        String str = "farinaz";
        for (int i = 0; i < str.length(); i++)
            System.out.print(str.charAt(i) - 'a' + " , ");

        System.out.println(isUniqueChars("farinaz"));

    }

    static boolean isUniqueChars(String str) {
        int bitVector = 0; //bitVector is used here as a storage for bits.
        /*
        Every bit in integer value can be treated as a flag, so eventually int is an array of bits (flags).
         */
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((bitVector & (1 << val)) > 0) {//Each bit in your code states whether the character with bit's index was found in string or not.
                return false;
            }
            bitVector |= (1 << val);//set flag at index 5 to true
        }
        return true;
    }

    boolean isPermutationOfPalindrome(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    /*
    Create a bit vector for the string. For each letter with value i,
    toggle the ith bit. */
    int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int ithCharacter = getCharNumber(c);
            bitVector = toggle(bitVector, ithCharacter);
        }
        return bitVector;
    }

    private int getCharNumber(char c) {
        return c - 'a';
    }

    /* Toggle the ith bit in the integer. */
    int toggle(int bitVector, int ithCharacter) {

        if (ithCharacter < 0) return bitVector;
        int mask = 1 << ithCharacter;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    /* Check that exactly one bit is set by subtracting one from the integer and
     * ANDing it with the original integer. */
    boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    void test() {
        long numberOflnts = ((long) Integer.MAX_VALUE) + 1;
        byte[] bitfield = new byte[(int) (numberOflnts / 8)];
        String filename = "";
        try {
            findOpenNurnber(filename, bitfield);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void findOpenNurnber(String filename, byte[] bitfield) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            /* Finds the corresponding number in the bitfield by using the OR operator to
             * set the nth bit of a byte (e.g., 10 would correspond to the 2nd bit of
             * index 2 in the byte array). */
            bitfield[n / 8] |= 1 << (n % 8);
        }
        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                /* Retrieves the individual bits of each byte. When 0 bit is found, print
                 * the corresponding value. */
                if ((bitfield[i] & (1 << j)) == 0) {
                    System.out.println(i * 8 + j);
                    return;
                }
            }
        }
    }


    //when we dont have enough memory and we need to bring chunks
    int findOpenNumber(String filename) throws FileNotFoundException {
        int rangeSize = (1 << 20); // 20 bits (2^17 bytes)
        /* Get count of number of values within each block. */
        int[] blocks = getCountPerBlock(filename, rangeSize);
        /* Find a block with a missing value. */
        int blocklndex = findBlockWithMissing(blocks, rangeSize);
        if (blocklndex < 0) return -1;
        /* Create bit vector for items within this range. */
        byte[] bitVector = getBitVectorForRange(filename, blocklndex, rangeSize);

        /* Find a zero in the bit vector */
        int offset = findZero(bitVector);
        if (offset < 0) return -1;

        /* Compute missing value. */
        return blocklndex * rangeSize + offset;
    }
    /* Get count of items within each range. */

    int[] getCountPerBlock(String filename, int rangeSize) throws FileNotFoundException {
        int arraySize = Integer.MAX_VALUE / rangeSize + 1;
        int[] blocks = new int[arraySize];
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            blocks[value / rangeSize]++;

        }
        in.close();
        return blocks;

    }
    /* Find a block whose count is low. */

    int findBlockWithMissing(int[] blocks, int rangeSize) {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] < rangeSize) {
                return i;
            }
        }
        return -1;
    }

    /* Create a bit vector for the values within a specific range. */
    byte[] getBitVectorForRange(String filename, int blockIndex, int rangeSize) throws FileNotFoundException {
        int startRange = blockIndex * rangeSize;
        int endRange = startRange + rangeSize;
        byte[] bitVector = new byte[rangeSize / Byte.SIZE];

        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            /* If the number is inside the block that's missing numbers, we record it */
            if (startRange <= value && value < endRange) {
                int offset = value - startRange;
                int mask = (1 << (offset % Byte.SIZE));
                bitVector[offset / Byte.SIZE] |= mask;
            }
        }
        in.close();
        return bitVector;
    }

    /* Find bit index that is 13 within byte.*/
    int findZero(byte b) {
        for (int i = 0; i < Byte.SIZE; i++) {
            int mask = 1 << i;
            if ((b & mask) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* Find a zero within the bit vector and return the index. */
    int findZero(byte[] bitVector) {
        for (int i = 0; i < bitVector.length; i++) {
            if (bitVector[i] != ~0) {
                // If not all 1 s
                int bitIndex = findZero(bitVector[i]);
                return i * Byte.SIZE + bitIndex;
            }
        }
        return -1;
    }

    boolean get_ith_bit(int number, int i) {
        return ((number & (1 << i)) != 0);

    }

    int set_ith_Bit(int number, int i) {
        return (number | (1 << i));

    }

    int clear_ith_bit(int number, int i) {
        return (number & ~(1 << i));
    }
}
