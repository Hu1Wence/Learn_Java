public class seqList {
    private int num = 10;
    private int[] data = new int[num];
    private int size = 0;
    // 打印顺序表
    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < this.size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > size) {
            //判断输入合法性
            System.out.println("您的操作有误！请重新输操作!");
            return;
        } else if (size >= num) {
            //如果表已满需要对表进行扩容
            addList();
            System.out.println("内容已满！已经扩容10个，请重新操作!");
            return;
        } else if (pos == size) {
            //在最后位置新增元素
            this.data[pos] = data;
            size++;
        } else {
            //在中间位置新增元素
            for (int i = size - 1; i < pos; i--) {
                this.data[i + 1] = this.data[i];
            }
            this.data[pos] = data;
            size++;
        }
    }

    //扩容10个元素
    public void addList() {
        num = num + 10;
        int[] data = new int[num];
        for (int i = 0 ; i < size; i++) {
            data[i] = this.data[i];
        }
        this.data = data;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < size; i++) {
            if (data[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public void search(int toFind) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (data[i] == toFind) {
                System.out.println("位置是:" + i);
            }
        }
        if ( i >= size) {
            //如果i >= size 说明目标元素不存在
            System.out.println(toFind + "不存在");
        }
    }

    // 获取 pos 位置的元素
    public void getPos(int pos) {
        if (pos < 0 || pos > size) {
            //判断位置合法性
            System.out.println("您的操作有误!请重新操作");;
        } else {
            System.out.println(pos + " 位置的元素是" + data[pos]);
        }
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos > size) {
            //判断位置合法性
            System.out.println("您的操作有误,请重新操作!");
        } else {
            this.data[pos] = value;
            System.out.println("设置成功!");
        }
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if (data[size] == toRemove) {
            //如果刚好是最后一个元素，只需data有效范围 -1
            size--;
            System.out.println("删除成功");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == toRemove) {
                //找到第一次出现的位置
                for (int j = i; j < size - 1; j++) {
                    //从后往前移动数据
                    data[j] = data[j + 1];
                }
                size--;
            }
        }
    }

    // 获取顺序表长度
    public int size() {
        return size;
    }

    // 清空顺序表
    public void clear() {
        size = 0;
        int[] data = new int[size];
        this.data = data;
        System.out.println("清空成功");
    }
}
