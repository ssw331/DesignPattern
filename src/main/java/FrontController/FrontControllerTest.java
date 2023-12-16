package FrontController;

public class FrontControllerTest {
    public static void main(String[] args) {
        frontControllerTest();
    }
    public static void frontControllerTest(){
        FrontController frontController = new FrontController();
        System.out.println("*****************************【前端控制器模式展示】****************************");
        System.out.println("前端控制器模式是用来提供一个集中的请求处理机制，所有的请求都将由一个单一的处理程序处理。");
        System.out.println("接下来，我们使用不同身份访问不同界面感受前端控制器模式的使用");
        System.out.println("当身份识别不出来、请求的界面不存在、身份和请求界面不匹配时，界面都不会正常展示。");
        System.out.println("只有当身份和请求的界面类型匹配时可以访问对应界面。");
        System.out.println("************************************************************************");
        System.out.println("下面来展示实际业务中前端控制器模式的使用。");
        System.out.println("----------------------FrontController Pattern Test Start--------------------");
        frontController.dispatchRequest("游客","游客");
        frontController.dispatchRequest("管理员","管理员");
        frontController.dispatchRequest("管理员","游客");//游客不能访问管理员界面
        frontController.dispatchRequest("unknown","管理员");
        frontController.dispatchRequest("游客","其他人员");
        System.out.println("----------------------FrontController Pattern Test End--------------------");
    }
}
