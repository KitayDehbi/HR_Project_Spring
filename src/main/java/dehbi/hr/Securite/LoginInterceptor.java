package dehbi.hr.Securite;

import dehbi.hr.Entite.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle (HttpServletRequest request,
                                  HttpServletResponse response,
                                  Object handler) throws Exception {
            RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(
                    RequestMapping.class);
            boolean alreadyLoggedIn = request.getSession()
                    .getAttribute("user") != null;
            String uri = request.getRequestURI();
            String [] path= uri.split("/");
            //for (String s : path) System.out.println(s);
            System.out.println(path[2]);
            boolean adminPageRequested ="admin".equals(path[2]);
            StringBuffer url = new StringBuffer();
            for (int i =2;i<path.length ;i++){
                url.append("/");
                url.append(path[i]);

            }
            Employee e =(Employee) request.getSession().getAttribute("user");
            if(alreadyLoggedIn && e.is_admin() && adminPageRequested){
                response.sendRedirect(request.getRequestURI());
                return false;
            }else if (alreadyLoggedIn && !e.is_admin() && (request.getRequestURI().equals(request.getContextPath()+"/admin/employees"))){
                response.sendRedirect(request.getContextPath() + "/");
                return false;
            }
            else if (alreadyLoggedIn && !e.is_admin() && (request.getRequestURI().equals(request.getContextPath()+"/employee/profile"))){
                response.sendRedirect(request.getRequestURI());
                return false;
            }
            else  {
                response.sendRedirect(request.getContextPath() + "/");
                return false;
            }


        }
}
