package pojo;

import java.util.List;

public class Courses {


    private List<Api> Api ;
    private List<Mobile> mobile;
    private List<webAutomation> webAutomation;

    public List<Api> getApi(){
        return Api;
    }
    public void setApi(List<Api> Api){
        this.Api=Api;
    }

    public  List<Mobile> getMobile(){
        return  mobile;
    }
    public void setMobile(List<Mobile> Mobile){
        this.mobile=mobile;
    }
    public List<webAutomation> getWebAutomation(){
        return webAutomation;
    }
    public void setLaptop(List<webAutomation> Laptop){
        this.webAutomation=webAutomation;
    }



}
