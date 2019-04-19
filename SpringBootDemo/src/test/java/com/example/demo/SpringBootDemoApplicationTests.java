package com.example.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	private MockMvc mockMvc;
	
	List<String> mockedList = mock(List.class);
	
	@Autowired
	DemoController demoController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
	}
	
	@Test
	public void contextLoads() {
		Assert.assertEquals(true, "test".equals("test"));
	}
	
	@Test
	public void mockedListTest() {
		mockedList.add("test");
		mockedList.add("wow~~^^");
		System.out.println(mockedList);
		Assert.assertEquals(0, mockedList.size());	//mock된 것은 실제 객체에 영향을 끼치지 않는다.
	}
	
	@Test
	public void mockedListTestVerify() {
		mockedList.add("test");
		mockedList.add("wow~~^^");
		System.out.println(mockedList);
		verify(mockedList).add("test");
	}
	
	@Test
	public void requsetTest() throws Exception {
		this.mockMvc.perform(get("/"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	public void failTest() throws Exception {
		this.mockMvc.perform(get("notExists"))
			.andDo(print())
			.andExpect(status().isOk());
	}

}
