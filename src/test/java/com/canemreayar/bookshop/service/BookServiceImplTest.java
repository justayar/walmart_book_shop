package com.canemreayar.bookshop.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

    @InjectMocks
    BookServiceImpl bookServiceImpl;

    @Mock
    RestTemplate restTemplate;

    @Before
    public void setUp() {


    }

}