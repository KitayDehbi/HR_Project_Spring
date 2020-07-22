package dehbi.hr.Configuration;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{dehbi.hr.Configuration.AppContext.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

   /*@Override
    protected Filter[] getServletFilters() {
        Filter[] filters ={new LoginFilter(),new ArticleFilter(), new UserFilter()};
        return filters;
    }*/
}
