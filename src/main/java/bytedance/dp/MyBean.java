package bytedance.dp;

import lombok.Data;

@Data
public class MyBean {
    private Integer name;


    public static void main(String[] args) {
        MyBean bean = new MyBean();



        bean.setName(123);
        System.out.println(bean.getName());


    }
}
