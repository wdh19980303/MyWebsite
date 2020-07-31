package color.purple.lenovo;

import color.purple.proxy.SaleComputer;

public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("买电脑花了" + money);
        return "买了一台电脑    ";
    }

    @Override
    public String show() {
        System.out.println("展示电脑");
        return null;
    }


}
