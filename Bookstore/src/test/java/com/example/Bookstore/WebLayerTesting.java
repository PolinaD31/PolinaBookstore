package com.example.Bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTesting {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void booklistPage() throws Exception {
		this.mockMvc.perform(get("/booklist"))
		.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
	}
}
