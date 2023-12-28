package Adapter;

public class testAdapter {
    public void AdapterTest() {
        System.out.println("适配器模式测试：游客游玩过山车前需要系好安全带");
        System.out.println("适配器体现：将attraction接口中定义的前置操作接口转换成易于游客使用的接口prepareAndCheck");

        Attraction rollerCoaster = new RollerCoaster();
        AttractionAdapter adapter = new AttractionAdapter(rollerCoaster);

        // 使用适配器准备并检查游乐项目
        if (adapter.prepareAndCheck()) {
            System.out.println("准备工作已完成，可以使用该游乐设施.");
        } else {
            System.out.println("准备工作未完成，不可以使用该游乐设施.");
        }
    }
}
