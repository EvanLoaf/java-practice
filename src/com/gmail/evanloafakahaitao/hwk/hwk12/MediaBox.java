package com.gmail.evanloafakahaitao.hwk.hwk12;

public class MediaBox {

    private Volume volume;

    public MediaBox(Volume volume) {
        this.volume = volume;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public void increaseVolume() {
        if (volume == Volume.HIGH) {
            System.out.println("Its already max volume");
        } else if (volume == Volume.MEDIUM){
            volume = Volume.HIGH;
        } else volume = Volume.MEDIUM;
    }

    public void lowerVolume() {
        if (volume == Volume.LOW) {
            System.out.println("Its already min volume");
        } else if (volume == Volume.MEDIUM){
            volume = Volume.LOW;
        } else volume = Volume.MEDIUM;
    }
}
