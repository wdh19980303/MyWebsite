package color.purple.proxy;

import color.purple.lenovo.Lenovo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.server.RemoteObjectInvocationHandler;

public class ProxyTest {
    public static void main(String[] args) {
        // 1 创建真实对象
        Lenovo lenovo = new Lenovo();
        /**
         * 三个参数
         *      1. 类加载器: 真实对象.getClass().getClassLoader()
         *      2. 接口数组: 真实对象.getClass().getInterfaces()
         *      3. 处理器: new InvocationHandler() //匿名内部类
         *
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * 参数
                 *   1. proxy 代理对象
                 *   2. method 代理对象方法的封装对象
                 *   3. args[] 代理对象的参数数组
                 */
                /*System.out.println("该方法被执行");
                System.out.println(method.getName());
                System.out.println(args[0]);*/

                // 1 拿到参数
                if (method.getName().equals("sale")) {
                    // 2 增强参数
                    double money = (double)args[0];
                    money = money * 0.85 ;

                    System.out.println("专车接");
                    // 真实对象调用该方法
                    String o = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    return o + "鼠标垫";

                }

                return null;
            }

        });

        // 2 调用方法
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);

    }

}
