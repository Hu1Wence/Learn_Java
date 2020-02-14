package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {

    private CompactDisc cd;

    public CDPlayer() {
        super();
        System.out.println("CDPlayer无参构造函数");
    }

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
        System.out.println("CDPlayer有参构造函数");
    }

    public void play() {
        cd.play();
    }
}
