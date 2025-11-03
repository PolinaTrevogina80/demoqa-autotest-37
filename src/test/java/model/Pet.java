package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Pet {

    @JsonIgnoreProperties(ignoreUnknown = true)
    	public String name;
        public String species;
        public String sex;
        public int age;
}
