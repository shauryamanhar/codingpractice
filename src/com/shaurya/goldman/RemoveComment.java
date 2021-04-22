package com.shaurya.goldman;

public class RemoveComment {
	public static void main(String[] args) {
		String[] src =  {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
		};
		remove(src);
	}
	static public void remove(String[] src) {
		boolean block=false;
		for(int i=0;i<src.length;i++) {
			char c[] = src[i].toCharArray();
			int j=0;
			boolean newline=false;
			while(j<c.length) {
				if(!block && j+1<c.length && c[j]=='/' && c[j+1]=='*'){
					block=true;
					j++;
				}else if(!block && j+1<c.length && c[j]=='/' && c[j+1]=='/') {
					break;
				}else if(block && j+1<c.length && c[j]=='*' && c[j+1]=='/') {
					block=false;
					j++;
				}else if(block==false) {
					System.out.print(c[j]);
					newline=true;
				}
				j++;
			}
			if(!block && newline==true) {
				System.out.println();
			}
		}
	}
}
