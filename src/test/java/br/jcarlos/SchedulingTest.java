package br.jcarlos;

import br.jcarlos.Scheduling.*;
import br.jcarlos.Scheduling.Process;
import org.junit.Assert;
import org.junit.Test;


public class SchedulingTest
{
    PCB queue = new PCB();
    @Test
    public void shouldHaveSize(){
        Process process1 = new Process("For test1 ",1);
        Process process2 = new Process("For test2 ",1);
        Process process3 = new Process("For test3",1);

        queue.addProcessToList(process1);
        queue.addProcessToList(process2);
        queue.addProcessToList(process3);

        Assert.assertEquals(3, queue.getProcessList().size());
    }

    @Test
    public void shouldBeSortByBurstTime(){

        Process process1 = new Process("For test1 ",22);
        Process process2 = new Process("For test2 ",12);
        Process process3 = new Process("For test3",30);

        queue.addProcessToList(process1);
        queue.addProcessToList(process2);
        queue.addProcessToList(process3);

        queue.sortByBurstTime(process1);

        Assert.assertEquals(12, queue.getProcessList().get(0).getBurstTime());
        Assert.assertEquals(22, queue.getProcessList().get(1).getBurstTime());
        Assert.assertEquals(30, queue.getProcessList().get(2).getBurstTime());
    }

    @Test
    public void shouldBeSortByPriority(){

        Process process1 = new Process("For test1 ",22,9);
        Process process2 = new Process("For test2 ",12,1);
        Process process3 = new Process("For test3",30,2);

        queue.addProcessToList(process1);
        queue.addProcessToList(process2);
        queue.addProcessToList(process3);

        queue.sortByPriority(process1);

        Assert.assertEquals(1, queue.getProcessList().get(0).getPriority());
        Assert.assertEquals(2, queue.getProcessList().get(1).getPriority());
        Assert.assertEquals(9, queue.getProcessList().get(2).getPriority());
    }

    @Test
    public void shouldReturnCorretInfoProcess(){
        Process process1 = new Process("Add",2);
        Process process2 = new Process("Sub",15, 2);

        Assert.assertEquals("Add", process1.getNameProcess());
        Assert.assertEquals(2, process1.getBurstTime());
        Assert.assertEquals(0,process1.getPriority());

        Assert.assertEquals("Sub", process2.getNameProcess());
        Assert.assertEquals(15, process2.getBurstTime());
        Assert.assertEquals(2,process2.getPriority());

    }

    @Test
    public void shouldFCFSWorks() throws InterruptedException {
        Process process1 = new Process("Test 1",7);
        Process process2 = new Process("Test 2",5 );
        Process process3 = new Process("Test 3",4);

        queue.addProcessToList(process1);
        queue.addProcessToList(process2);
        queue.addProcessToList(process3);

        FCFS rr = new FCFS(queue);

        Assert.assertEquals(rr.run(), 1);
    }

    @Test
    public void shouldFCFSReturnIsEmpty() throws  InterruptedException{
        FCFS rr = new FCFS(queue);


        Assert.assertEquals(rr.run(), 0);

    }

    @Test
    public void shouldRRWorks() throws InterruptedException {
        Process process1 = new Process("Test 1",7);
        Process process2 = new Process("Test 2",5 );
        Process process3 = new Process("Test 3",4);

        queue.addProcessToList(process1);
        queue.addProcessToList(process2);
        queue.addProcessToList(process3);

        queue.sortByBurstTime(process1);
        RR rr = new RR(queue, 3);

        Assert.assertEquals(rr.run(), 1);
    }

    @Test
    public void shouldRRReturnIsEmpty() throws  InterruptedException{
        RR rr = new RR(queue, 2);


       Assert.assertEquals(rr.run(), 0);

    }

    @Test
    public void shouldSJFWorks() throws InterruptedException {
        Process process1 = new Process("Test 1",7);
        Process process2 = new Process("Test 2",5 );
        Process process3 = new Process("Test 3",4);

        queue.addProcessToList(process1);
        queue.addProcessToList(process2);
        queue.addProcessToList(process3);
        queue.sortByBurstTime(process1);

        SJF sjf = new SJF(queue, 3);

        Assert.assertEquals(sjf.run(), 1);
    }

    @Test
    public void shouldSJFReturnIsEmpty() throws  InterruptedException{
        SJF sjf = new SJF(queue, 2);

        Assert.assertEquals(sjf.run(), 0);

    }


}
