package site.metacoding.blogv2.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import site.metacoding.blogv2.config.filter.MyFilter1;
import site.metacoding.blogv2.config.filter.MyFilter2;

//어노테이션: controller, restcontroller, repository, service, component, configuration(설정파일)

//@Configuration
public class FilterConfig {

    @Bean // ioc container에 필터 설정파일을 등록한다.
    public FilterRegistrationBean<?> filter1() {
        FilterRegistrationBean<MyFilter1> bean = new FilterRegistrationBean<MyFilter1>(new MyFilter1());
        bean.addUrlPatterns("/*");
        bean.setOrder(1); // 낮은 번호의 필터가 가장 먼저 실행된다.
        return bean; // 리턴되는 객체가 ioc container에 등록된다.
    }

    @Bean // ioc container에 필터 설정파일을 등록한다.
    public FilterRegistrationBean<?> filter2() {
        FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<MyFilter2>(new MyFilter2());
        bean.addUrlPatterns("/*");
        bean.setOrder(2); // 낮은 번호의 필터가 가장 먼저 실행된다.
        return bean; // 리턴되는 객체가 ioc container에 등록된다.
    }
}
