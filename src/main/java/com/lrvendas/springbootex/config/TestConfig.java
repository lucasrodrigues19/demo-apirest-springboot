package com.lrvendas.springbootex.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lrvendas.springbootex.entites.Category;
import com.lrvendas.springbootex.entites.Order;
import com.lrvendas.springbootex.entites.Product;
import com.lrvendas.springbootex.entites.User;
import com.lrvendas.springbootex.enums.OrderStatus;
import com.lrvendas.springbootex.repositories.CategoryRepository;
import com.lrvendas.springbootex.repositories.OrderRepository;
import com.lrvendas.springbootex.repositories.ProductRepository;
import com.lrvendas.springbootex.repositories.UserRepository;

//classe de configuração para instancia um banco de dados
//servi para o banco de dados com alguns objetos
@Configuration // classe especifica de configuraçao
@Profile("test") // configuração especifica para o perfil de teste
public class TestConfig implements CommandLineRunner {

	@Autowired // asocia uma instancia de user repository implicitamente
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

//dataseeding
	@Override
	public void run(String... args) throws Exception {// vai ser executado quando a aplicacao for iniciadas
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, OrderStatus.PAID, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, OrderStatus.WAITTING_PAYAMENT,Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null,OrderStatus.CANCELED, Instant.parse("2019-07-22T15:21:22Z"), u1);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
