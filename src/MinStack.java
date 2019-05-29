import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 入栈操作
     * @param element
     */
    public void push(int element){
        mainStack.push(element);
        if(minStack.empty() || element <= minStack.peek()){
            minStack.push(element);
        }
    }

    /**
     * 出栈操作
     * @return
     */
    public Integer pop(){
        if(mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 获取栈的最小元素
     * @return
     * @throws Exception
     */
    public int getMin() throws Exception{
        if(minStack.empty()){
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }
    public static void main(String[] args) throws Exception{
        MinStack stack = new MinStack();
        stack.push(8);
        stack.push(4);
        stack.push(10);
        stack.push(3);
        stack.push(5);
        stack.push(9);
        stack.push(11);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}