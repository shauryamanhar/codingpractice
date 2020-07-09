package com.shaurya.deshawquestion;
import java.util.*;
public class SweetestChocolate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sweet[] = new int[n];
        int bitter[] = new int[n];
        String name[] = new String[n];
        for(int i=0;i<n;i++){
            sweet[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            bitter[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            name[i]=sc.next();
        }
        final int q =  sc.nextInt();
        final int query[] = new int[q];
        for(int i=0;i<q;i++){
            query[i]=sc.nextInt();
        }
        //input end
        solve(n, sweet, bitter, name, q, query);
        sc.close();
    }

    static void solve(int n,int s[],int b[],String name[],int q,int query[]){
        ArrayList<Choco> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Choco(s[i], b[i], name[i]));
        }
        Collections.sort(list);
        Collections.reverse(list);
        // for(Choco c:list){
        //     System.out.println(c.s+" "+c.b+" "+c.name);
        // }
        for(int i=0;i<q;i++){
            System.out.print(list.get(query[i]-1).name+" ");
        }
    }
    static class Choco implements Comparable<Choco>{
        int s;int b;
        String name;
        public Choco(final int s,final int b,final String name){
            this.s=s;
            this.b=b;
            this.name=name;
        }

        @Override
        public int compareTo(final Choco o) {
            if(s>o.s){
                return 1;
            }else if(s<o.s){
                return -1;
            }else{
                if(b>o.b){
                    return -1;
                }else if(b<o.b){
                    return 1;
                }else{
                    return -name.compareTo(o.name);
                }
            }
        }
    }
}


/*

6
2 3 7 3 2 2
5 4 1 4 9 3
a b c d e f
6
3 5 1 2 6 4

output
d a c b e f


*/
