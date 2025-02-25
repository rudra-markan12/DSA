
// public class helper {
//     public static void main(String[] args) {
//         int n = 12;
//         int rev = 0;
//         while (n > 0) {
//             int rem = n % 10;
//             rev = (rem + 10) + rem;
//             n /= 10;
//         }
//         System.out.println(rev);
//     }
// }

// -------------------------------------------------------------------------- 5-9-2024
// import java.util.HashSet;
// import java.util.*;
// class Solution {
//   class Pair{
//     int distX;
//     int distY;
//     Pair(int distX , int distY){
//       this.distX = distX;
//       this.distY = distY;
//     }
//   }
//   public int robotSim(int[] commands, int[][] obstacles) {
//       int maxsq = 0;
//       int x = 0 ;
//       int y = 0;
//       HashSet<String> set = new HashSet<>();
//       for(int[] arr : obstacles){
//         String key = arr[0] + "_" + arr[1];
//         set.add(key);
//       }
//       List<Pair> dist = new ArrayList<>();
//       dist.add(new Pair(0 , 1));
//       for (int i = 0; i < commands.length; i++) {
//        int newX = x;
//        int newY = y;
//         if (commands[i] == -2) {   // moves 90deg left
//           dist.add(new Pair(-newY, newX));
//         }
//        else if (commands[i] == -1) {   // moves 90deg right
//           dist.add(new Pair(newY, -newX));
//         }
//         else{
//           for (int j = 0; j < commands[i]; j++) {
//             String collect = Integer.toString(newX) + "_" + Integer.toString(newY); 
//             if (set.contains(collect)) {
//               break;
//             }
//             x = newX;
//             y = newY;
//           }
//         }

//         maxsq = Math.max(maxsq, x*x + y*y);
//       }
//       return maxsq;
//   }
// }
// --------------------------------------------------------7-9-2024------------------------------------------------------
// import java.util.*;

// class Solution {
//   class ListNode {
//     int val;
//     ListNode next;

//     public ListNode(int val, ListNode next) {
//       this.val = val;
//       this.next = next;
//     }

//     public ListNode(int val) {
//       this.val = val;
//     }
//   }

//   public ListNode modifiedList(int[] nums, ListNode head) {

//     ListNode dummy = new ListNode(-1);
//     dummy.next = head;
//     while (head != null) {

//       for (int i = 0; i < nums.length; i++) {
//         if (dummy.next.val == nums[i]) {
//           dummy.next = dummy.next.next;
//         }
//       }
//       head = dummy;
//       break;
//     }

//     return head;
//   }
// }
// ---------------------------------------------8-09-2024-------------------------------------------------------------------
// import java.util.*;
// class Solution {
//       class ListNode {
//     int val;
//     ListNode next;

//     public ListNode(int val, ListNode next) {
//       this.val = val;
//       this.next = next;
//     }

//     public ListNode(int val) {
//       this.val = val;
//     }
//   }

//     public int size(ListNode head){
//         int i = 0 ;
//         while (head != null) {
//             i++;
//             head = head.next;
//         }
//         return i;
//     }
//     public ArrayList<ArrayList<ListNode>>  splitListToParts(ListNode head, int k) {
//     //   
//     int n = size(head);
//     int total = n / k;
//     int carry = n % k;
//     ListNode currr = head;
//     ArrayList<ArrayList<ListNode>> result = new ArrayList<>();
//     while (head != null) {
//         ArrayList<ListNode> list = new ArrayList<>();
//        int totallength = total + (carry > 0 ? 1 : 0);
//         for (int i = 0; i < totallength; i++) {
//            if (currr != null) {
//              list.add(currr);
//              currr = currr.next;
//            }
//         }
//         result.add(list);
//     }
//     return result;
//     }
// }
// ----------------------12-sep--------------------
// import java.util.*;
// class Solution {
//   public int countConsistentStrings(String allowed, String[] words) {

//      int count = 0;
//     HashSet<Character> set = new HashSet<>();

//      for (Character character : allowed.toCharArray()) {
//         set.add(character);
//      }

//      for (String word : words) {
//       boolean  flag = false;
//       for (Character character : word.toCharArray()) {
//         if (!set.contains(character)) {
//           flag  = true;
//           break;
//         }
//       }
//       if (!flag) {
//         count++;
//       }
//      }

//      return count;
//   }
// }
// import java.util.*;
// class Solution {
//   public boolean iscontainone(int [][]grid){
//     int m = grid.length ;
//     int n = grid[0].length  ;

//     int left = 0 , right = n-1, top = 0 , bottom = m-1;

//     while (top <= bottom && left <= right) {

//       for (int i = left; i <=right; i++) {
//         if (grid[top][i] == 1) {
//           return false;
//         }
//       }
//       top++;

//       for (int  i = top;   i <=bottom;  i++) {
//         if (grid[i][right] == 1) {
//           return false;
//         }
//       }
//       right--;

//       if (top <= bottom) {
//         for (int i = right; i >=left; i--) {
//           if (grid[bottom][i] == 1) {
//             return false;
//           }
//         }
//         bottom--;
//       }

//       if (left <= right) {

//         for (int i = bottom; i >=top; i--) {
//           if (grid[left][i] == 1) {
//             return false;
//           }
//         }
//         left++;
//       }
//     }

//     return true;
//   }
//   public void dfs(int i , int  j , int[] row , int col[]    ,  int grid[][]){
//     grid[i][j] = 2;

//     int m = grid.length ;
//     int n = grid[0].length;

//     for (int k = 0; k < 4; k++) {
//       int nrow = i + row[k];
//       int ncol = j + col[k];

//       if (nrow >= 0 && nrow<n && ncol>=0 && ncol < m && grid[nrow][ncol] == 1 && grid[nrow][ncol] != 2) {
//         dfs(nrow, ncol, row, col, grid);  
//       }
//     }
//   } 
//   public int orangesRotting(int[][] grid) {

//     int count  = 0 ;
//     int row[] = {-1, 0 , +1 , 0};
//     int col[] = {0 , +1 , 0 , -1};

//      for (int i = 0; i < grid.length; i++) {
//       for (int j = 0; j < grid[0].length; j++) {
//         if (grid[i][j] == 1) {
//           count++;
//           dfs(i , j , row , col  , grid);
//         }
//       }
//      }

//      if (!iscontainone(grid)) {
//       return -1;
//      }

//      return count;
//   }
// }

