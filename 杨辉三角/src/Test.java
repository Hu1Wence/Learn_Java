import java.util.ArrayList;
import java.util.List;

public class Test {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows < 1) {
            //如果小于 1 行，直接返回
            return list;
        }

        //list 里面装的还是一个集合
        list.add(new ArrayList<>());
        //先添加一个1 相当于 [ [1] ]
        list.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            //要添加的新的一行
            List<Integer> row = new ArrayList<>();
            //保存要添加新的一行的上一行
            List<Integer> prevRow = list.get(i - 1);

            //先添加一个 1
            row.add(1);
            for (int j = 1; j < i; j++) {
                //添加上一行的当前位置元素和前一个元素的和
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            //添加每一行的最后一个 1
            row.add(1);
            //添加到集合中去
            list.add(row);
        }

        return list;
    }
}
