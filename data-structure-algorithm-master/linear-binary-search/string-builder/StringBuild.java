import java.util.*;
class Reverse{
    public String str(String a){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<a.length();i++){
            sb.append(a.charAt(i));
        }
        sb.reverse();
        return sb.toString();
    }
}

public class StringBuild {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        Reverse obj=new Reverse();
        System.out.print(obj.str(a));
        sc.close();
    }
}
