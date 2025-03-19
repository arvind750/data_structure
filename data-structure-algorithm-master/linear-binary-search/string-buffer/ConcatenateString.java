import java.util.*;
class ArrayString{
    public String concat(String a[]){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<a.length;i++){
            sb.append(a[i]);
        }
        return sb.toString();
    }
}
public class ConcatenateString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        ArrayString obj=new ArrayString();
        System.out.print(obj.concat(arr));
        sc.close();
    }
}
