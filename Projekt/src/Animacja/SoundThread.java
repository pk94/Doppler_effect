package Animacja;

import javax.sound.sampled.LineUnavailableException;

class SoundThread extends Thread{
    final int threadId;
    animationPanel pan;
    public SoundThread(int threadId,animationPanel Pan) {
        super();
        pan=Pan;
        this.threadId = threadId;
    }
    @Override
    public void run() {
    	try {
    		while(true)
			Sound.beep(pan.frequency, 500);
		} catch (InterruptedException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}