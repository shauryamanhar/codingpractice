package com.shaurya.general;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<Number> set = new HashSet<Number>();
        set.add(new Number(1,2));
        set.add(new Number(1,2));
        System.out.println(set.size());
    }    
    
    static class Number{
        int a,b;
        Number(int a,int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public boolean equals(Object o) {
            Number obj = (Number)o;
            if(a==obj.a && b==obj.b){
                System.out.println("true");
                return true;
            }else{
                return false;
            }
        }//equals

        @Override
        public int hashCode() {
            return a*b;
        }
    }//Number
}

