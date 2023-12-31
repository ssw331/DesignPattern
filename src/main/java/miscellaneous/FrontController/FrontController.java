package miscellaneous.FrontController;

//前端控制器
public class FrontController {
    private Dispatcher dispatcher;

    public FrontController(){
        dispatcher = new Dispatcher();
    }

    private boolean isValidUser(String people){
        if(people.equals("游客")||people.equals("管理员")) {
            System.out.println("该用户身份合法");
            return true;
        } else{
            return false;
        }
    }

    //追踪请求的页面和请求者身份
    private void trackRequest(String request,String userType){
        System.out.println("Page requested: " + request);
        System.out.println("UserType:" + userType);
    }

    //获取页面
    public void dispatchRequest(String request,String userType){
        //记录每一个请求
        trackRequest(request,userType);
        //对用户进行身份验证，由调度器拉取指定界面
        if(isValidUser(userType)){
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
