package lan.zold.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class Filesorter {

    public ArrayList<Long> read(){
        ArrayList<Long> nums = null;
        try {
           nums = tryRead();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! Nem található file!");
            System.err.println(e.getMessage());
        }
        return nums;
         
    }
    public ArrayList<Long> tryRead() throws FileNotFoundException{
        ArrayList<Long> numList = new ArrayList<>();
        File file = new File("szamok_2mil.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String nmStr =sc.nextLine();
            Long num=Long.parseLong(nmStr);
            numList.add(num);
        }
        sc.close();
        return numList;
       
    }
    public void sort() {
        ArrayList<Long> sortedList=new Organize().quicksort(read());
        write(sortedList);

    }
     public void write(ArrayList<Long> numList){
        try {
            tryWrite(numList);
        } catch (Exception e) {
            System.err.println("Hiba! A fájl írása sikertelen");
            System.err.println(e.getMessage());
        }


     }
    public void tryWrite(ArrayList<Long> numList)
         throws IOException{
        FileWriter fw = new FileWriter("sorted.txt");
        for(Long num : numList){
            fw.write(num.toString());
            fw.write("\n");
        }
        
        fw.close();
        
    }
    
   

 

 
 

        // public static void main(String[] args) {
        //     int[] arr = {5, 2, 9, 3, 6, 8};
        //     quickSort(arr, 0, arr.length - 1);
    
        //     System.out.println("Sorted array:");
        //     for (int num : arr) {
        //         System.out.print(num + " ");
        //     }
        // }
    
       
        // public static void quickSort() {
        //     if (low < high) {
        //         int pivotIndex = partition(arr, low, high);
        //         quickSort(arr, low, pivotIndex - 1);
        //         quickSort(arr, pivotIndex + 1, high);
        //     }
        // }
    
        // public static int partition(int[] arr, int low, int high) {
        //     int pivot = arr[high];
        //     int i = low - 1;
    
        //     for (int j = low; j < high; j++) {
        //         if (arr[j] < pivot) {
        //             i++;
        //             // Swap arr[i] and arr[j]
        //             int temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
    
        //     // Swap arr[i+1] and arr[high] (pivot)
        //     int temp = arr[i + 1];
        //     arr[i + 1] = arr[high];
        //     arr[high] = temp;
    
        //     return i + 1;
        // }
    }
    

