class Solution {
    public  static  int countBinarySubstrings(String s) {
    String str[] = new String[s.length()];
    for (int i = 0; i <s.length(); i++) {
    for (int j = i; j < s.length(); j++) {
     str[i] = s.substring(i, j);
    }
    }
     return str.length;
    }
    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(countBinarySubstrings(s));
    }
}