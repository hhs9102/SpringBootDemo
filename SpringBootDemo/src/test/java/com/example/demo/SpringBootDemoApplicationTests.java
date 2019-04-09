package com.example.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	List<String> mockedList = mock(List.class);
	
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

}
