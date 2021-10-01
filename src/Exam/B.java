package Exam;

public class B {

    int g;
    A a;

    B(int g) {
        this.g = g;
        this.a = new A(g+2);
    }

    void add() {
        g += 1;
    }

}
