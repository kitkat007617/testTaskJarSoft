package com.nikita.klimkin.testTaskJarSoft;

import com.nikita.klimkin.testTaskJarSoft.repository.RequestRepository;
import com.nikita.klimkin.testTaskJarSoft.repository.UserRepository;
import com.nikita.klimkin.testTaskJarSoft.service.BannerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class TestTaskJarSoftApplication implements ApplicationRunner {

	private UserRepository userRepository;
	private BannerService bannerService;

	public static void main(String[] args) {
		SpringApplication.run(TestTaskJarSoftApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		System.out.println(userRepository.findByEmail("user@email.ru"));
//		System.out.println(bannerService.getAllForUI());
//		System.out.println(bannerService.getAll());
	}
}
