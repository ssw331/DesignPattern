package FrontController;

/**
 * 创建前端控制器
 */
public class FrontController {
    private Dispatcher dispatcher;

    public FrontController(){
        dispatcher = new Dispatcher();
    }

    /**
     * 判断登录人员是否合法
     * @return 合法或不合法
     */
    private boolean isAuthenticUser(String people){
        if(people.equals("顾客")||people.equals("管理员")) {
            System.out.println("User is authenticated successfully.");
            return true;
        } else{
            return false;
        }

    }

    /**
     * 追踪请求的是哪个界面以及是何人请求
     * @param request 请求的界面
     * @param userType 发出请求的用户
     */
    private void trackRequest(String request,String userType){
        System.out.println("Page requested: " + request);
        System.out.println("UserType:" + userType);
    }

    /**
     * 拉取界面
     * @param request 请求界面
     * @param userType 用户类型
     */
    public void dispatchRequest(String request,String userType){
        //记录每一个请求
        trackRequest(request,userType);
        //对用户进行身份验证，由调度器拉取指定界面
        if(isAuthenticUser(userType)){
            if(userType.equals(request)) {
                dispatcher.dispatch(request);
            }
            else{
                System.out.println("无法访问");
            }
        }else{
            System.out.println("不是合法用户,退出.");
        }
    }
}
