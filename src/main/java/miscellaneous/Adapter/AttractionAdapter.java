package miscellaneous.Adapter;
/*适配器用于将attraction接口中定义的前置操作接口转换成易于游客使用的接口prepareAndCheck*/
public class AttractionAdapter {
    private Attraction attraction;

    public AttractionAdapter(Attraction attraction) {
        this.attraction = attraction;
    }

    public boolean prepareAndCheck() {
        attraction.prepare();
        return attraction.isSafetyChecked();
    }
}