// ---------------------------------------------14-sep-2024-------------------------------------------

// import java.util.*;

// import javax.naming.spi.DirStateFactory.Result;
// class Solution {
//   class Pair{
//     int maxAnd;
//     int maxAndlen;
//     public Pair(){
//       maxAnd = 0;
//       maxAndlen = 0;
//     }
//   }
//   public void helper(int[] nums , List<Integer> list , int i  , Pair curr){

//     if(i == nums.length){
//      if(!list.isEmpty()){
//        int store = list.get(0);

//       for(int j = 0 ; j< list.size(); j++){
//         store &= list.get(j);
//       }

//       if(store > curr.maxAnd){
//         curr.maxAnd = store;
//         curr.maxAndlen = list.size();
//       }
//       else if(store == curr.maxAnd){
//        curr.maxAndlen =  Math.max(curr.maxAndlen , list.size());
//       }

//      return ;
//      }
//     }

//     list.add(nums[i]);
//     helper(nums , list , i+1 , curr);
//     list.remove(list.size()-1);
//     helper(nums , list , i+1 , curr);
//   }
//   public int longestSubarray(int[] nums) {
//       List<Integer> list = new ArrayList<>();
//      Pair curr = new Pair();
//       helper(nums, list, 0, curr);

//       return curr.maxAndlen;
//   }
// }
// ---------------------------------15-09-2024------------------------------------------------------------------------------\

// class Solution {
//   public int findTheLongestSubstring(String s) {
//     int count = 0;
//     int i = 0;
//     String vowels = "aeiou";
//     while (i < s.length() && s.charAt(i) != vowels.charAt(i)) {

//     }
//   }
// }
// -----------------------------------------16-09-2024------------------------------------------------------------------------
// import java.util.*;
// class Solution {
//   public int findMinDifference(List<String> timePoints) {

//     List<Integer> list = new ArrayList<>();

//     for (String string : timePoints) {
//       String arr[] = string.split(":");

//       int hours = Integer.parseInt(arr[0]);
//       int min  = Integer.parseInt(arr[1]);

//       int totaoltime = hours * 60 + min;

//       list.add(totaoltime);
//     }

//     Collections.sort(list);
//      int min = Integer.MAX_VALUE;
//     for (int i = 1; i < list.size(); i++) {
//       min = Math.min(min, list.get(i)- list.get(i-1));
//     }

//     int firsttime = list.get(0);
//     int lasttime = list.get(list.size()-1);

//     int evaluatetime = (1440-lasttime) + firsttime;

//     return Math.min(min, evaluatetime);
//   }
// }

// import java.util.LinkedList;
// import java.util.Queue;

// /**
//  * helper
//  */
//  class helper {

//   class Contains{
//     int x;
//     int y;
//     public Contains(int x, int y){
//       this.x = x;
//       this.y = y;
//     }
//   }
//   class Pair{
//     Contains contains ;
//     int distance;
//     public Pair(Contains contains  , int distance)
//     {
//       this.contains  = contains;
//       this.distance = distance;
//     }
//   }
//   public void bfs(int row  , int col , boolean vis[][] ,  int[][] matrix){

//     int m = matrix.length;
//     int n = matrix[0].length;
//    vis[row][col] = true;
//    Queue<Pair> q = new LinkedList<>();
//     for (int i = 0; i < m; i++) { 
//       for (int j = 0; j < n; j++) {
//         if (matrix[i][j] == 1) {
//           q.add(new Pair(new Contains(i, j), 0));

//         }
//       }
//     }
//   int Srow[] = {-1 ,  0 , +1 ,  0};
//   int Scol[] = {0 , +1 , 0 , -1};
//    while (!q.isEmpty()) {
//     Pair curr = q.remove();
//     int r = curr.contains.x;
//     int c = curr.contains.y;
//     int distance = curr.distance;
//     matrix[r][c] =  distance;
//     for (int i = 0; i < 4; i++) {
//       int nrow = r + Srow[i];
//       int ncol = c + Scol[i];

//       if (matrix[nrow][ncol] >= 0 && matrix[nrow][ncol] < m && matrix[nrow][ncol] >= 0 && matrix[nrow][ncol] < n && matrix[nrow][ncol] != 1) {

//        vis[nrow][ncol] = true;
//        q.add(new Pair(new Contains(nrow, ncol), distance+1)); 
//       }
//     }
//    }

//   }
//    public int[][] DistanceofNearsetCell(int grid[][]){

//     int m = grid.length;
//     int n = grid[0].length;
//     int matrix[][] = new int[n][m];

//     for (int i = 0; i < m; i++) {
//         for (int j =0 ; j < n; j++) {
//           matrix[i][j]   = grid[i][j];     
//         }
//     }
//     boolean vis[][] = new boolean[m][n];
//     for (int i = 0; i < m; i++) {
//       for (int j = 0; j < n; j++) {
//         if (matrix[i][j] == 1) {
//           bfs(i , j , vis , matrix);
//         }
//       }
//     }
//     return matrix;
//    }
// }

// ----------------------------------------------17-09-2024----------------------------------------------------------

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;

// import javax.print.DocFlavor.STRING;

// class Solution {
//   public String[] uncommonFromSentences(String s1, String s2) {

//     String arr1[] = s1.split(" ");
//     String arr2[] = s2.split(" ");

//     HashMap<String , Integer> map = new HashMap<>();

//     for (String string : arr1) {
//       map.put(string, map.getOrDefault(string, 0)+1);
//     }
//     for (String string : arr2) {
//       map.put(string, map.getOrDefault(string, 0)+1);
//     }

//     List<String> list = new ArrayList<>();
//     for (String key : map.keySet()) {
//       if (map.get(key) == 1) {
//         list.add(key);
//       }
//     }

//     String result[] = new String[list.size()];
//     for (int i = 0; i < result.length; i++) {
//       result[i] = list.get(i);
//     }
//     return result;
//   }

// }

// -------------------------18-09-2024-------------------------------------------------------------

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;

// class Solution {
//   public String largestNumber(int[] nums) {
//       Comparator<String> comperator = (String s1 , String s2) ->{
//         String option1  = s1+s2;
//         String option2 = s2+s1;

//         return option2.compareTo(option1);
//       };

//       List<String> list = new ArrayList<>();

//       for (Integer integer  : nums) {
//         String str = integer.toString();
//         list.add(str);
//       }
//       StringBuilder src = new StringBuilder();

//       Collections.sort(list , comperator);

