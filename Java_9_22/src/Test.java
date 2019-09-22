public class Test {
    public static void main(String[] args) {
        seqList seqlist = new seqList();
        {
            //测试增加
            seqlist.add(0,0);
            seqlist.add(1,1);
            seqlist.add(2,2);
            seqlist.add(3,20);
            seqlist.add(4,4);
            seqlist.add(5,5);
            seqlist.add(6,6);
            seqlist.add(7,7);
            seqlist.add(8,8);
            seqlist.add(9,9);
            seqlist.add(10,10);
            seqlist.add(10,10);
            seqlist.display();
        }
        {
            //测试是否有无数字
            System.out.println(seqlist.contains(20));
        }
        {
            //测试对应位置元素
            seqlist.search(3);
        }
        {
            //测试对应元素的位置
            seqlist.getPos(3);
        }
        {
            //测试对应位置重新赋值
            seqlist.setPos(3, -1);
            seqlist.display();
        }
        {
            //测试顺序表长度
            System.out.println(seqlist.size());
        }
        {
            //测试清空顺序表
            seqlist.clear();
            seqlist.display();
        }
    }
}
