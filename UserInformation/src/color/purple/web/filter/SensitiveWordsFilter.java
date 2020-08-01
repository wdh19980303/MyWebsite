package color.purple.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


// 敏感词汇过滤器
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 强制转换为http
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 正式代码
        System.out.println(sensitiveWords);
//        request.getParameterMap()
        // 1 创建代理对象
        ServletRequest proxy = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 增强getParameter
                // 判断是否是该方法
//                System.out.println("filter loader");
                if (method.getName().equals("getParameter")) {
                    // 增强返回值
                    String value = (String) method.invoke(req, args);
//                    System.out.println("filter:" + value);
                    // 获取返回值
                    if (value != null) {
                        for (String sensitiveWord : sensitiveWords) {
                            if (value.contains(sensitiveWord)) {
                                value = value.replaceAll(sensitiveWord, "****");
                            }
                        }
                    }

                    return value;
                }

                if (method.getName().equals("getParameterMap")) {
                    // 返回值
                    Map<String, String[]> valueMap = (Map<String, String[]>) method.invoke(req, args); // 对map集合中的元素进行敏感字过滤
                    Set<String> keySet = valueMap.keySet();
                    if (keySet.size() != 0) {
                        for (String key : keySet) {
                            String[] values = valueMap.get(key);
                            for (int i = 0; i < values.length; i++) {
                                for (String sensitiveWord : sensitiveWords) {
                                    if (values[i].contains(sensitiveWord)) {
                                        values[i] = values[i].replaceAll(sensitiveWord, "****");

                                    }
                                }
                            }

                            valueMap.put(key, values);
                        }
                    }
                    return valueMap;
                }

                if (method.getName().equals("getParameterValues")) {
                    String values[] = (String[]) method.invoke(req, resp);
                    if (values.length != 0) {
                        for (int i = 0; i < values.length; i++) {
                            for (String sensitivesWord : sensitiveWords) {
                                if (values[i].contains(sensitivesWord)) {
                                    values[i] = values[i].replaceAll(sensitivesWord, "*****");
                                }
                            }
                        }
                    }
                    return values;
                }

                return method.invoke(req, args);
            }
        });
        chain.doFilter(proxy, resp);// 放行
    }


    public void destroy() {

    }

    private final List<String> sensitiveWords = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {


        try {
            // 1 获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/SensitiveWords.txt");
            // 2 读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String line = null;
            while ((line = br.readLine()) != null) {
                sensitiveWords.add(line);
            }
            br.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