//      for (String string : list) {
//       src.append(string)  ;
//      }

//      return src.toString();
//   }
// }
// /---------------------------19-09-2024----------------------------------------------------------------------
// import java.util.ArrayList;
// import java.util.List;

// public class DifferentWaysToAddPrenthesis {
//     public static List<Integer> helper(String s){
//         List<Integer> list = new ArrayList<>();

//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
//                 List<Integer> left = helper(s.substring(0, i));
//                 List<Integer> right = helper(s.substring(i+1));

//                 for (Integer x : left) {
//                 for (Integer y : right) {
//                     if (s.charAt(i) == '+') {
//                         list.add(x+y);
//                     }
//                     else if (s.charAt(i) == '-') {
//                         list.add(x-y);
//                     }
//                     else{
//                         list.add(x*y);
//                     }
//                 }
//                 }
//             }
//         }

//         if (list.isEmpty()) {
//             list.add(Integer.parseInt(s));
//         }

//         return list;
//     }
//     public static void main(String[] args) {
//         String s  = "2*3-5*4";
//         List<Integer> list = helper(s);
//         for (int i = 0; i < list.size(); i++) {
//             System.out.print(list.get(i) + " ");
//         }
//     }
// }
// ------------------------------- 21-09--2024---------------------------------------------------
// import java.util.*;
// class Solution {
//     public boolean reportSpam(String[] message, String[] bannedWords) {

//         HashMap<String , Integer> map  = new HashMap<>();

//         for(String s : message){
//             map.put(s , map.getOrDefault(s , 0)+1);

//         }
//         int count = 0 ;
//         for(String s : bannedWords){
//         map.put(s, map.getOrDefault(map, 0)+1);
//         }

//         return count == 2 ? true : false;

//     }
// }
// ----------------------------------25-09-2024---------------------------------------------------------

// import java.util.HashMap;

// class Solution{
//     public int helper(String str1 , String str2){
//         int length  = 0 ;

//         for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
//             if (str1.charAt(i) == str2.charAt(i)) {
//                 length++;
//             }
//         }
//         return length;
//     }
//     //  this might be fail in large test case or give me error of tle

//     public int longestCommonPrefixLength(int arr1[] , int arr2[]){

//       HashMap<String , Integer> map = new HashMap<>();

//       for (int i : arr1) {

//         String str = Integer.toString(i);
//         String prefix = "";
//         for (char  ch : str.toCharArray()) {
//             prefix+=ch;
//             map.put(prefix, map.getOrDefault(prefix, 0)+1);
//         }
//       }

//       int maxlen = 0;

//       for (int i : arr2) {

//         String str = Integer.toString(i);
//         String prefix = "";
//         for (char ch : str.toCharArray()) {
//             prefix+=ch;
//             if (map.containsKey(prefix)) {

//                 maxlen = Math.max(maxlen, prefix.length());
//             }
//         }
//       }
//       return maxlen;
//     }
// }

// ----------------------------------------26-09-2024----------------------------------------------------------------------------

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// class Solution {
//     static class Pair {
//         int s;
//         int e;

//         public Pair(int s, int e) {
//             this.s = s;
//             this.e = e;
//         }
//     }

//     public static boolean[] book(int start[], int ending[]) {

//         boolean book[] = new boolean[start.length];
//         List<Pair> list = new ArrayList<>();
//         Collections.sort(list, (a, b) -> Integer.compare(a.e, b.e));

//         for (int i = 0; i < start.length; i++) {
//             list.add(new Pair(start[i], ending[i]));
//         }
//          int j = 0;
//        while (j < book.length) {
//         for (Pair pair : list) {
//             int st = pair.s;
//             int e = pair.e;

//             if (e <= st) {
//             book[j] = true;
//             }
//             else{
//                 book[j] = false;
//             }
//             j++;
//         }
//        }
//        return book;
//     }

//     public static void main(String args[]) {
//         int start[] = { 10, 15, 15 };
//         int ending[] = { 20, 25, 30 };

//         boolean arr[] = book(start, ending);

//        for (int i = 0; i < arr.length; i++) {
//         System.out.println(arr[i]);
//        }
//     }
// }

// --------------------------------------------19-09-2024------------------------------------------------------------------------
// question all the functions of deque using double linkedlist with 0(1) time complecity
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;

// class AllOne {

//     class Node{
//         int count;
//         List<String> list;
//         Node prev;
//         Node next;
//         public Node(int count){
//             this.count = count;
//             this.list = new ArrayList<>();
//             this.prev = null;
//             this.next = null;
//         }
//     }
//     private HashMap<String , Node> map; 
//     private Node head ;
//     private Node tail;
//     public AllOne() {
//        map = new HashMap<>();
//        head = new Node(0);
//        tail = new Node(0);
//        head.next = tail;
//        tail.prev = head;
//     }
//     public void addNode(Node head , int i){

//         // newNode.next = prevNode.next;
//         // newNode.prev = prevNode;
//         // prevNode.next.prev = newNode;
//         // prevNode.next = newNode;
//         // return newNode;

//         Node newNode = new Node(i);
//         newNode.next = head.next;
//         newNode.prev = head;
//         // head.next.prev = newNode;
//         head.next  = newNode;

//     }
//     public void removeNode(Node head){

//         head.prev.next = head.next;
//         head.next.prev = head.prev;
//     }
//     public void inc(String key) {

//         if (!map.containsKey(key)) {

//             if (head.next == tail && head.next.count != 1) {

//                 addNode(head , 1);

//                 head.next.list.add(key);
//                 map.put(key, head.next);
//             }
//         }else{
//             Node currNode = map.get(key);
//             int corrrNodecount = currNode.count;

//              if (currNode.next == tail && currNode.next.count != corrrNodecount+1) {

//                 addNode(currNode.next, corrrNodecount+1);

//                 currNode.next.list.add(key);

//                 currNode.list.remove(key);
//              }

//              if (currNode.list.isEmpty()) {
//                 removeNode(currNode);
//              }
//         }

//     }

//     public void dec(String key) {
//         Node currNode = map.get(key);
//         int count = currNode.count;

//         if (count == 1) {
//             map.remove(key);
//         }else{
//         //   1 - > 2 -> 3 - > 5     3  5 ko point kr rha hai toh apn ko 5 ka previous banana parega toh pehle  apn 4 ko banayeenge phir apn usko remove krwaenge or agr 4 hua toh phir kuch baat he nhi direct usko remove kr denge

