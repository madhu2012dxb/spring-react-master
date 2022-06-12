package com.jaat.geeky;

import com.jaat.geeky.controllers.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void loginSuccess() {
		MultiValueMap<String, String> formData=new LinkedMultiValueMap<String, String>();
		formData.add("username","admin");
		formData.add("password","admin");
		ResponseEntity<User> responseEntity = restTemplate.postForEntity("/api/login",formData, User.class);
		assertThat(responseEntity.getBody().getUsername()).isEqualTo("admin");
	}
	@Test
	public void loginFailed() {
		MultiValueMap<String, String> formData=new LinkedMultiValueMap<String, String>();
		formData.add("username","admin");
		formData.add("password","password");
		ResponseEntity<User> responseEntity = restTemplate.postForEntity("/api/login",formData, User.class);
		assertThat(responseEntity.getStatusCode().value()).isEqualTo(401);
	}

}
