import java.util.List;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Sentence ko words mein split karna
        String[] words = sentence.split(" ");

        // Har shabd par iterate karna
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String replacement = word;

            // Dictionary ke har word ko check karna shortest root dhoondhne ke liye
            for (String root : dictionary) {
                if (isPrefix(root, word) && root.length() < replacement.length()) {
                    replacement = root;
                }
            }

            // Shabd ko shortest root se replace karna
            words[i] = replacement;
        }

        // Words ko dobara sentence mein join karna
        return String.join(" ", words);
    }

    // Helper method jo check karta hai agar ek string doosre ki prefix hai
    private boolean isPrefix(String prefix, String word) {
        if (prefix.length() > word.length()) {
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}