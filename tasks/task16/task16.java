package tasks.task16;

public class task16 {
    public static void main(String[] args) {
        Gorilla myGorilla = new Gorilla();

        myGorilla.feed(true);
        myGorilla.groom();
        myGorilla.pet();
        myGorilla.feed(false);
    }
}

interface Animal {
    boolean feed(boolean timeToEat);
    void groom();
    void pet();
}

class Gorilla implements Animal {

    @Override
    public boolean feed(boolean timeToEat) {
        
        if (timeToEat) {
            System.out.println("Gorilla is eating.");
            return true;
        } else {
            System.out.println("Gorilla is not hungry right now.");
            return false;
        }
    }

    @Override
    public void groom() {
        
        System.out.println("Gorilla is grooming itself.");
    }

    @Override
    public void pet() {
        
        System.out.println("Attempting to pet the gorilla. (Proceed with caution!)");
    }

}
