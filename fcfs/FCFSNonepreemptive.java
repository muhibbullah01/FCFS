package com.OS.fcfs;
import java.util.*;
import java.util.Scanner;

public class FCFSNonepreemptive {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter Number Of Processes: ");
        n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        for(int i=0; i<n; i++){
            System.out.println("Enter Arrival time for process "+(i+1));
            at[i] = sc.nextInt();
            System.out.println("Enter Burst time for process "+(i+1));
            bt[i] = sc.nextInt();
            pid[i] = i+1;
        }
        WaitingTime(n, at, bt, pid);

    }
    static void WaitingTime(int n, int at[], int bt[], int pid[]){

        int wt[] = new int[n];
        wt[0] = 0;
        System.out.println("PID\t Arrival Time\t" +
                "Burst Time\tWaiting Time\n");
        System.out.printf("%d\t\t\t%d\t\t\t%d\t\t\t%d\n",pid[0],at[0],bt[0],wt[0]);

        for(int i=1; i<n; i++){

            wt[i] = (at[i-1] + bt[i-1] + wt[i-1]) - at[i];
            System.out.printf("%d\t\t\t%d\t\t\t%d\t\t\t%d\n",pid[i],at[i],bt[i],wt[i]);

        }
        float avg;
        float sum=0;
        for(int i=0; i<n; i++){
            sum = sum + wt[i];
        }
        avg = sum / n;
        System.out.println("Average Waiting time = "+avg);

    }
}