//         if ( currNode.prev == head &&  currNode.prev.count != count -1 ) {

//             addNode(currNode.prev, count-1);
//         }

//         currNode.prev.list.add(key);
//         map.put(key, currNode.prev);
//         }
//         // 

//         if (currNode.list.isEmpty()) {
//             removeNode(currNode);
//         }
//     }

//     public String getMaxKey() {

//       return tail.prev == head ? "" : tail.prev.list.iterator().next();
//     }

//     public String getMinKey() {
//         return head.next == tail ? "" : head.next.list.iterator().next();
//     }
// }

// leeftcode -------------------1-08-2024--------------
// QUES-> CHECK IF ARRAY PAIR DIVISIBLE BY K 

// class solution{
//     public boolean ansInPair(int nums[] , int k){

//      int arr[] = new int[k];
//      for (int i : nums) {
//         int rem = i % k;
//         if (rem  < k) {
//             rem = rem + k;
//         }
//         arr[rem]++;
//      }

//      for (int i = 1; i < k; i++) {
//         if (arr[i] != arr[k - i]) {
//             return false;
//         }
//      }
//      return arr[0] % k == 0;
//     }
// }

// LETCODE RANK THE FOLLWOING ARRAY ACOORDING TO ITS NO ;
// Input: arr = [37,12,28,9,100,56,80,5,12]
// Output: [5,3,4,2,8,6,7,1,3]

// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// class Solution {
//     public int[] arrayRankTransform(int[] arr) {

//         int[] nums = arr.clone();
//         Arrays.sort(nums);

//         Map<Integer , Integer> map = new HashMap<>();
//         int rank = 1;
//         for (Integer num : nums) {
//             if (!map.containsKey(num)) {
//                 map.put(num, rank);
//             }
//         }
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = map.get(arr[i]);
//         }

//         return arr;
//     }
// }
// import java.util.*;
// class Solution {
//     public List<List<Integer>> createGraph(int [][]graph , int V){

//       List<List<Integer>> adj = new ArrayList<>();

//       for(int i= 0 ; i < V ; i++){
//         adj.add(new ArrayList<>());
//       }

//        for(int[] edge : graph){
//         int u = edge[0];
//         int v = edge[1];

//         adj.get(u).add(v);
//         adj.get(v).add(u);
//        }

//       return adj;
//     }
//     public List<List<Integer>> getAncestors(int n, int[][] edges) {
//       int V = edges.length;
//      List<List<Integer>> adj = createGraph(edges , V);   

//      List<List<Integer>> adjRev = new ArrayList<>();
//      for(int i = 0 ; i < V ; i++){
//       adjRev.add(new ArrayList<>());
//      }

//      List<HashSet<Integer>> dup = new ArrayList<>();
//      for(int i = 0 ; i < V ; i++){
//       dup.add(new HashSet<>());
//      }

//       int inorder[] =new int[V];

//       for (int i = 0; i < V; i++) {
//         for (Integer integer : adj.get(i)) {
//             inorder[integer]++;
//         }
//       }

//       Queue<Integer> q= new LinkedList<>();
//       for (int i = 0; i < V; i++) {
//         if (inorder[i] == 0) {
//             q.add(i);
//         }
//       }

//       while (!q.isEmpty()) {
//         int curr  = q.remove();
//         for (Integer neighbour : adj.get(curr)) {
//             dup.get(neighbour).add(curr);
//             adjRev.get(neighbour).add(curr);

//             for (Integer ancestor : adjRev.get(curr)) {
//                 if (!dup.get(neighbour).add(ancestor)) {
//                      dup.get(neighbour).add(ancestor);
//                      adjRev.get(neighbour).add(ancestor);
//                 }
//             }

//             inorder[neighbour]--;
//             if (inorder[neighbour] == 0) {
//                 q.add(neighbour);
//             }
//         }
//       }
//       for (int i = 0; i < V; i++) {
//         adjRev.get(i).sort(null); // Sort each list
//     }

//     return adjRev;

//     }
// }

// -------------------------------------------------LEETCODE 3-OCT-2024----------------------------------------------------
// Input: nums = [3,1,4,2], p = 6
// Output: 1
// Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
// Example 2:

// Input: nums = [6,3,5,2], p = 9
// Output: 2
// Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
// import java.util.*;
// class Solution {
//   public int minSubarray(int[] nums, int p) {

//     int target = 0;
//     for (Integer num : nums) {
//       target = (target + num) % p;
//     }

//     int res = nums.length;
//     int curr = 0 ;
//     Map<Integer , Integer> map = new HashMap<>();
//     for (int i = 0; i < nums.length; i++) {
//       curr = (curr + nums[i]) % p ;

//       int prev = (curr  - target + p ) % p ;

//       if (map.containsKey(prev)) {
//         res = Math.min(res, map.get(prev));
//       }

//       map.put(curr, i);
//     }

//     return res < nums.length ? res : -1;
//   }
// }
// import java.util.*;
// class Solution {
//   class Pair{
//       int s;
//       int e;
//       public Pair(int s , int e)
//           this.s = s;
//           this.e = e;
//   }
//   public boolean helper(int start ,int end){

//   }
//   public long dividePlayers(int[] skill) {

//       Arrays.sort(skill);
//       int left = 0 ;

//       int right =  skill.length-1;
//       List<Pair> list = new ArrayList<>();

//       while(left < right)
//       {
//        list.add(new Pair(skill[left] , skill[right]))

//            left++;
//            right--;
//       }
//       long result = 0;
//      for (Pair pair : list) {
//       int s = pair.s;
//       int e = pair.e;

//      }
//   }
// }

// LEETCODE QUESTION ON OCTOBER 5;
// ISME APNKO KRNA HAI KI S2  S1 ELEMENT LAGATAR CONSIT KRTI HAI TOH TRUE NHI TOH FALSE;
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
// import java.util.*;
// class Solution{
//   public boolean checkInclusion(String s1  , String s2){
//     HashMap<Character , Integer> map1 = new HashMap<>();

//     for (int i = 0; i < s1.length(); i++) {
//       map1.put(s1.charAt(i), map.getOrDefault())
//     }
//   }
// }

// leetcode daillyl question 8-10-24
// import java.util.*;
// class Solution {
//   public int minLength(String s) {

//       Stack<Character> st = new Stack<>();

//       for(int i = 0 ; i < s.length(); i++){
//         if(st.isEmpty()){
//           st.push(s.charAt(i));

