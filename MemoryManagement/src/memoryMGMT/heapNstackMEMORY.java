package memoryMGMT;

public class heapNstackMEMORY {

    public class Radio{
        public void play(){
            System.out.println("Playing radio");
        }
    }

    public class Car{

        String name;
        Radio r;
        public void start(){
            System.out.println("car start");
        }

        public void playRadio(){
            r=new Radio();
            r.play();
        }
    }

    public static void main(String[]args){



    }


}

