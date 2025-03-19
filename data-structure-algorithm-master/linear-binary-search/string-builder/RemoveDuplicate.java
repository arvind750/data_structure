import java.util.*;
class DuplicateString{
    public String str(String a){
        StringBuilder sb=new StringBuilder();
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<a.length();i++){
            if(!hs.contains(a.charAt(i))){
                sb.append(a.charAt(i));
                hs.add(a.charAt(i));
            }
            else{
                continue;
            }
        }
        return sb.toString();
    }
}
public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        DuplicateString obj=new DuplicateString();
        System.out.print(obj.str(a));
        sc.close();
    }
}
