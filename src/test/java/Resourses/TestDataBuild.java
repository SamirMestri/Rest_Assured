package Resourses;

import pojo.Addplace;
import pojo.location;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public Addplace AddPlacePayload(String Name,String Language,String Phone_number,String Website){

        Addplace a = new Addplace();
        a.setAddress("29, side layout, cohen 09");
        a.setName(Name);
        a.setPhone_number(Phone_number);
        a.setWebsite(Website);
        a.setLanguage(Language);
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
