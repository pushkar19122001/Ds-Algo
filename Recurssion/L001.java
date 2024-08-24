import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class L001 {

    public static void PrintIncreasing(int num1, int num2) {
        if (num1 == num2 + 1) {
            return;
        }
        System.out.println(num1);
        PrintIncreasing(num1 + 1, num2);

    }

    public static void PrintDecr(int num1, int num2) {
        if (num2 == num1 - 1) {
            return;
        }
        System.out.println(num2);
        PrintDecr(num1, num2 - 1);
    }

    public static void EvenOdd(int num1, int num2) {
        if (num1 == num2 + 1) {
            return;
        }
        if (num1 % 2 == 0) {
            System.out.println(num1);
            EvenOdd(num1 + 1, num2);
        }
        if (num1 % 2 == 1) {
            EvenOdd(num1 + 1, num2);
            System.out.println(num1);
        }

    }

    public static int Fact(int num1) {
        if (num1 == 0)
            return 1;

        return num1 * Fact(num1 - 1);
    }

    public static int Power(int num1, int num2) {
        if (num2 == 0)
            return 1;

        return num1 * Power(num1, num2 - 1);

    }

    public static int PowerBtr(int num1, int num2) {

        if (num2 == 0)
            return 1;
        int ans = PowerBtr(num1, num2 / 2);
        if (num2 % 2 == 0) {
            return ans * ans;
        }
        return num1 * ans * ans;
    }

    public static void display(int idx, int arr[]) {
        if (idx == arr.length)
            return;

        System.out.println(arr[idx]);
        display(idx + 1, arr);
    }

    public static void displayReverse(int idx, int arr[]) {
        if (idx == arr.length)
            return;

        displayReverse(idx + 1, arr);
        System.out.println(arr[idx]);
    }

    public static void displayEvenLoc(int idx, int arr[]) {
        if (idx == arr.length)
            return;

        if (idx % 2 == 0) {
            System.out.println(arr[idx]);
        }

        displayEvenLoc(idx + 1, arr);
    }

    public static boolean isPrime(int num) {
        boolean isPrime = false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                isPrime = true;
        }

        return isPrime;

    }

    public static void displayPrimeLoc(int idx, int arr[]) {
        if (idx == arr.length)
            return;

        if (isPrime(idx)) {
            System.out.println(arr[idx]);
        }

        displayPrimeLoc(idx + 1, arr);

    }

    public static void find(int idx, int data, int arr[]) {
        if (idx == arr.length) {
            return;
        }

        if (data == arr[idx]) {
            System.out.println(idx);
        }

        find(idx + 1, data, arr);
    }

    public static int[] findAll(int idx, int data, int arr[], int count) {
        if (idx == arr.length) {
            int arr1[] = new int[count];
            return arr1;
        }
        if (data == arr[idx]) {
            count = count + 1;
        }
        int ans[] = findAll(idx + 1, data, arr, count);
        if (data == arr[idx]) {
            ans[count - 1] = idx;
        }
        return ans;
    }

    public static ArrayList<String> subSequence(int idx, String str) {

        if (str.length() == idx) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;

        }

        char ch = str.charAt(idx);
        ArrayList<String> temp1 = subSequence(idx + 1, str);
        ArrayList<String> myans = new ArrayList<>();
        for (String st : temp1) {
            myans.add(st);
            myans.add(ch + st);
        }

        return myans;
    }

    // public static String subSequence1(String str, String ans)
    // {
    // if(str.length()==0)
    // {
    // return ans;
    // }

    // return ans;
    // }

    public static void mazepath(int sr, int sc, int er, int ec, String ans, String[] arrD, int[][] arrC, int[][] maze) {
        if (sc == ec && sr == er) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < arrD.length; i++) {
            int r = sr + arrC[i][0];
            int c = sc + arrC[i][1];
            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                if (maze[r][c] == 1) {
                    mazepath(r, c, er, ec, ans + arrD[i], arrD, arrC, maze);
                }

            }
        }
    }

    public static void ratMazePath(int sr, int sc, int er, int ec, String ans, String[] arrD, int[][] arrC, int[][] vis,
            ArrayList<String> myans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            myans.add(ans);

            return;
        }

        vis[sr][sc] = 1;
        for (int i = 0; i < arrD.length; i++) {
            int r = sr + arrC[i][0];
            int c = sc + arrC[i][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && vis[r][c] != 1) {
                ratMazePath(r, c, er, ec, ans + " " + arrD[i], arrD, arrC, vis, myans);
            }
        }
        vis[sr][sc] = 0;
    }

    public static void MazePathBtr(int sr, int sc, int er, int ec, String ans, String[] arrD, int[][] arrC,
            int[][] vis) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return;
        }
        int n = 0;
        if (er > ec) {
            n = er;
        } else {
            n = ec;
        }
        vis[sr][sc] = 1;
        for (int i = 0; i < arrD.length; i++) {
            for (int jump = 1; jump <= n; jump++) {
                int r = sr + jump * arrC[i][0];
                int c = sc + jump * arrC[i][1];
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (vis[r][c] != 1) {
                        MazePathBtr(r, c, er, ec, ans + arrD[i] + jump, arrD, arrC, vis);
                    }
                } else {
                    break;
                }
            }
        }
        vis[sr][sc] = 0;

    }

    public static void MazeJump(int sr, int sc, int er, int ec, String ans, String[] arrD, int[][] arrC, int[][] vis,
            int[][] maze) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return;
        }

        int temp = maze[sr][sc];
        vis[sr][sc] = 1;
        for (int i = 0; i < arrD.length; i++) {
            for (int j = 1; j <= temp; j++) {
                int r = sr + j * arrC[i][0];
                int c = sc + j * arrC[i][1];
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (vis[r][c] != 1) {
                        MazeJump(r, c, er, ec, ans + arrD[i] + j, arrD, arrC, vis, maze);
                    }
                } else {
                    break;
                }
            }
        }
        vis[sr][sc] = 0;
    }

    static class Paths {
        String longestPath;
        String shortePath;
        int longestPathLen;
        int shortePathLen;
        int[][] longestPathco;
        int[][] shortePathco;
    }

    public static int[][] copyarr(int[][] arr1) {
        int[][] myans = new int[4][4];
        for (int i = 0; i < myans.length; i++) {
            for (int j = 0; j < myans.length; j++) {
                myans[i][j] = arr1[i][j];
            }

        }

        return myans;
    }

    public static Paths mazePathjumpbtr(int sr, int sc, int er, int ec, String ans, int[][] arr, int[][] vis) {
        Paths myans = new Paths();
        if (sr == er && sc == ec) {
            Paths temp1 = new Paths();
            temp1.longestPath = ans;
            temp1.shortePath = ans;
            temp1.longestPathLen = ans.length();
            temp1.shortePathLen = ans.length();
            temp1.longestPathco = copyarr(vis);
            temp1.shortePathco = copyarr(vis);

            return temp1;
        }
        // Paths p= new Paths();
        myans.longestPath = "";
        myans.shortePath = "";
        myans.longestPathLen = (int) -1e9;
        myans.shortePathLen = (int) 1e9;
        myans.longestPathco = new int[sr + 1][sc + 1];
        myans.shortePathco = new int[sr + 1][sc + 1];

        String[] arrD = { "D", "R", "L", "U" };
        int[][] arrC = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        int temp = arr[sr][sc];
        arr[sr][sc] = -1;
        vis[sr][sc] = 1;
        for (int i = 0; i < arrD.length; i++) {
            for (int j = 1; j <= temp; j++) {
                int r = sr + j * arrC[i][0];
                int c = sc + j * arrC[i][1];
                Paths p = new Paths();
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (arr[r][c] > 0) {
                        p = mazePathjumpbtr(r, c, er, ec, ans + arrD[i] + "" + j, arr, vis);

                        if (p.longestPathLen > myans.longestPathLen) {
                            myans.longestPath = p.longestPath;
                            myans.longestPathco = p.longestPathco;
                            myans.longestPathLen = p.longestPathLen;
                        }

                        if (p.shortePathLen < myans.shortePathLen) {
                            myans.shortePathco = p.shortePathco;
                            myans.shortePath = p.shortePath;
                            myans.shortePathLen = p.shortePathLen;

                        }
                    }
                } else {
                    break;
                }
            }
        }
        arr[sr][sc] = temp;
        vis[sr][sc] = 0;
        return myans;
    }

    public static ArrayList<Paths> mazePathjumpbtr02(int sr, int sc, int er, int ec, String ans, int[][] arr,
            int[][] vis) {
        ArrayList<Paths> ansList = new ArrayList<>();
        if (sr == er && sc == ec) {
            ArrayList<Paths> TempList = new ArrayList<>();
            Paths temp = new Paths();
            temp.longestPath = ans;
            temp.shortePath = ans;
            temp.longestPathLen = ans.length();
            temp.shortePathLen = ans.length();
            temp.longestPathco = copyarr(vis);
            temp.shortePathco = copyarr(vis);
            TempList.add(temp);
            return TempList;
        }
        Paths myans = new Paths();
        myans.longestPath = "";
        myans.shortePath = "";
        myans.longestPathLen = (int) -1e9;
        myans.shortePathLen = (int) 1e9;
        myans.longestPathco = new int[sr + 1][sc + 1];
        myans.shortePathco = new int[sr + 1][sc + 1];

        String[] arrD = { "D", "R", "L", "U" };
        int[][] arrC = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        int temp = arr[sr][sc];
        arr[sr][sc] = -1;
        vis[sr][sc] = 1;
        for (int i = 0; i < arrD.length; i++) {
            for (int j = 1; j <= temp; j++) {
                int r = sr + j * arrC[i][0];
                int c = sc + j * arrC[j][1];

                Paths p = new Paths();
                ArrayList<Paths> list2 = new ArrayList<>();
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (arr[r][c] > 0) {
                        list2 = mazePathjumpbtr02(r, c, er, ec, ans + arrD[i] + "" + j, arr, vis);
                        for (Paths st : list2) {
                            if (st.longestPathLen > myans.longestPathLen) {
                                list2.clear();
                                myans.longestPath = st.longestPath;
                                myans.longestPathco = st.longestPathco;
                                myans.longestPathLen = st.longestPathLen;
                                myans.longestPathco = copyarr(vis);
                                list2.add(myans);
                            }
                            if (p.longestPathLen == myans.longestPathLen) {
                                myans.longestPath = st.longestPath;
                                myans.longestPathco = st.longestPathco;
                                myans.longestPathLen = st.longestPathLen;
                                myans.longestPathco = copyarr(vis);
                                list2.add(myans);
                            }
                            if (p.shortePathLen < myans.shortePathLen) {
                                myans.shortePathco = st.shortePathco;
                                myans.shortePath = st.shortePath;
                                myans.shortePathLen = st.shortePathLen;
                                myans.shortePathco = copyarr(vis);
                                list2.clear();
                                list2.add(myans);
                            }
                            if (p.shortePathLen == myans.shortePathLen) {
                                myans.shortePathco = p.shortePathco;
                                myans.shortePath = p.shortePath;
                                myans.shortePathLen = p.shortePathLen;
                                myans.shortePathco = copyarr(vis);
                                ansList.add(myans);
                            }

                        }

                    }
                } else {
                    break;
                }
            }
        }

        return ansList;
    }

    static class Paths01 {
        ArrayList<String> longestPath;
        ArrayList<String> shortePath;
        int longestPathLen;
        int shortePathLen;
        int[][] longestPathco;
        int[][] shortePathco;
    }

    public static Paths01 mazePathjumpbtr03(int sr, int sc, int er, int ec, String ans, int[][] arr, int[][] vis) {
        Paths01 myans = new Paths01();
        if (sr == er && sc == ec) {
            Paths01 temp1 = new Paths01();
            temp1.longestPath.add(ans); // 0 hdvd
            temp1.shortePath.add(ans); // 0 rd
            temp1.longestPathLen = ans.length();
            temp1.shortePathLen = ans.length();
            temp1.longestPathco = copyarr(vis);
            temp1.shortePathco = copyarr(vis);
            return temp1;
        }
        // Paths p= new Paths();
        myans.longestPath.add("");
        myans.shortePath.add("");
        myans.longestPathLen = (int) -1e9;
        myans.shortePathLen = (int) 1e9;
        myans.longestPathco = new int[sr + 1][sc + 1];
        myans.shortePathco = new int[sr + 1][sc + 1];

        String[] arrD = { "D", "R", "L", "U" };
        int[][] arrC = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        int temp = arr[sr][sc];
        arr[sr][sc] = -1;
        vis[sr][sc] = 1;
        for (int i = 0; i < arrD.length; i++) {
            for (int j = 1; j <= temp; j++) {
                int r = sr + j * arrC[i][0];
                int c = sc + j * arrC[i][1];
                Paths01 p = new Paths01();
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (arr[r][c] > 0) {
                        p = mazePathjumpbtr03(r, c, er, ec, ans + arrD[i] + "" + j, arr, vis);

                        if (p.longestPathLen > myans.longestPathLen) {
                            myans.longestPath.clear();
                            String st = p.longestPath.get(0);
                            myans.longestPath.add(st);
                            myans.longestPathco = p.longestPathco;
                            myans.longestPathLen = p.longestPathLen;
                        }
                        if (p.longestPath == myans.longestPath) // myans.shortpath= 0 hd 1 vd 2 rd
                        {
                            String st = p.longestPath.get(0);
                            myans.longestPath.add(st);
                        }

                        if (p.shortePathLen < myans.shortePathLen) {
                            // myans.shortePath.clear();
                            myans.shortePath = p.shortePath;
                            myans.shortePathco = p.shortePathco;
                            myans.shortePathLen = p.shortePathLen;

                        }
                        if (p.shortePath == myans.shortePath) {
                            String st = p.shortePath.get(0);
                            myans.shortePath.add(st); //
                        }
                    }
                } else {
                    break;
                }
            }
        }
        arr[sr][sc] = temp;
        vis[sr][sc] = 0;

        return myans;
    }

    public static int mazaBlockedlist(int sr, int sc, int er, int ec, String ans, int[][] arr, int[][] BlockedList) {
        int count = 0;
        if (sr == er && sc == ec) {
            count = count + 1;
            System.out.println(ans);
            // System.out.println(count);
            return count;
        }

        String[] arrD = { "R", "D" };
        int[][] arrC = { { 0, 1 }, { 1, 0 } };
        int temp1 = 0;
        int temp2 = 0;
        for (int j = 0; j < BlockedList.length; j++) {
            temp1 = BlockedList[j][0];
            temp2 = BlockedList[j][1];
            arr[temp1][temp2] = -1;

            // for(int i=0; i< arrD.length; i++)
            // {
            // int r= sr+ arrC[i][0];
            // int c= sc+ arrC[i][1];
            // System.out.println(r + " " + c);
            // if(r>= 0 && c>= 0 && r<=er && c<=ec )
            // {

            // if(r!= temp1 && c!=temp2)
            // {
            // mazaBlockedlist(r, c, er, ec, ans+ arrD[i], arr, BlockedList, count);
            // }
            // }
            // }
        }

        for (int i = 0; i < arrD.length; i++) {
            int r = sr + arrC[i][0];
            int c = sc + arrC[i][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                if (arr[r][c] != -1) {
                    count += mazaBlockedlist(r, c, er, ec, ans + arrD[i], arr, BlockedList);
                }
            }
        }
        return count;
    }

    public static int Permutation(int tar, int[] arr, String ans) {
        int count = 0;
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (tar >= 0) {
                count += Permutation(tar - arr[i], arr, ans + arr[i]);
            }

        }
        return count;
    }

    public static int combinationInfinite_sub(String ans, int tar, int[] arr, int idx) {
        int count = 0;
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        if (tar - arr[idx] >= 0) {
            count += combinationInfinite_sub(ans + arr[idx], tar - arr[idx], arr, idx);
        }
        count += combinationInfinite_sub(ans, tar, arr, idx + 1);
        return count;
    }

    public static int PermutationInfinite_sub(String ans, int tar, int[] arr, int idx) {
        int count = 0;
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        if (tar - arr[idx] >= 0) { // arr 1
            count += PermutationInfinite_sub(ans + arr[idx], tar - arr[idx], arr, 0); // 0 0
            count += PermutationInfinite_sub(ans, tar, arr, idx + 1); // 2 1 //2 0
        }
        return count;
    }

    public static int PermutationSingle_sub(String ans, int tar, int idx, int[] arr) {
        int count = 0;
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int temp = arr[idx];
        if (tar - temp >= 0) {
            if (arr[idx] > 0) {
                arr[idx] = -1;
                count += PermutationSingle_sub(ans + temp, tar - temp, 0, arr);
                arr[idx] = temp;
            }
            count += PermutationSingle_sub(ans, tar, idx + 1, arr);
        }
        return count;
    }

    public static int subsets(String ans1, String ans2, int sum, int[] arr, int idx, int Tsum) {
        // int Tsum = 0;
        int count = 0;
        if (sum == Tsum / 2 || idx == arr.length) {
            if (sum == Tsum / 2) { // 10204070
                System.out.println(ans1);
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != -1)
                        ans2 += arr[i];
                }
                System.out.println(ans2);
                return 1;
            }
            return 0;

        }
        int temp = arr[idx]; // 10 20
        if (arr[idx] >= 0 && sum + arr[idx] <= Tsum / 2) {
            arr[idx] = -1;
            count += subsets(ans1 + temp, ans2, sum + temp, arr, idx, Tsum);
            arr[idx] = temp;
        }
        count += subsets(ans1, ans2, sum, arr, idx + 1, Tsum);
        return count;
    }

    public static int stringPermutation(String str, String ans, int idx) {
        int count = 0;
        if (str.length() == ans.length()) {
            System.out.println(ans);
            return 1;
        }
        if (str.length() > idx) {
            count += stringPermutation(str, ans + str.charAt(idx), 0);
            count += stringPermutation(str, ans, idx + 1);
        }
        return count;
    }
