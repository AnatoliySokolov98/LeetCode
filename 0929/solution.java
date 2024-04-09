import java.util.Set;
import java.util.HashSet;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniques = new HashSet<>();
        for(String email: emails) {
           StringBuilder builder = new StringBuilder();
           for(int i = 0; i < email.length(); i ++) {
             if (email.charAt(i) == '.') continue;
             if (email.charAt(i) == '+') {
                while (email.charAt(i) != '@') {
                    i++;
                }
                builder.append(email.substring(i));
                break;
             }
             else if (email.charAt(i) == '@') {
                builder.append(email.substring(i));
                break;
             }
             else {
                builder.append(email.charAt(i));
             } 
           }
           uniques.add(builder.toString()); 
        }
        System.out.println(uniques);
        return uniques.size();
    }
}