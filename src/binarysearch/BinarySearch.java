/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci quanti numeri vuoi inserire nell'array: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            System.out.print("Inserisci il numero: ");
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        printArray(arr);
        System.out.print("Inserisci il numero da ricercare: ");
        int ricerca = sc.nextInt();
        int ibs=iterativeBinarySearch(arr, ricerca);
        int rbs=recursiveBinarySearch(arr, ricerca, 0, arr.length);
        System.out.println("--- con ricerca iterativa ---");
        System.out.println(String.format("Il valore %d si trova nella posizione %d", ricerca, ibs));
        System.out.println("--- con ricerca ricorsiva ---");
        System.out.println(String.format("Il valore %d si trova nella posizione %d", ricerca, rbs));
        
    }
    
    static int iterativeBinarySearch(int[] arr, int ricerca) {
        int inizio=0;
        int fine=arr.length-1;
        int centro;
        int pos=-1;
        do {
            centro=(int)Math.floor((inizio+fine)/2);
            if(arr[centro] == ricerca) {
                pos=centro;
            } else if(arr[centro] < ricerca) {
                inizio=centro+1;
            } else {
                fine=centro-1;
            }
        } while(arr[centro]!=ricerca && pos==-1);
        return pos;
    }
    
    static int recursiveBinarySearch(int[] arr, int ricerca, int inizio, int fine) { //ricorsivo
    int centro=(int)Math.floor((inizio+fine)/2); //indice medio
    int pos=-1;
    
    if(arr[centro]==ricerca) {
            pos=centro;
            return pos;
        } else if(arr[centro]>ricerca) {
            fine=centro-1;
        } else {
            inizio=centro+1;
        }
    
    return recursiveBinarySearch(arr,ricerca,inizio,fine);
}
    
    static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: ");
        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
    
}