//============================String Permutation All Using for loop============================================//

    public static void stringPermutationstr(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        // boolean [] arr= new boolean[26];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            // arr[ch-'a']=true;
            String myans= str.substring(0, i) + str.substring(i+1);
            stringPermutationstr(myans,ans+ch);

        }
    }

    public static void stringPermutation_sub(String str, String ans)
    {

    }
    // static ArrayList<Integer> myans= new ArrayList<>();
    // public List<List<Integer>> permute(int[] nums) {
    // List<List<Integer>> Fans = new List<List<Integer>>();
    // int[] num = { 1, 2, 3 };
    // ArrayList<Integer> Tans = leetCode46(nums, "", 0);
    // Fans.add(Tans);
    // return Fans;
    // List<List<Integer>> ab = new ArrayList<>() {

    // };

    // }
    

    public static ArrayList<Integer> leetCode46(int[] arr, String ans, int idx) {
        ArrayList<Integer> myans = new ArrayList<>();
        if (ans.length() == arr.length || idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (ans.length() == arr.length) {
                int Nans = Integer.valueOf(ans);
                temp.add(Nans);
                return temp;
            }
            return temp;
        }
        int store = arr[idx];
        if (arr[idx] > 0) {
            arr[idx] = -1;
            ArrayList<Integer> store2 = leetCode46(arr, ans + store, 0); // store 123
            for (int i : store2) {
                myans.add(i); // 123
            }
            arr[idx] = store;
        }
        ArrayList<Integer> store3 = leetCode46(arr, ans, idx + 1); // 3 idx=3 ans=12
        for (int i : store3) {
            myans.add(i);
        }
        return myans;
    }

    public static ArrayList<Integer> leetCode39(int[] arr, String ans, int idx, int target) {
        ArrayList<Integer> myans = new ArrayList<>();
        if (target == 0 || idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (target == 0) {
                int Nans = Integer.valueOf(ans);
                temp.add(Nans);
                return temp;
            }
            return temp;
        }
        int store = arr[idx];
        if (target - store >= 0) {
            // arr[idx] = -1;
            ArrayList<Integer> store2 = leetCode39(arr, ans + store, idx, target - store); // store 123
            for (int i : store2) {
                myans.add(i); // 123
            }
            // arr[idx] = store;
        }
        ArrayList<Integer> store3 = leetCode39(arr, ans, idx + 1, target); // 3 idx=3 ans=12
        for (int i : store3) {
            myans.add(i);
        }
        return myans;
    }
