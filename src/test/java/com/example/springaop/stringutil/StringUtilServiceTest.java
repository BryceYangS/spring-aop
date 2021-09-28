package com.example.springaop.stringutil;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringUtilServiceTest {

	@Autowired
	StringUtilService service;

	@Test(expected = IllegalStateException.class)
	public void throw1() throws Exception {
		service.removeAllNumbers(null);
	}

	@Test
	public void test() throws Exception {
		assertEquals("null", service.removeAllNumbers("1234nu123ll"));
	}

}