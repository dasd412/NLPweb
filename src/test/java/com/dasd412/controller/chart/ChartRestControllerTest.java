package com.dasd412.controller.chart;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChartRestControllerTest {

    @LocalServerPort
    private int port;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .addFilter(new CharacterEncodingFilter("UTF-8", true))
            .build();
    }

    @Test
    public void testGetRandomDummy() throws Exception {
        String url = "http://localhost:" + port + "/api/nlp/charts/random";

        String result = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
            .getContentAsString();

        logger.info("result ->" + result);
    }

    @Test
    public void testGetRandomDummies() throws Exception {
        String url = "http://localhost:" + port + "/api/nlp/charts/randomset";

        String result = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
            .getContentAsString();

        logger.info("result LIST->" + result);
    }
//
//    @Transactional
//    @Test
//    public void testGetTwit() throws Exception {
//        //given
//        String url = "http://localhost" + port + "/api/nlp/twit/list";
//
//        //when
//        String result = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_UTF8))
//            .andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
//            .getContentAsString();
//
//        //then
//        logger.info("twit list" + result);
//    }

    @Transactional
    @Test
    public void testGetTwitByReTwitId() throws Exception {
        //given
        String url = "http://localhost" + port + "/api/nlp/twit/list/" + "1113831194628481024";

        //when
        String result = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
            .getContentAsString();

        //then
        logger.info("twit list" + result);
    }


    @Test
    public void testGetReTwit() throws Exception {
        //given
        String url = "http://localhost" + port + "/api/nlp/reTwit/list";

        //when
        String result = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
            .getContentAsString();

        //then
        logger.info("retwit list" + result);
    }

}