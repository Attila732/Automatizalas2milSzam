package lan.zold.models;

import java.util.ArrayList;

public class Organize implements iOrganize {

    @Override
    public ArrayList<Long> bubbleSort(ArrayList<Long> numList) {
        int n = numList.size();
		for(int i= n-1; i>0; i--)
			for(int j=0; j<i; j++)
				if(numList.get(j) > numList.get(j+1)){

					Long tmp = numList.get(j);
					numList.set(j, numList.get(j+1));
					numList.set(j+1, tmp);

				}
        return numList;
    }
	ArrayList<Long> quicksort(ArrayList<Long> list) {
        if (list.size() <= 1) {
            return list;
        }
        ArrayList<Long> less = new ArrayList<>();
        ArrayList<Long> equal = new ArrayList<>();
        ArrayList<Long> greater = new ArrayList<>();
       	Long pivot = list.get(list.size()-1);
        for (Long x : list) {
            if (x < pivot) less.add(x);
            if (x == pivot) equal.add(x);
            if (x > pivot) greater.add(x);
        }        
        ArrayList<Long> sumList = new ArrayList<Long>();
        sumList.addAll(quicksort(less));
        sumList.addAll(equal);
        sumList.addAll(quicksort(greater));        
        return sumList;
    }
    
}
