package dpworld;

import java.util.List;

public class EncryptionValidation {
	static List<Integer> encryptionValidation(int instructionCount,int validityPeriod,List<Integer> keys){
		int max = 0;
		for(int i=0;i<keys.size();i++) {
			int a = keys.get(i);
			int curr = 0;
			for(int j=0;j<keys.size();j++) {
				int b = keys.get(j);
				if(a%b==0)
					curr++;
			}
			if(curr>max) {
				max = curr;
			}
		}
		long encryption = max*100_000;
		long ic = (long)instructionCount;
		long vp = (long)validityPeriod;
		
		return null;
	}
}