//         }
//         else{
//           if((st.peek() == 'A' && s.charAt(i) == 'B') && (st.peek() == 'C' && s.charAt(i) == 'D'))
//           {
//          st.pop() ;
//           }
//           else{
//             st.push(s.charAt(i));
//           }
//         }
//       }

//       return st.size();
//   }
// }

// LEETCODE DAILY 7-10-24
// Input: sentence1 = "My name is Haley", sentence2 = "My Haley"

// Output: true

// Explanation:

// sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// class Solution {
//   public boolean areSentencesSimilar(String sentence1, String sentence2) {

//     if (sentence1.length() < sentence2.length()){
//       String temp = sentence1;
//       sentence1 = sentence2;
//       sentence2 = temp;
//     }

//     List<String> list1 = new ArrayList<>();
//     List<String> list2 = new ArrayList<>();

//     list1 = Arrays.asList(sentence1.split(" "));
//     list2 = Arrays.asList(sentence2.split(" "));

//     int i = 0   ; int j = list1.size() - 1;
//     int k = 0 ; int l = list2.size()   - 1  ;

//     while (i < j && list1.get(i).equals(list2.get(k))){
//       i++;
//       k++;
//     }

//     while(l>=k && list1.get(j).equals(list2.get(l))){
//       j--;
//       l--;
//     }

//     return l>=k;
//   }
// }
// 10/10/24
// import java.util.Stack;

// class Solution{
//   public int maxWidthRamp(int[] nums){
//     Stack<Integer> stack = new Stack<>();
//     for (int i = 0; i < nums.length; i++) {
//       if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
//         stack.push(i);
//       }
//     }
//     int max = Integer.MIN_VALUE;

//     for(int j = nums.length - 1 ; j>=0; j--){
//       while(stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
//         max = Math.max(max, j - stack.pop());
//       }
//     }
//     return max;
//   }
// }
// -----------------------------11-10-2024---------------------------------------------------------

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.PriorityQueue;

// class Solution {

//   class Pair{
//     int leaveingtime;
//     int seats;
//     public Pair(int leaveingtime , int seats){
//      this.leaveingtime = leaveingtime;
//      this.seats = seats;
//     }
//   }
// 	public int smallestChair(int[][] times, int targetFriend) {

//     int n = times.length;
//     int []order = new int[n];
//     PriorityQueue<Pair> pq = new PriorityQueue<>((a , b)-> a.leaveingtime - b.leaveingtime);
//     PriorityQueue<Integer> emptyseats = new PriorityQueue<>();
//     for (int i = 0; i < order.length; i++) {
//       order[i] = i;
//     }
//     for (int i = 0; i < n; i++) {
//         emptyseats.add(i);
//     }

//     for (Integer i  : order) {

//       int arrivalTime = times[i][0];
//       int leavingTime = times[i][1];

//       while (!pq.isEmpty()&& pq.peek().seats<= arrivalTime) {
//         emptyseats.add(pq.poll().seats);
//       }

//       int seats = emptyseats.poll();

//       if (targetFriend == i) {
//         return seats;
//       }

//       pq.add(new Pair(leavingTime, seats));
//     }

//     return -1;
// 	}
// }

// ---------------------------------------12-10-2024------------------------

// import java.util.Arrays;
// import java.util.PriorityQueue;

// class Solution {
//   class Pair{
//     int x;
//     int y;
//     public Pair(int x ,int y){
//       this.x = x;
//       this.y = y;
//     }
//   }
//   public int minGroups(int[][] intervals) {

//    Arrays.sort(intervals , (a , b)->a[0]-b[0]);
//    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.x - b.x);

//    for (int i = 0; i < intervals.length; i++) {
//     int start = intervals[i][0];
//     int end = intervals[i][1];

//     if (!pq.isEmpty() && pq.peek().y < start) {
//       pq.poll();
//     }

//     pq.add(new Pair(start, end));
//    }

//    return pq.size();
//   }
// }
// -----------------13-10-24-------------------------------------------------------------------
// import java.util.*;
// class Solution {

//   class Pair{
//     int row;
//     int col;
//     int data;
//     public Pair(int row ,  int col , int data){
//       this.row = row;
//       this.col = col;
//       this.data = data;
//     }
//   }

//   public int[] smallestRange(List<List<Integer>> nums) {

//       int max = Integer.MIN_VALUE;
//       int min = Integer.MAX_VALUE;

//       int n = nums.size();
//       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.data - b.data);
//       for(int i = 0 ; i < n ; i++){
//         int element = nums.get(i).get(0);

//         max =Math.max(max, element);
//         min = Math.min(min, element);

//         pq.add(new Pair(i, 0, element));
//       }

//       int start = min;
//       int end = max;
//       while (!pq.isEmpty()) {
//         Pair curr = pq.remove();
//         min = curr.data;

//         if (max - min < end - start) {
//          start = min;
//          end = max;
//         }

//         if (curr.col < n) {
//           max = Math.max(nums.get(curr.row).get(curr.col+1), max);
//           pq.add(new Pair(curr.row, curr.col+1, nums.get(curr.row).get(curr.col+1)));
//         }
//         else{
//           break;
//         }
//       }

//       return new int[]{start , end};
//   }
// }

// ---------------------14-10-24----------------------------------------------------------------------------
// import java.util.*;
// class Solution {
//   public long maxKelements(int[] nums, int k) {

//     long ans = 0;

//     while (k > 0) {

//       Arrays.sort(nums);
//       ans += nums[nums.length - 1];
//       if (nums[nums.length - 1] % 3 != 0) {
//         nums[nums.length - 1] = (nums[nums.length - 1] / 3) + 1;
//       } else {

//         nums[nums.length - 1] = nums[nums.length - 1] / 3;
//       }
//       k--;
//     }

//     return ans;
//   }
// }
// ------------------------------------------------15-10-2024----------------------------------------------
// class Solution {
//   public long minimumSteps(String s) {
//       long swap = 0;
//       int black = 0; 
//       for (int i = 0; i < s.length(); i++) {
//           if (s.charAt(i) == '0') 
//               swap += (long) black; 
//           else
//               black++; 
//       }
//       return swap;
//   }
// }
// -----------------------------------------------16-10-2024---------------------------------------------

// import java.util.HashMap;
// import java.util.Map;

// class Solution {
//     public String longestDiverseString(int a, int b, int c) {

//         Map<Integer, Character> map = new HashMap<>();

