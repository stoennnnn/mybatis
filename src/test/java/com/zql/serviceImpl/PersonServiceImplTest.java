package com.zql.serviceImpl;import com.zql.model.Person;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.context.junit4.SpringRunner;import java.util.ArrayList;import java.util.List;import static org.junit.Assert.*;@SpringBootTest@RunWith(SpringRunner.class)public class PersonServiceImplTest {    @Autowired    private PersonServiceImpl service;    @Test    public void addPersons() throws Exception {        List persons = new ArrayList();        for (int i = 0; i < 3; i++) {            Person person = new Person();            person.setName("a" + i);            person.setSex("aa" + i);            persons.add(person);        }        service.addPersons(persons);    }}