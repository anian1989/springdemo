package com.fanhanfei.springstudy;

import com.fanhanfei.springstudy.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdemoApplicationTests {

	@Test
	public void contextLoads() {
		ClassPathResource resource = new ClassPathResource("beans.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
	}

	@Test
	public void testBeanFactoryPostProcess(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentService studentService = (StudentService) context.getBean("studentService");
		studentService.testBeanFactoryPostProcessor();
	}
	@Test
	public void BeanPostProcessor(){
//		ClassPathResource resource = new ClassPathResource("beans.xml");
//		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//		reader.loadBeanDefinitions(resource);
//		BeanPostProcessorImpl beanPostProcessorService = (BeanPostProcessorImpl) factory.getBean("beanPostProcessorService");
//		factory.addBeanPostProcessor(beanPostProcessorService);
//		beanPostProcessorService.display();
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.fanhanfei.springdemo");
		StudentService helloServiceTest = applicationContext.getBean(StudentService.class);
		helloServiceTest.testBeanFactoryPostProcessor();
	}

}