//         map.put(a, 'a');
//         map.put(b, 'b');
//         map.put(c, 'c');

//         int min1 = Math.min(a, b);
//         int min2 = Math.min(b, c);

//         int max = Math.max(Math.max(a, b), c);
//         StringBuilder src = new StringBuilder();
//         while (min1 > 0 && min2 > 0) {

//             int i = 2;
//             while (i > 0) {
//                 src.append(map.get(max));
//                 i--;
//             }
//             if (min1 > 0) {
//                 src.append(map.get(min1));
//                 min1--;
//             } else if (min2 > 0) {
//                 src.append(map.get(min2));
//                 min2--;
//             }
//         }

//         return src.toString();
//     }
// }
// ------------------------------------------------17-10-24----------------------------------------------
// class Solution {
//     public int maximumSwap(int num) {

//         String str = Integer.toString(num);
//         StringBuilder src = new StringBuilder(str);
//         int max  = 0;
//         for (int i = 0; i < src.length(); i++) {
//             for (int j = i+1; j < src.length(); j++) {

//                 StringBuilder temp = new StringBuilder(src);
//                 temp.setCharAt(i, temp.charAt(j));
//                 temp.setCharAt(j, temp.charAt(i));

//                 int currnum = Integer.parseInt(temp.toString());
//                 max = Math.max(max, currnum);
//             }

//         }
//         return max;
//     }
// }
// ------------------------------------------------18-10-24----------------------------------------------
// import java.util.*;
// class Solution {
//     public  void helper(int[] nums , int i , List<Integer> list , List<List<Integer>> result){
//         if (i  == nums.length) {
//              result.add(new ArrayList<>());
//             return;     
//         }

//         list.add(nums[i]);
//         helper(nums, i+1, list, result);
//         list.remove(list.size()-1);
//         helper(nums, i+1, list, result);
//     }
//     public int countMaxOrSubsets(int[] nums) {
//         List<Integer> list = new ArrayList<>();
//         List<List<Integer>> result = new ArrayList<>();
//         int ansmax = 0;
//         int count = 0;
//         helper(nums, 0, list, result);

//         for (List<Integer> list2 : result) {
//             int max = 0;
//             for (int i = 0; i < list2.size(); i++) {
//                 max  = max | list2.get(i);
//             }

//              if (max > ansmax) {
//                 ansmax = max;
//                 count = 1;
//              }
//              else if (max == ansmax) {
//                 count++;
//              }
//         }

//        return count;
//     }
// }
// ---------------------------------------19-10-24----------------------------------------------

// class Solution {
//     public char printKthBit(int n, int k) {
//         if (n == 0) {
//             return '0';
//         }

//         int len = (1 << n) - 1; // to find out the length of Sn string

//         int mid = (len / 2) + 1;

//         if (k == mid) {
//             return '1';
//         }

//         if (k < mid) {
//             return printKthBit(n-1, k);
//         }

//         return printKthBit(n, len - k + 1) == '0' ? '1' : '0';
//     }
// }
// ------------------------------------20-10-2024-----------------------------------------

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Stack;

// class Solution{
//     public char helper(char op , List<Character> list){
//         if (op == '!') {
//           return  list.get(0)  == 't' ? 'f' : 't'; 

//         }

//         if (op == '&') {
//             return list.stream().anyMatch( ch -> ch == 'f') ? 'f' : 't';
//         }

//         if (op == '|') {
//             return list.stream().anyMatch(ch -> ch =='t') ? 't' : 'f';
//         }

