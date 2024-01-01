package miscellaneous.FrontController;


//调度器，负责分发相应的页面
public class Dispatcher {
    private CustomerView customerView;
    private ManagerView managerView;
    public Dispatcher(){
        customerView = new CustomerView();
        managerView = new ManagerView();
    }

    //判断应该展示哪个视图
    public void dispatch(String request){
        if(request.equals("游客")){
            customerView.show();
        }else if(request.equals("管理员")){
            managerView.show();
        }else{
            System.out.println("404 Not Found");
        }
    }
}
