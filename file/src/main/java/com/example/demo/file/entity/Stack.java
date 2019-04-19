package com.example.demo.file.entity;

import java.util.Scanner;


public class Stack {
    int top;
    int bottom;
    int arr[];

    public int getTop() {
        return top;
    }
    public void setTop(int top) {
        this.top = top;
    }
    public int getBottom() {
        return bottom;
    }
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bottom;
        result = prime * result + top;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Stack other = (Stack) obj;
        if (bottom != other.bottom)
            return false;
        if (top != other.top)
            return false;
        return true;
    }
    public Stack(int top, int bottom) {
        super();
        this.top = top;
        this.bottom = bottom;
    }
    public Stack() {
        super();
    }
    @Override
    public String toString() {
        return "Stack [top=" + top + ", bottom=" + bottom + "]";
    }

    private static int n = 5;//栈的最大空间
    //初始化   构建一个空栈
    private static void initStack(Stack s) {
        s.arr = new int[n];//给栈申请空间
        s.top = s.bottom = 0;
        System.out.println("success");
    }

    //入栈   在栈顶插入一个新的元素
    private static void posh(Stack s) {
        Scanner sc = new Scanner(System.in);
        if(s.top + 1 != n){//判断是否     若栈未满
            System.out.print("please enter the data:");
            s.arr[s.top] = sc.nextInt();
            s.top++;
            System.out.println("success");
        }else{//若栈满   则入栈失败
            System.out.println("the stack is full.");
        }
    }
    //出栈  弹出栈顶元素
    private static int pop(Stack s) {
        int e = -1;

        if(s.top != s.bottom){//判断栈是否为空  若不空
            s.top--;
            e = s.arr[s.top];
        }else{//若为空
            System.out.println("the stack is empty.");
        }

        return e;//返回元素的值
    }
    public static void main(String[] args) {
        int op;

        Stack S = new Stack();
        Scanner sc = new Scanner(System.in);

        System.out.println("1.initialize\n2.push\n3.pop\n4.traverse");
        while(true){
            System.out.print("please ernter the operation code:");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    initStack(S);
                    break;
                case 2:
                    posh(S);
                    break;
                case 3:
                    int e = pop(S);
                    System.out.println(e);
                    break;
//                case 4:
//                    int count = traverse(S);
//                    System.out.println(count);
//                    break;
                default:
                    System.out.println("error.");
                    break;
            }
        }
    }
}