//         return 't';
//     }
//     public boolean parsingExp(String s){
//          Stack<Character> stack = new Stack<>();
//          List<Character> list = new ArrayList<>();
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == ')') {
//                 while (stack.pop() != '(') {
//                     list.add(stack.pop());
//                 }
//                 stack.pop();
//                 char op = stack.pop();

//                 stack.push(helper(op, list));
//             }else{
//                 stack.push(s.charAt(i));
//             }
//         }

//         return stack.peek() == 't' ;
//     }
// }

// ---------------------------------------21-10-2024----------------------------------------------------------

// import java.util.HashSet;
// import java.util.Set;

// class Solution {
//     public int helper(String s , Set<String> set , int start){
//       if(start == s.length())
//       return 0 ;

//       int maxlen = 0;

//       for(int i = start ; i<s.length(); i++){
//         String sub = s.substring(start  , i + 1);

//         if(!set.contains(sub)){
//             set.add(sub);

//             int len = 1 + helper(s , set , i+1);

//             maxlen = Math.max(len , maxlen);

//             set.remove(sub);
//         }
//       }
//       return maxlen;
//     }
//     public int maxUniqueSplit(String s) {

//         Set<String> set = new HashSet<>();
//         return helper(s , set , 0);
//     }
// }
// ---------------------------------------25-10-2024----------------------------------------------------------
// import java.util.*;

// class Solution {
//     class Node {

//         int val;
//         Node left;
//         Node right;

//         public Node(int val) {
//             this.val = val;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     public Node replaceValueInTree(Node root) {
//         // first calculate levelsum then calculate siblinge sum

//         List<Integer> list = new ArrayList<>();
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while (!q.isEmpty()) {
//             int size = q.size();
//             int sum = 0;
//             for (int i = 0; i < size; i++) {
//                 Node curr = q.remove();

//                 sum += curr.val;

//                 if (curr.left != null) {
//                     q.add(curr.left);
//                 }
//                 if (curr.right != null) {
//                     q.add(curr.right);
//                 }
//             }
//             list.add(sum);
//         }
//         q.add(root);
//         root.val = 0;
//         int level = 0;
//         while (!q.isEmpty()) {
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 Node curr = q.remove();

//                 int totalsum = (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);

//                 if (curr.left != null) {
//                     curr.left.val = list.get(level) - totalsum;
//                 }
//                 if (curr.right != null) {
//                     curr.right.val = list.get(level) - totalsum;
//                 }
//             }
//             level++;
//         }

//         return root;
//     }
// }
// ---------------------------------------25-10-2024----------------------------------------------------------
// import java.util.*;
// class Solution {
// public List<String> removeSubfolders(String[] folder) {

// List<String> list = new ArrayList<>();

// list.add(folder[0]);
// String prev = folder[0];
// for (int i = 1; i < folder.length; i++) {
// if (folder[i].startsWith(prev + "/")) {
// prev = folder[i];
// list.add(prev);
// }
// }

// return list;
// }
// }

// ---------------------------------------28-10-2024----------ca------------------------------------------------

//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//class Solution{
//    public int  squareContainArray(int nums[]){
//
//        int res = -1;
//
//        Map<Integer , Integer> map = new HashMap<>();
//
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//
//            int sqrt = (int)Math.sqrt(nums[i]);
//
//            if (sqrt * sqrt == nums[i]  && map.containsKey(sqrt)) {
//
//                map.put(sqrt, map.get(sqrt)+1);
//                res = Math.max(res, map.get(sqrt));
//            }else{
//                map.put(nums[i], 1) ;
//            }
//        }
//
//        return res;
//    }
//}
// ----------------------------NOVEMBER---------------------------------------------------------------
// ---------------------------------1-11-2024-----------------------------------------------------------
// class Solution {
//     public boolean helper(String src){
//         for (int i = 0; i < src.length(); i++) {
//            if (src.chars().allMatch(ch -> ch == src.charAt(0)))
//                return true;
//         }
//         return false;
//     }
//     public String makeFancyString(String s) {
//         //leeetcode ->leetcode;

//       StringBuilder src = new StringBuilder(s);

//         for (int i = 2; i < src.length(); i++) {
//            String sub = src.substring(i-2 , i);
//            if (helper(sub)){
//                src.deleteCharAt(i);
//            }
//         }
//         return src.toString();
//     }
// }
// -------------------------------------2-10-2024---------------------------------------------------------

// class Solution {
//     public boolean isUppercase(String str){
//         for (int i = 0; i < str.length(); i++) {
//             if (!Character.isUpperCase(str.charAt(i))) {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public boolean isCircularSentence(String sentence) {
//         String arr[] = sentence.split(" ");

//         if(arr.length == 1){
//             String s = arr[0];
//             if(s.charAt(0) != s.charAt(s.length()-1))return false;
//         }

//         for(int i = 1 ; i < arr.length; i++){
//             String str1 = arr[i-1];
//             String str2 = arr[i];

//             if(str1.charAt(str1.length()-1) != str2.charAt(0) )return false;

//             if (isUppercase(str1)) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }
// -------------------------------------4-10-2024---------------------------------------------------------
// import java.util.*;
// class Solution {
//     public String compressedString(String word) {

//         Map<Character , Integer> map= new HashMap<>();

//         for(char ch : word.toCharArray()){
//             if(map.get(ch) < 9){
//                 map.put(ch , map.getOrDefault(ch , 0)+1);
//             }
//         }
//        String str = "";
//         boolean flag = true;
//         for(Character key : map.keySet()){

//            if(flag){
//             str+=map.get(key);
//            }else{
//            str+=key;
//            }
//            flag = !flag;
//         }

//        return str;
//     }
// }

// -------------------------------------5-10-2024---------------------------------------------------------
// import java.util.*;

// class Solution {

//     public int countOnes(String str) {

//         int count = 0;
//         for (int i = 0; i < str.length(); i++) {
//             if (str.charAt(i) == '1') {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public boolean canSortArray(int[] nums) {

//         int temp[] = nums;
//         Arrays.sort(temp);

//         int i = 0;

//         while (i < nums.length) {

//                 if (nums[i] > nums[i+1]) {

//                     String firsBi = Integer.toBinaryString(nums[i]);
//                     String SecondBi = Integer.toBinaryString(nums[i+1]);

//                     int fistcount = countOnes(firsBi);
//                     int secondCount = countOnes(SecondBi);

//                     if (fistcount == secondCount) {
//                         int curr = nums[i];
//                         nums[i] = nums[i+1];
//                         nums[i+1] = curr;
//                          i  = 0;
//                     }else{
//                         return false;
//                     }

//                     i++;

//                 }

//         }

//         return temp == nums;
//     }
// }
// --------------------------7-10-2024------------------------------------------------------------------------
// class Solution{
//     public int countSameBitElem(int[]nums){

//         int max    = Integer.MIN_VALUE;

//         for (int i = 0; i < 32; i++) {
//             int count = 0;

//             for(Integer num : nums){
//                 if ((num & (1 << i)) != 0) {
//                     count++;
//                 }
//             }

//             max = Math.max(max, count);

//         }
//         return max;
//     }
// }
// --------------------------9-10-2024------------------------------------------------------------------------

// class Solution{
//     public long minEnd(int n , int x){
//         int result = x;
//         int remaining = n-1;
//         int postion = 1;

//         while (remaining != 0) {
//             if ((x & 1) == 0) {
//                 result|= (remaining & 1) * postion;
//                 remaining >>= 1;
//             }
//             postion <<=1;
//         }
//         return result;
//     }
// }
// --------------------------9-10-2024------------------------------------------------------------------------
// final class Solution{
//     public boolean isPrime(int n){
//         if (n <= 2) {
//              return true;
//         }
//         for (int i = 2; i <= Math.sqrt(n); i++) {

//             if (i % n == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public int getMaxPrime(int n){
//         if (n == 0) {
//             return -1;
//         }

//         while (n >0) {
//             if (isPrime(n)) {
//                 return n;
//             }
//             n--;
//         }
//         return -1;
//     }
//     public boolean primeSubOperation(int[] nums){

//          for (int i = 0; i < nums.length; i++) {

//             int val  = i > 0 ? nums[i-1] : 0 ;

//             int prime = getMaxPrime(nums[i] - 1 - val);

//             if (prime != -1) {
//               nums[i]-=prime;

//               if (i>0 && nums[i] <= nums[i-1]) {
//                 return false;

//               }
//             }
//          }

//          return true;
//     }
// }
// --------------------------12-10-2024------------------------------------------------------------------------
// import java.util.Arrays;
// import java.util.PriorityQueue;

// class Solution {
//     class Items {
//         int price;
//         int beauty;

//         public Items(int price, int beauty) {
//             this.price = price;
//             this.beauty = beauty;
//         }
//     }

//     public int[] maxBeauty(int[][] items, int[] queires) {

//         Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
//         PriorityQueue<Items> pq = new PriorityQueue<>((a, b) -> b.beauty - a.beauty);

//         int qI[][] = new int[items.length][2];

//         for (int i = 0; i < qI.length; i++) {
//             qI[i][0] = queires[i];
//             qI[i][1] = i;
//         }
//         int i = 0;
//         int value = 0;
//         Arrays.sort(qI, (a, b) -> Integer.compare(a[0], b[0]));
//         for (int[] q : qI) {
//             int qindex = q[1];
//             int qprice = q[0];
//             while (i < items.length && items[i][0] <= qprice) {
//                 pq.add(new Items(items[i][0], items[i][1]));
//                 i++;

//             }
//             if (!pq.isEmpty()) {
//                 value = Math.max(value, pq.peek().beauty);
//             }
//             queires[qindex] = value;
//         }
//         return queires;
//     }
// }
// --------------------------13-10-2024------------------------------------------------------------------------

// import java.util.Arrays;

// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         long count = 0 ;
//         Arrays.sort(nums);

//         for (int i = 0; i < nums.length; i++) {
//             int start = i+1;
//             int end = nums.length-1;
//             while (start <= end) {
//                 int mid = (end - start)/2 + start;
//                 if (nums[i] + nums[mid] < lower) {
//                     start = mid + 1;
//                 }else{
//                     end = mid - 1;
//                 }
//             }
//             int left = start;

//             start = i + 1;
//             end = nums.length - 1;
//             while (start <= end) {
//                 int mid = (end - start)/2 + start;
//                 if (nums[i] + nums[mid] > upper) {
//                     end  = mid - 1;
//                 }else{
//                     start =  mid + 1;
//                 }
//             }
//             int right = end;

//             if (left <= right) {
//                 count+=right - left + 1;
//             }
//         }
//        return count;
//     }
// }

// --------------------------16-10-2024------------------------------------------------------------------------
// class Solution {
//     public int findLengthOfShortestSubarray(int[] arr) {
//         int n = arr.length;
//         int left = 0;
//         int right = n-1;
//         while (left + 1 < n && arr[left] <= arr[left+1]) {
//             left++;
//         }
//         while (right - 1 >=0 && arr[right] >= arr[right-1]) {
//             right--;
//         }
//         int ans = Math.min(n - left -  1 , right);

//         int i = 0 ; 
//         int j = right;

//         while (i < left && j < n) {
//             if(arr[i] <= arr[j]) {
//                 ans = Math.min(ans , j - i - 1);
//                 i++;
//             }else{
//                 j++;
//             }
//         }
//         return ans;
//     }
// }

// import java.util.Arrays;

// class Solution {
//     public boolean isconsecutive(int left, int right, int arr[]) {

//         for (int i = left; i < right; i++) {
//             if (arr[i] > arr[i + 1]) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public int maxvalue(int left, int right, int arr[]) {
//         int max = Integer.MIN_VALUE;
//         for (int i = left; i <= right; i++) {

//             max = Math.max(arr[i], max);
//         }
//         return max;
//     }

//     public int[] resultsArray(int[] nums, int k) {

//         int n = nums.length;
//         int result[] = new int[n - k + 1];

//         int left = 0;
//         int right = k - 1;
//         int j = 0;
//         int i = 0;
//         while (right < nums.length && i < result.length) {

//             int arr[] = Arrays.copyOfRange(nums, left, right);
//             if (isconsecutive(left, right, arr)) {
//                 result[i] = maxvalue(left, right, arr);
//             } else {
//                 result[i] = -1;
//             }
//             i++;
//             left++;
//             right++;
//         }

//         return result;
//     }
// }
// --------------------------18-10-2024------------------------------------------------------------------------
// class Solution{
//     public int[] getAnNo(int code[] , int k){

//         int arr[] = new int[code.length];
//         int n = code.length;
//         if (k == 0) {
//             return arr;
//         }

//         for (int i = 0; i < code.length; i++) {
//             int sum = 0;
//          if (k > 0) {
//            for (int j = 1; j <=k; j++) {
//             sum +=code[(i+j)%n];
//            }
//          }else{
//             for (int j = 2; j <=-k; j++) {
//              sum+=code[(i-j+n) %n];
//             }
//          }
//          arr[i] = sum;
//         }
//         return arr;
//     }                        
// }

// --------------------------18-10-2024------------------------------------------------------------------------

// import java.util.HashSet;

// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
        
//         HashSet<Integer> set = new HashSet<>();
//         int left = 0;
//         long curr = 0;
//         long max = 0;
//         for (int right = 0; right < nums.length; right++) {
            
//            while (set.contains(nums[right]) || set.size() >= k) {
//             set.remove(nums[left]);
//             curr-=nums[left];
//             left--;
//            }
//             set.add(nums[right]);
//             curr+=nums[right];
//             if (set.size() >= k) {
//                 max  = Math.max(max, curr);
//             }
//         }

//         return max;
//     }
// }

// import java.util.HashMap;
// import java.util.Map;

// class Solution{
//     public int maxFliprow(int[][]matrix){
//         Map<String , Integer> map = new HashMap<>();
//         int maxcount = 0;
//         for (int[] row : matrix) {
            
//             StringBuilder Original  = new StringBuilder();
//             StringBuilder duplicate = new StringBuilder();

//             for (int i = 0; i < row.length; i++) {
//                 Original.append(row[i]);
//                 duplicate.append(1 - row[i]);
//             }

//             String o = Original.toString();
//             String f = duplicate.toString();

//             map.put(o, map.getOrDefault(o, 0)+1);
//             map.put(f, map.getOrDefault(f, 0)+1);


//         }

//          for(Integer key : map.values())
//          {
//             maxcount = Math.max(maxcount, key);
//          }
         
//          return maxcount;
//     }
// }

import java.util.ArrayList;
import java.util.List;

class Solution {
//    public String addSpaces(String s, int[] spaces) {
//        StringBuilder src = new StringBuilder(s);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < spaces.length; i++) {
//            list.add(spaces[i]);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if ( i == spaces[i]) {
//                src.setCharAt(i, ' ');
//                list.remove(spaces[i]);
//            }
//        }
//        if (!list.isEmpty()) {
//            src.setCharAt(s.length(), ' ');
//        }
//        return src.toString();
//    }

    public int help(int i , int j , int nums[]){
         int sum = 0;
        for (int k = i; k <j; k++) {
            sum+=nums[k];
        }

        return sum;
    }
    public int maxAscendingSum(int[] nums) {

        int j = 0;
        int len = nums.length;

        int left = 0;
        int right = 1;

//        10 20 30 5 10 50
        while(j < len){

           if(nums[right] > nums[left]){
                 left++;
                 right++;
           }else {
               sum = help(j, right, nums);
               j = right;
           }
         ans = Math.max(ans , sum);
           sum = 0 ;
        }
    }

    
    
}