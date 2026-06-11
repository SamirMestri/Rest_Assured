package JavaBasics;

public class AusLight implements GlobleLight,IndianLight{



    @Override
    public void redlight() {
        System.out.println("RedLight Stop");
    }

    @Override
    public void yellowlight() {
        System.out.println("YellowLight Ready");

    }

    @Override
    public void greenlight() {

        System.out.println("GreenLight Go");

    }

    public void ownlight(){

        System.out.println("slowly walk");
    }

    @Override
    public void WalkToWalk() {
        System.out.println("Any light Walk");

    }
    public static void main(String[] args) {

        GlobleLight g = new AusLight();
        g.greenlight();
        g.redlight();
        g.yellowlight();

        AusLight o = new AusLight();
        o.ownlight();

        IndianLight I= new AusLight();
        I.WalkToWalk();

    }

    }

