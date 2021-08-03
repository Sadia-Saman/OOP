package main;

import java.util.ArrayList;

public class SortClass {

    public SortClass(){
    }

    public ArrayList<Integer> func(ArrayList<Integer> alist){
      if (alist==null) return null;
        ArrayList<Integer> list = new ArrayList<>(alist);
         for(int i=0,j,temp;i< list.size();i++){
            temp = list.get(i);
            j = i - 1;
            while (j >= 0 && list.get(j) > temp )
            {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, temp);
        }
        return list;
    }

}

