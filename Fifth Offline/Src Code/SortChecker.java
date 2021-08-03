package main;

import java.util.List;

public class SortChecker {
    public static boolean isAscending(List<Integer> retList){

        if(retList==null) return true;

        if(retList.size()<=1) return true;
        for(int i=1;i<retList.size();i++){
            if(retList.get(i-1)>retList.get(i)) {
                System.out.println();
                return false;
            }
        }

        return true;
    }
    public static boolean isSame(List<Integer>list1,List <Integer> list2){
        if(list1.size()!=list2.size()) return false;
        for (int i=0;i<list1.size();i++){
            if(list2.contains(list1.get(i))){
                list2.remove(list1.get(i));
                list1.remove(i);
            }else return false;
        }
        return true;
    }
}
