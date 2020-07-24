package dehbi.hr.Configuration;


import dehbi.hr.Converter.DepartementConverter;
import dehbi.hr.Converter.EmployeeConverter;
import dehbi.hr.Securite.Admininterceptor;
import dehbi.hr.Securite.Employeeinterceptor;
import dehbi.hr.Securite.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "dehbi.hr" })
//@EnableAspectJAutoProxy
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolvers =new InternalResourceViewResolver();
        resolvers.setViewClass(JstlView.class);
        resolvers.setPrefix("/WEB-INF/views/");
        resolvers.setSuffix(".jsp");
        return resolvers;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DepartementConverter());
        registry.addConverter(new EmployeeConverter());
    }


    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        /*registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(new String[]{
                       "/admin/employees","/employee/profile"
                }).excludePathPatterns("/");*/

        /*registry.addInterceptor(new Admininterceptor()).addPathPatterns(new String[]{

        });

        registry.addInterceptor(new Employeeinterceptor()).addPathPatterns(new String[]{
                "/employee/*"
        });*/

    }
}
