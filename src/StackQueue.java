import java.util.Stack;

class StackQueue {
    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();

    /**
     * 入队
     * @param element
     */
    public void enQueue(int element){
        stackA.push(element);
    }

    /**
     * 出队
     * @return
     */
    public Integer deQueue(){
        if(stackB.isEmpty()){
            if(stackA.isEmpty()){
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 把a转到b
     */
    private void transfer(){
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }
    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }
}