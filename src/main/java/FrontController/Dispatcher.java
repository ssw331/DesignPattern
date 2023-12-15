package FrontController;


/**
 * 创建调度器
 */
public class Dispatcher {
    private CustomerView customerView;
    private ManagerView managerView;
    public Dispatcher(){
        customerView = new CustomerView();
        managerView = new ManagerView();
    }

    /**
     * 判断需要进入哪个视图中
     * @param request 为request创建指定视图
     */
    public void dispatch(String request){
        if(request.equalsIgnoreCase("顾客")){
            customerView.show();
        }else if(request.equalsIgnoreCase("管理员")){
            managerView.show();
        }else{
            System.out.println("404 Not Found");
        }
    }
}
