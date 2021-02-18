public class Button {
    boolean isBomb;
    int nearbyBombCount;



    Button(){
        boolean isBomb = false;
        Button above = null;
    }
    Button(boolean bomb, int surrounding){
        this.isBomb = bomb;
        this.nearbyBombCount = surrounding;
    }

    public void becomeBomb(){
        this.isBomb = true;
    }
    public void countBombs(){//

    }

    public void printNearbyBombs(){//prints to console
        System.out.println(this.nearbyBombCount);
    }

    public void printIsBomb(){
        System.out.println(this.isBomb);
    }
}
