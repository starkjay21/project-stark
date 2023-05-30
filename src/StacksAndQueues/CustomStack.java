package StacksAndQueues;

class StackUnderflowException extends Exception{
    public StackUnderflowException(String s)
    {
        super(s);
    }
}
public class CustomStack {
    protected int[] data;
    private int DEFAULT_SIZE = 10;
    private int pointer;
    CustomStack(int size)
    {
        data = new int[size];
        pointer = -1;
    }
    //DEFAULT Constructor
    CustomStack()
    {
        data = new int[DEFAULT_SIZE];
        pointer = -1;
    }
    void push(int x)
    {
        data[++pointer] = x;
    }
    int pop()
    {
        try
        {
            if(pointer == -1)
                throw new StackUnderflowException("Stack Underflow");
        }
        catch(StackUnderflowException e)
        {
            System.out.println(e.getMessage());
            return Integer.MIN_VALUE;
        }
        return data[pointer--];
    }
    int peek()
    {
        return data[pointer];
    }

}
