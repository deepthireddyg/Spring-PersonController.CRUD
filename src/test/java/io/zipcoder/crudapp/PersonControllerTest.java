package io.zipcoder.crudapp;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;
@SpringBootTest
@AutoConfigureMockMvc

public class PersonControllerTest extends TestCase {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private PersonRepository personRepository;


        @Test
        public void testCreate() throws Exception {
           Person person = new Person("New Person!", null, null);
            BDDMockito
                    .given(personRepository.save(person))
                    .willReturn(person);

            String expectedContent="{\"id\":null,\"name\":\"New Baker!\",\"employeeId\":null,\"specialty\":null}";
            this.mvc.perform(MockMvcRequestBuilders
                            .post("/person/")
                            .content(expectedContent)
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.content().string(expectedContent));
        }


    public void testGetPerson() {
    }

    public void testGetPersonList() {
    }

    public void testUpdatePerson() {
    }

    public void testDeletePerson() {
    }





    @Test
    public void testShow() throws Exception {
        int givenId = 1;
        String firstname = "";
        String lastname = "";

        Person actual = new Person("anika",null,1);
        BDDMockito
                .given(personRepository.findBy(givenId).getId()).willReturn(actual.getId());

        //  "{\"id\":null,\"name\":\"New Baker!\",\"employeeId\":null,\"specialty\":null}";

        String expectedContent =   "{\"firstname\":\"priya\",\"lastname\":null,\"id\":1}";
        this.mvc.perform(MockMvcRequestBuilders
                        .get("/people/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
//@Test
//public void testShow() throws Exception {
//    int givenId = 1;
//    BDDMockito
//            .given(personRepository.findById(givenId))
//            .willReturn(Optional.of(new Person("New Person!", null, null)));
//
//    String expectedContent = "{\"id\":null,\"name\":\"New Person!\",\"employeeId\":null,\"specialty\":null}";
//    this.mvc.perform(MockMvcRequestBuilders
//                    .get("/people/" + givenId))
//            .andExpect(MockMvcResultMatchers.status().isOk())
//            .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//}



}