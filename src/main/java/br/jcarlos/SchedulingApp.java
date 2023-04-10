package br.jcarlos;

import br.jcarlos.Scheduling.*;
import br.jcarlos.Scheduling.Process;

public class SchedulingApp {

    public static void main(String[] args) throws InterruptedException {


        Process process1 = new Process("Add ",7);
        Process process2 = new Process("Multi ",10);
        Process process3 = new Process("Sub",4);

        PCB queue = new PCB();

        // FCFS fcfs = new FCFS(queue, 100);
        SJF sjf = new SJF(queue, 1000);

        sjf.run();


    }

}
