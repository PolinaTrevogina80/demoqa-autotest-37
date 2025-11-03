package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

public class User {

    @JsonIgnoreProperties(ignoreUnknown = true)
        public String name;
        public String phoneNumber;
        public String email;
        public String address;
        public List<Pet> pets;

}
