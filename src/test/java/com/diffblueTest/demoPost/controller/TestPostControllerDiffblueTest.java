package com.diffblueTest.demoPost.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TestPostController.class})
@ExtendWith(SpringExtension.class)
class TestPostControllerDiffblueTest {
       @Autowired
       private TestPostController testPostController;

       /**
        * Test {@link TestPostController#coverTest(int, String)}.
        * <p>
        * Method under test: {@link TestPostController#coverTest(int, String)}
        */
       @Test
       @DisplayName("Test coverTest(int, String)")
       void testCoverTest() throws Exception {
              // Arrange
              MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/coverTest");
              MockHttpServletRequestBuilder requestBuilder = postResult.param("numberOfTests", String.valueOf(1))
                      .param("testType", "foo");

              // Act and Assert
              MockMvcBuilders.standaloneSetup(testPostController)
                      .build()
                      .perform(requestBuilder)
                      .andExpect(MockMvcResultMatchers.status().isOk())
                      .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                      .andExpect(MockMvcResultMatchers.content().string("Cover test post called"));
       }

       /**
        * Test {@link TestPostController#test()}.
        * <p>
        * Method under test: {@link TestPostController#test()}
        */
       @Test
       @DisplayName("Test test()")
       void testTest() throws Exception {
              // Arrange
              MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/test");

              // Act and Assert
              MockMvcBuilders.standaloneSetup(testPostController)
                      .build()
                      .perform(requestBuilder)
                      .andExpect(MockMvcResultMatchers.status().isOk())
                      .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                      .andExpect(MockMvcResultMatchers.content().string("Test"));
       }
}
