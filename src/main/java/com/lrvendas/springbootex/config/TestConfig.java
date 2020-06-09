package com.lrvendas.springbootex.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lrvendas.springbootex.entites.Order;
import com.lrvendas.springbootex.entites.User;
import com.lrvendas.springbootex.repositories.OrderRepository;
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

//dataseeding
	@Override
	public void run(String... args) throws Exception {// vai ser executado quando a aplicacao for iniciadas
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
