

public class Love {


    public static void main(String[] args) {
//        外层循环，控制层数
        for(float i = 1.5f;i>-1.5f;i -= 0.15f) {
//            内层循环，控制大小
            for(float j = -1.5f;j<1.5f;j+=0.05f) {
                float a = i*i+j*j-1;
                String str = (a*a*a-j*j*i*i*i) <= 0.0f ? "*" :" ";
                System.out.print(str);
            }
            System.out.println("");
        }
//
    }
}
