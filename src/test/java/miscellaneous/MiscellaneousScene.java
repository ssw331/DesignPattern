package miscellaneous;

import java.util.Scanner;
public class MiscellaneousScene {
    public static void main(String[] args) {
        new MiscellaneousScene().integrationTest();
    }
    private final DependencyInjectionTest DI=new DependencyInjectionTest();
    private final testAdapter adapter=new testAdapter();
    private final VisitorPatternTest visitor=new VisitorPatternTest();
    private final StatePatternTest state=new StatePatternTest();
    private final ProxyPatternTest proxy=new ProxyPatternTest();
    private final FrontControllerTest fc=new FrontControllerTest();
    private final DataAccessObjectTest dao=new DataAccessObjectTest();
    private final TransferObjectTest dto=new TransferObjectTest();
    public void integrationTest(){
        System.out.println("欢迎访问游乐园，以下为其他设计模式的集成测试");
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("----------------请输入相应数字选择要测试的设计模式----------------");
            System.out.println("1.DependencyInjection");
            System.out.println("2.Adapter");
            System.out.println("3.Visitor");
            System.out.println("4.State");
            System.out.println("5.Proxy");
            System.out.println("6.FrontController");
            System.out.println("7.DataAccessObject");
            System.out.println("8.TransferObject");
            System.out.println("-----------------------输入数字0即可退出------------------------");
            int input=sc.nextInt();
            switch (input){
                case 0:
                    System.out.println("集成测试已结束");
                    return;
                case 1:
                    DI.DITest();
                    break;
                case 2:
                    adapter.AdapterTest();
                    break;
                case 3:
                    visitor.VisitorTest();
                    break;
                case 4:
                    state.StateTest();
                    break;
                case 5:
                    proxy.ProxyText();
                    break;
                case 6:
                    fc.frontControllerTest();
                    break;
                case 7:
                    dao.dataAccessObjectTest();
                    break;
                case 8:
                    dto.transferObjectTest();
                    break;
                default:
                    break;
            }
        }
    }
}
