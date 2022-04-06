package com.OS.fcfs;
import java.util.*;
import java.util.Scanner;
public class FCFSPreemptive {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Please Enter number of processes");
        n = sc.nextInt();
        int pid[] = new int[n];
        int bt[] = new int[n];
        for(int i=0; i<n; i++){
            System.out.println("Please enter burst time below for process: "+(i+1));
            bt[i] = sc.nextInt();
            pid[i] = i+1;
        }
        avgTimeCalculation(n, pid, bt);
    }
    static void avgTimeCalculation(int n, int pid[], int bt[]){
        int wt[] = new int[n], tat[] = new int[n];
        int totalWT = 0, totalTAT = 0;
        waitingTime(n, pid, bt, wt);
        turnAroundTime(n, pid, bt, wt, tat);
        System.out.println("ProcessNO. \tBurst Time\tWaiting Time\tTurn Around Time\n");
        for(int i=0; i<n; i++){
            totalWT = totalWT + wt[i];
            totalTAT = totalTAT + tat[i];
            System.out.printf("\t%d\t\t\t%d\t\t\t%d\t\t\t\t%d\n",
                    pid[i],bt[i],wt[i],tat[i]);
        }
        float avgWT = (float)totalWT/(float)n;
        float avgTAT = (float)totalTAT/(float)n;
        System.out.printf("Average Waiting Time = %f", avgWT);
        System.out.println();
        System.out.printf("Average Turn-Around Time = %f", avgTAT);
    }
    static void waitingTime(int n, int pid[], int bt[], int wt[]){
        wt[0] = 0;
        for(int i=1; i<n; i++){
            wt[i] = bt[i-1] + wt[i-1];
        }
    }
    static void turnAroundTime(int n, int pid[], int bt[], int wt[], int tat[]){
        for(int i=0; i<n; i++){
            tat[i] = bt[i] + wt[i];
        }
    }
}
