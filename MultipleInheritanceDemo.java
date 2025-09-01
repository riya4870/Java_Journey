interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic(String song);
}

interface Internet {
    void browseWeb(String website);
}

class SmartPhone implements Camera, MusicPlayer, Internet {
    private String brand;

    public SmartPhone(String brand) {
        this.brand = brand;
    }

    public void takePhoto() {
        System.out.println(brand + " takes a high-resolution photo");
    }

    public void playMusic(String song) {
        System.out.println(brand + " is playing: " + song);
    }

    public void browseWeb(String website) {
        System.out.println(brand + " is browsing: " + website);
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone("Galaxy");

        phone.takePhoto();
        phone.playMusic("Shape of You");
        phone.browseWeb("www.example.com");
    }
}

