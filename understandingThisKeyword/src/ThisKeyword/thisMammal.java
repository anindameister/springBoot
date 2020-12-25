package ThisKeyword;

public class thisMammal {

    int legs;

    public void usingMovingPart(int legs){

        this.legs=legs;
        System.out.println(legs);

    }

    public static void main(String[]args){


        thisMammal human=new thisMammal();
        human.usingMovingPart(9);
        System.out.println(human.legs);


    }
}
