import java.util.*;

public class AnagramSubsequence {
    public static int main(String[] args) { ///  Replace it with Solve code
        int count = countAnagramSubsequences(S, W);
        System.out.println(count);
    }

    private static int countAnagramSubsequences(String S, String[] W) {
        int count = 0;
        Map<Character, Integer> sFreq = buildFreqMap(S);

        for (String w : W) {
            if (isAnagramSubsequence(S, w, sFreq)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isAnagramSubsequence(String S, String w, Map<Character, Integer> sFreq) {
        Map<Character, Integer> wFreq = buildFreqMap(w);

        for (char c : wFreq.keySet()) {
            if (!sFreq.containsKey(c) || sFreq.get(c) < wFreq.get(c)) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> buildFreqMap(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }
}