//=================================Leet code 40 problem using ArrayList===========================================//

    public static ArrayList<Integer> leetCode40(int[] arr, String ans, int idx, int target) {
        ArrayList<Integer> myans = new ArrayList<>();
        if (target == 0 || idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (target == 0) {
                int Nans = Integer.valueOf(ans);
                temp.add(Nans);
                return temp;
            }
            return temp;
        }
        int[] num = new int[10];
        int store = arr[idx];
        if (target - store >= 0) {
            // arr[idx] = -1;
            ArrayList<Integer> store2 = leetCode40(arr, ans + store, idx, target - store); // store 123
            for (int i : store2) {
                myans.add(i); // 123
            }
            // arr[idx] = store;
        }
        ArrayList<Integer> store3 = leetCode40(arr, ans, idx + 1, target); // 3 idx=3 ans=12
        for (int i : store3) {
            myans.add(i);
        }
        return myans;
    }
//========================================stair jump problem===================================================//

    public static int stairJump(String ans, int tar, int stairCount) {
        int count = 0;
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        
            for (int jump = 1; jump <= tar; jump++) {
                if (tar - jump >= 0) {
                    count += stairJump(ans + "S" + stairCount + "J" + jump + " ", tar - jump, stairCount+1);
                    
                }
            }
        

        return count;
    }
