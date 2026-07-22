package Resourses;

import pojo.Addplace;
import pojo.location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public Addplace AddPlacePayload(){

        Addplace a = new Addplace();
        a.setAddress("29, side layout, cohen 09");
        a.setName("Frontline house");
        a.setPhone_number("(+91) 983 893 3937");
        a.setWebsite("http://google.com");
        a.setLanguage("French-IN");
        a.setAccuracy(50);

        location b = new location();
        b.setLat(-38.383494);
        b.setLng(33.427362);
        a.setLocation(b);

        List<String> mylist= new ArrayList<>();
        mylist.add("shoe park");
        mylist.add("shop");
        a.setTypes(mylist);
        return a;
    }
}
