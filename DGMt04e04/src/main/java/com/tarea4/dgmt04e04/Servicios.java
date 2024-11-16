package com.tarea4.dgmt04e04;

import org.springframework.stereotype.Service;

@Service
public class Servicios {
    int num1 = 0, num2 = 0, step = 0;
    String result, oper;

    public void agregar(int number) {
        if (step == 0) {
            try {
                if (num1 == 0) {
                    num1 = number;
                } else {
                    num1 = Integer.parseInt(String.valueOf(num1) + String.valueOf(number));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (step == 1) {
            try {
                if (num2 == 0) {
                    num2 = number;
                } else {
                    num2 = Integer.parseInt(String.valueOf(num2) + String.valueOf(number));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void stepup(){
        step++;
    }

    public void restore(){
        num1 = 0;
        num2 = 0;
        step = 0;
        oper="";
        result = "";
    }

    public void resultado (){
        if (step == 1) {
            step = 2;
            if (oper=="sum") {
                result = String.valueOf(num1 + num2);
            }else if (oper=="rest") {
                result = String.valueOf(num1 - num2);
            }
        }
    }
    //Getter y setter
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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }


}
