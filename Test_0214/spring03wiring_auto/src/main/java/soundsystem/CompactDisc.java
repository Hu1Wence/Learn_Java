package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class CompactDisc {

    public CompactDisc() {
        super();
        System.out.println("CompactDisc无参构造函数");
    }

    public void play() {
        System.out.println("正在播放音乐...");
    }
}
