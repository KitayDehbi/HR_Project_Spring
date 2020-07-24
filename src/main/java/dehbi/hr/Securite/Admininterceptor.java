package dehbi.hr.Securite;

import dehbi.hr.Entite.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Admininterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception {
        RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(
                RequestMapping.class);
        boolean alreadyLoggedIn = request.getSession()
                .getAttribute("user") != null;
        Employee e =(Employee) request.getSession().getAttribute("user");

        if (e.is_admin()) {
            response.sendRedirect(request.getContextPath() + "/admin/employees");
            return false;
        } else {
            response.sendRedirect(request.getContextPath() + "/employee/profile");
            return false;
        }


    }
}
