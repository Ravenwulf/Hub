class TestScores {
  public TestScores() {
		int[] testScores = {100,79,98,23,55};
		int sum = 0;
		int max = 0;
		int min = testScores[0];
		boolean increased = true;
		for(int i = 0;i<testScores.length;i++){
			sum+=testScores[i];
			min = Math.min(min, testScores[i]);
			max = Math.max(max, testScores[i]);
			if(testScores[i]!=testScores[0]&&testScores[i]<testScores[i-1]){
				increased=false;
			}
		}
		int range = max-min;
		double average = sum/testScores.length;
		double average2 = (sum-min)/(testScores.length-1);
		System.out.println("Test\n_____\nincreasing? "+increased+".\naverage: "+average+"\nmin: "+min+"\nmax: "+max+"\nrange: "+range+"\ncurved average: "+average2);
		int[] sorted = this.sort(testScores);
		for(int i=0;i<sorted.length;i++){
			System.out.println(sorted[i]);
		}
	}	
  public static int[] sort(int[] nums){
		int[] storage = new int[nums.length];
		int[] end = new int[nums.length];
		int min = nums[0];
		boolean changed = false;
		boolean increasing = false;
		for(int i=0;i<nums.length;i++){
			min=Math.min(min, nums[i]);
		}
		end[0]=min;
		int max = min;
		for(int i=0;i<nums.length;i++){
			if(Math.max(max, nums[i])!=max){
				storage[i]=max;
				max=nums[i];
				changed = true;
			}else{
				if(changed){
					storage[i]=max;
					storage[i-1]=nums[i];
				}
			}
		}
		while(!increasing){
			for(int i=0;i<storage.length;i++){
			min=Math.min(min, storage[i]);
			}
			end[0]=min;
			max = min;
			for(int i=0;i<storage.length;i++){
				if(Math.max(max, storage[i])!=max){
					end[i]=max;
					max=nums[i];
					changed = true;
				}else{
					if(changed){
						end[i]=max;
						end[i-1]=storage[i];
						changed = false;
					}
				}
				for(int k=0;k<end.length;k++){
					if(end[k]!=end[0]&&end[k]<end[k-1]){
						increasing=false;
					}
				}
			}
		}
		return end;
  }

}