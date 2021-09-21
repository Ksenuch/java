package L3;

import static java.lang.System.*;

public class Calc {

    static double calc(double x, double y, char operation) {
        if (operation == '+')
            return x + y;
        if (operation == '-')
            return x - y;
        if (operation == '*')
            return x * y;
        if (operation == '/' && y != 0)
            return x / y;

        else return Double.NaN;
    }

    public static void main(String[] args){

        if(args.length != 3)
            out.println("Ошибка!");

        float x = Float.parseFloat(args[0]);
        char operation = args[1].charAt(0);
        float y = Float.parseFloat(args[2]);

        out.println(calc(x, y, operation));

    }
}