//===============================Queen Combination using for loop============================================//

    public static int queenCombination1D(int tnb, int bno, int tnq, int qpsf, String ans)
    {
        int count=0;
        if(qpsf==tnq)
        {
            System.out.println(ans);
            return 1;
        }

        for(int i=bno; i< tnb; i++)
        {
            //if(qpsf <= tnq)
            count+= queenCombination1D(tnb, i+1, tnq, qpsf+1, ans+"B"+i+"Q"+qpsf);
        }
        return count;
    }
//===============================Queen Permutation using for loop================================================//

    public static int queenPermutatiion1D(int tnb, int bno, int tnq, int qpsf, String ans, int[] vis)
    {
        int count=0;
        if(qpsf==tnq)
        {
            System.out.println(ans);
            return 1;
        }
        for(int i=0 ; i< tnb; i++)
        {
            if(vis[i]!=-1){
                vis[i]=-1;
                count+= queenPermutatiion1D(tnb, i, tnq, qpsf+1, ans+"B"+i+"Q"+qpsf+" ", vis);
                vis[i]=0;
            }           
        }
        return count;
    }
//===================================Queen Combination using subsequence============================================//

    public static int queencombination1D_sub(int tnb, int bno, int tnq, int qpsf, String ans )
    {
        int count=0;
        if(qpsf==tnq || bno ==tnb)
        {
            if(qpsf==tnq)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        
        count+= queencombination1D_sub(tnb, bno+1, tnq, qpsf+1, ans+"B"+bno+"Q"+qpsf+" ");
        count+= queencombination1D_sub(tnb, bno+1, tnq, qpsf, ans);

        return count;
    }
//===================================Queen Combination using subsequence============================================//

    public static int queenPermutation1D_sub(int tnb, int bno, int tnq, int qpsf, String ans, int[] vis )
    {
        int count=0;
        if(qpsf==tnq || bno ==tnb)
        {
            if(qpsf==tnq)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        if(vis[bno]!=-1)
        {
            vis[bno]=-1;
            count+= queenPermutation1D_sub(tnb, 0, tnq, qpsf+1, ans+"B"+bno+"Q"+qpsf+" ",vis);
            vis[bno]=0;
        }
        count+= queenPermutation1D_sub(tnb, bno+1, tnq, qpsf, ans, vis);

        return count;
    }
//==============================queencombination2D using for Loop============================================//

    public static int queencombination2D_for(int n, int m, int bno, int tnq, int qpsf, String ans )
    {
        int count=0;
        if(qpsf==tnq)
        {
            System.out.println(ans);
            return 1;
        }
        for(int i=bno; i< n*m; i++)
        {
            int r= i/ n;
            int c= i%m;
           
            if( r< n && r< m)
            {
                count+=queencombination2D_for(n, m, i+1, tnq, qpsf+1, ans+"B"+"("+r+","+c+")"+"Q"+qpsf+" ");
            }
            //count+=queencombination2D_sub(n, m, bno+1, tnq, qpsf, ans);

        }
        return count;
    }

    public static int queenPermutation2D_for(int n, int m, int bno, int tnq, int qpsf, String ans, int [] vis )
    {
        int count=0;
        if(qpsf==tnq)
        {
            System.out.println(ans);
            return 1;
        }

        for(int i=0; i< n*m; i++)
        {
            int r= i/n;
            int c= i%m;
            int temp= vis[i];
            if(vis[i]!=-1 && r<n && c<m)
            {
                vis[i]=-1;
                count+= queenPermutation2D_for(n, m, bno, tnq, qpsf+1, ans+"B"+"("+r+","+c+")"+"Q"+qpsf+" ", vis);
                vis[i]=0;
            } 

        }
        return count;
    }



    public static int queencombination2DConstraints_for(boolean[][] arr,int n, int m, int bno, int tnq, int qpsf, String ans)
    {
        int count=0;
        if(qpsf==tnq)
        {
            System.out.println(ans);
            return 1;
        }

        for(int i=bno; i< n*m; i++)
        {
            int r= i/n;
            int c= i%m;
            if(!issafe(arr,r,c))
            {
                arr[r][c]=true;
                count+=queencombination2DConstraints_for(arr, n, m, i+1, tnq, qpsf+1, ans+"B"+"("+r+","+c+")"+"Q"+qpsf+" ");
                arr[r][c]= false;
            }
        }
        return count;
    }

    public static boolean issafe(boolean[][] arr, int sr, int sc)
    {
        String [] arrD={"U", "L","UDF","UDB"};
        int [][] arrC={{-1,0},{0,-1},{-1,1},{-1,-1}};   //     
        int er= arr.length;
        int ec= arr[0].length;
        for(int i=0; i< arrD.length; i++)
        {
            for(int jump=1; jump< arr.length; jump++)
            {
                int r= sr+ jump*arrC[i][0];
                int c= sc+ jump*arrC[i][1];
                if(r>=0 && c>=0 && r< er && c< ec)
                {
                    if(arr[r][c])
                    {
                        return true;
                    }
                }
                else
                {
                    break;
                }       
            }
        }
        return false;
    }

    public static int queenPermutation2DConstraints_for(boolean[][] arr,int n, int m, int bno, int tnq, int qpsf, String ans)
    {
        int count=0;
        if(qpsf==tnq)
        {
            System.out.println(ans);
            return 1;
        }

        for (int q = 0; q < tnq; q++) {
            for (int i = bno; i < n * m; i++) {
                int r = i / n;
                int c = i % m;
                if (!issafe(arr, r, c)) {
                    arr[r][c] = true;
                    count += queenPermutation2DConstraints_for(arr, n, m, i + 1, tnq, qpsf + 1,
                            ans + "B" + "(" + r + "," + c + ")" + "Q" + qpsf + " ");
                    arr[r][c] = false;
                }
            }
            
        }
        return count;
    }

    public static int queencombination2D_sub(int n, int m, int bno, int tnq,int qpsf, String ans)
    {
        int count=0;
        if(qpsf==tnq || bno==n*m){
            if(qpsf==tnq)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int r= bno/n;
        int c= bno%m;
        
        count+= queencombination2D_sub(n, m, bno+1, tnq, qpsf+1, ans + "B" + "(" + r + "," + c + ")" + "Q" + qpsf+ "");
        count+= queencombination2D_sub(n, m, bno+1, tnq, qpsf, ans);
        return count;
    }

    public static int queenPermutation2D_sub(int n, int m, int bno, int tnq, int qpsf, String ans, int[] vis)
    {
        int count=0;
        if(qpsf==tnq || bno== n*m)
        {
            if(qpsf==tnq)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int r= bno/n;
        int c= bno%m;
        int temp=vis[bno];
        if(vis[bno]!=-1)
        {
            vis[bno]=-1;
            count+= queenPermutation2D_sub(n, m, 0, tnq, qpsf+1, ans + "B" + "(" + r + "," + c + ")" + "Q" + qpsf+ "", vis);
            vis[bno]=0;
        }
        count+= queenPermutation2D_sub(n, m, bno+1, tnq, qpsf, ans, vis);

        return count;
    }

    public static int queencombination2D_btr(int[] Row,int[] Col,int[] Dia1,int[] Dia2,int bno, int tnq, int qpsf, String ans)
    {
        int count=0;
        if(qpsf==tnq)
        {
            System.out.println(ans);
            return 1;
        }
        int n= Row.length;
        int m= Col.length;
        for(int i=bno; i<n*m; i++)
        {
            int r= i/n;
            int c= i%m;
            if(Row[r]!=-1 && Col[c]!=-1 && Dia1[r+c]!=-1 && Dia2[r-c+m-1]!=-1)
            {
                Row[r]=-1;
                Col[c]=-1;
                Dia1[r+c]=-1;
                Dia2[r-c+m-1]=-1;
                count+= queencombination2D_btr(Row, Col, Dia1, Dia2, i+1, tnq, qpsf+1, ans+ "B" + "(" + r + "," + c + ")" + "Q" + qpsf+ "");
                Row[r]=0;
                Col[c]=0;
                Dia1[r+c]=0;
                Dia2[r-c+m-1]=0;
            }
        }
        return count;
    }

    public static int totalNQueens(int n) {
        //int tnq= n;
        int [] row= new int[n];
        int [] col= new int[n];
        int [] dia1= new int[n+n-1];
        int [] dia2= new int[n+n-1];
        int ans= Nqueens(row, col, dia1, dia2,0,n);
        //System.out.println(ans);
        return ans;
        
    }

    public static int Nqueens(int[] row,int[] col,int[]dia1,int[] dia2,int bno, int tnq)
    {
        List<List<String>>ans= new ArrayList<>();
        int count=0;
        if(tnq==0)
        {
            return 1;
        }
        int n= row.length;
        int m= col.length;
        for(int i=bno; i<n*m; i++ )
        {
           int r= i/n;
           int c= i%n;
            if(row[r]!=-1 && col[c]!=-1 && dia1[r+c]!=-1 && dia2[r-c+m-1]!=-1)
            {
                row[r]=-1;
                col[c]=-1;
                dia1[r+c]=-1;
                dia2[r-c+m-1]=-1;
                count+= Nqueens(row, col, dia1, dia2, i+1, tnq-1);
                row[r]=0;
                col[c]=0;
                dia1[r+c]=0;
                dia2[r-c+m-1]=0;
            }
        }
        return count;
    }
    public static int LowestSum(List<Integer> cells)
    {
        //if(cells.size()==1)
        int count=0;
        Collections.sort(cells);

        int sum=cells.get(0);
        ArrayList<Integer> myans= new ArrayList<>();
        for(int i=1; i< cells.size(); i++)
        {
            sum+=cells.get(i);
            myans.add(sum);
        }
        for(Integer in: myans)
        {
            count+= in;
        }
        return count ;
    }



    // =========================solve function==============================================//

    public static void solve() {
        // PrintIncreasing(1, 5);
        // PrintDecr(1, 5);
        // EvenOdd(1, 5);
        // System.out.println(Fact(5));
        // System.out.println( Power(2, 5));
         System.out.println(PowerBtr(2, 5));
        // int[] arr = { 1, 2, 5, 3, 7, 2, 9 };
        // display(0, arr);
        // displayReverse(0, arr);
        // displayEvenLoc(0, arr);
        // displayPrimeLoc(0, arr);
        // find(0, 2, arr);
        // int ans[]=findAll(0, 2, arr, 0);
        // for(int i=0;i<ans.length;i++)c
        // {
        // System.out.println(ans[i]);
        // }
        String[] arrD = { "N", "E", "S", "W" };
        //Arrays.fill(arrD, arrD);
        int[][] arrC = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        // int [][] maze={{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        // mazepath(0, 0, 3, 3, "", arrD, arrC, maze);
        int[][] vis = new int[4][4];
        int[][] maze = { { 2, 1, 0, 0 }, { 3, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 } };
        ArrayList<String> myans = new ArrayList<String>();
        // ratMazePath(0, 0, 2, 2, "", arrD, arrC, vis, myans);
        // System.out.println(myans.size());
        // MazePathBtr(0, 0, 2, 2, "", arrD, arrC, vis);
        // MazeJump(0, 0, 3, 3, "", arrD, arrC, vis, maze);
        // ArrayList<Paths> ans= mazePathjumpbtr02(0, 0, 3, 3, "", maze, vis);
        // System.out.println(ans.longestPath);
        // System.out.println(ans.shortePath);
        // int[][] BlockedList={{0,1},{2,1}};
        // int count=0;
        // count=mazaBlockedlist(0, 0, 3, 3, "", vis, BlockedList);
        // System.out.println(count);
        // int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
        // int Tsum=0;
        // for (int i = 0; i < arr.length; i++) {
        // Tsum += arr[i];
        // }
        // int ans1=stringPermutation("abcd", "", 0);
        // System.out.println(ans1);
        int[] arr = { 2, 3, 6, 7 };
        // ArrayList<Integer> ans = leetCode39(arr, "", 0, 7);
        // System.out.println(ans);
        // for(int i: ans)
        // {
        // System.out.println(i);
        // }
        int [] vis1 = new int[5];
        //int ans = queenPermutation1D_sub(5, 0, 3, 0, "",vis1);
        //System.out.println(ans);
        ArrayList<Integer> arr1= new ArrayList<>();
        arr1.add(20);
        arr1.add(40);
        arr1.add(50);
        arr1.add(30);
       String s="abashb";
       
        //int ans= LowestSum(arr1);
        //System.out.println(ans);
        //int ans= queencombination2D_for(3, 3, 0, 3, 0, "");
        //System.out.println(ans);
        int noR=4;
        int noC=4;
        int [] vis2=new int[noR*noC];
        //int ans= queenPermutation2D_for(3, 3, 0, 3, 0, "", vis2);
        //System.out.println(ans);
        boolean[][] arrB= new boolean[noR][noC];
        //int ans= queencombination2DConstraints_for(arrB, noR, noC, 0, 4, 0, "");
        //System.out.println(ans);
        //int ans= queenPermutation2DConstraints_for(arrB, noR, noC,0, 4, 0, "");
        //System.out.println(ans);
        //int ans= queencombination2D_sub(3, 3, 0, 3, 0, "");
        //System.out.println(ans);
        int[] Row= new int[noR];
        int[] Col= new int[noC];
        int[] Dia1= new int[noR+noC-1];
        int[] Dia2= new int[noR+noC-1];
        //int ans= queencombination2D_btr(Row, Col, Dia1, Dia2, 0, 4, 0, "");
        //System.out.println(ans);
        int ans= totalNQueens(4);
        System.out.println(ans);
    }

    // ================================main function===============================================//
    public static void main(String[] args) {
        solve();
    }

}