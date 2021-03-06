package calculadoradsa.dsa.eetac.upc.edu.calculadoradsa;

import java.io.Serializable;

/**
 * Created by Carlos on 15/05/2017.
 */

public class Operation implements Serializable {
    private int num1,num2, result;
    private String op;

    //constructors per crear l'operacíó
    public Operation(){}
    public Operation(int num1, int num2, int result, String op){
        this.num1=num1;
        this.num2=num2;
        this.result=result;
        this.op=op;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return num1 + " " + " " + op + " " + num2 + " = " + result;
    }
}